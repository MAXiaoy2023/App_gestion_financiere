package org.m2i.app_gestion_financiere.data.transaction

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.m2i.app_gestion_financiere.model.Transaction

@Database(entities = [Transaction::class], version = 1, exportSchema = false)
abstract class TransactionDatabase : RoomDatabase() {

    abstract fun transactionDao(): TransactionDao

    private class WordDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var transactionDao = database.transactionDao()

                    // Delete all content here
                    transactionDao.deleteAll()

                    // Add 5 transactions
                    var transaction1 = Transaction(title = "Hotel à Paris", type = "Dépenses", category = "Voyage", amount = "200€", date="01/09/2023")
                    var transaction2 = Transaction(title = "Achat pantalon", type = "Dépenses", category = "Shopping", amount = "30€", date="02/09/2023")
                    var transaction3 = Transaction(title = "Achat légumes", type = "Dépenses", category = "Alimentation", amount = "10€", date="01/08/2023")
                    var transaction4 = Transaction(title = "Virement de l'entreprise", type = "Revenus", category = "Salaire", amount = "2500€", date="01/07/2023")
                    var transaction5 = Transaction(title = "SRD AIRBUS", type = "Investissements", category = "Bourse", amount = "600€", date="01/06/2023")

                    transactionDao.insert(transaction1)
                    transactionDao.insert(transaction2)
                    transactionDao.insert(transaction3)
                    transactionDao.insert(transaction4)
                    transactionDao.insert(transaction5)
                }
            }
        }
    }

    companion object {
        // Singleton prevents multiple instances of database opening at the same time
        @Volatile
        private var INSTANCE: TransactionDatabase? = null

        fun getTransactionDB(context: Context, scope: CoroutineScope): TransactionDatabase {
            // if the INSTANCE is not null, then return it
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TransactionDatabase::class.java,
                    "transaction_db"
                ).addCallback(WordDatabaseCallback(scope)).build()
                INSTANCE = instance

                // return instance
                instance
            }
        }
    }

}
