package org.m2i.app_gestion_financiere.repository

import androidx.annotation.WorkerThread
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import org.m2i.app_gestion_financiere.data.transaction.TransactionDao
import org.m2i.app_gestion_financiere.model.Transaction
import javax.inject.Inject

class TransactionRepository @Inject constructor (private val transactionDao: TransactionDao) {

    val allTransactions: Flow<List<Transaction>> = transactionDao.getTransactions()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(transaction: Transaction) {
       transactionDao.insert(transaction)
    }

    suspend fun addTransaction(transaction: Transaction) = transactionDao.insert(transaction)
    suspend fun updateTransaction(transaction: Transaction) = transactionDao.update(transaction)
    suspend fun deleteTransaction(transaction: Transaction) = transactionDao.delete(transaction)
    suspend fun deleteAllTransactions() = transactionDao.deleteAll()

/*    fun getAllTransactions() : Flow<List<Transaction>> = transactionDao.getTransactions().flowOn(
        Dispatchers.IO).conflate()*/
    //fun getTransactionsByDate() : Flow<List<Transaction>> = transactionDao.getTransactionByDate().flowOn(Dispatchers.IO).conflate()


/*    fun getListTransactions(): List<Transaction> {
        return listOf(
            Transaction(title = "Hotel à Paris", type = "Dépenses", category = "Voyage", amount = "200€", date="01/09/2023"),
            Transaction(title = "Achat pantalon", type = "Dépenses", category = "Shopping", amount = "30€", date="02/09/2023"),
            Transaction(title = "Achat légumes", type = "Dépenses", category = "Alimentation", amount = "10€", date="01/08/2023"),
            Transaction(title = "Virement de l'entreprise", type = "Revenus", category = "Salaire", amount = "2500€", date="01/07/2023"),
            Transaction(title = "SRD AIRBUS", type = "Investissements", category = "Bourse", amount = "600€", date="01/06/2023")
        )
    }*/

}