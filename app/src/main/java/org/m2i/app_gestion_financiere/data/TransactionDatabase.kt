package org.m2i.app_gestion_financiere.data

import androidx.room.Database
import androidx.room.RoomDatabase
import org.m2i.app_gestion_financiere.model.Transaction


@Database(entities = [Transaction::class], version = 1, exportSchema = false)
abstract class TransactionDatabase : RoomDatabase() {
    abstract fun transactionDao(): TransactionDatabaseDao
}