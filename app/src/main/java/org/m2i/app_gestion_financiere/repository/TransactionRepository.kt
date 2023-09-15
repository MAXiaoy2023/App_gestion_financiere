package org.m2i.app_gestion_financiere.repository


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import org.m2i.app_gestion_financiere.data.TransactionDatabaseDao
import org.m2i.app_gestion_financiere.model.Transaction
import javax.inject.Inject

class TransactionRepository @Inject constructor(private val transactionDatabaseDao: TransactionDatabaseDao) {
    suspend fun addTransaction(transaction: Transaction) = transactionDatabaseDao.insert(transaction)
    suspend fun updateTransaction(transaction: Transaction) = transactionDatabaseDao.update(transaction)
    suspend fun deleteTransaction(transaction: Transaction) = transactionDatabaseDao.delete(transaction)
    suspend fun deleteAllTransactions() = transactionDatabaseDao.deleteAll()
    fun getAllTransactions() : Flow<List<Transaction>> = transactionDatabaseDao.getTransactions().flowOn(Dispatchers.IO).conflate()
}