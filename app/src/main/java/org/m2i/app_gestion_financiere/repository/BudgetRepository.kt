package org.m2i.app_gestion_financiere.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import org.m2i.app_gestion_financiere.data.budget.BudgetDatabaseDao
import org.m2i.app_gestion_financiere.model.Budget
import javax.inject.Inject

class BudgetRepository @Inject constructor(private val budgetDatabaseDao: BudgetDatabaseDao) {
    suspend fun addBudget(budget: Budget) = budgetDatabaseDao.insert(budget)
    suspend fun updateBudget(budget: Budget) = budgetDatabaseDao.insert(budget)
    suspend fun deleteBudget(budget: Budget) = budgetDatabaseDao.insert(budget)
    suspend fun  deleteAllBudgets() = budgetDatabaseDao.deleteAll()
    fun getAllBudgets(): Flow<List<Budget>> = budgetDatabaseDao.getBudgets().flowOn(Dispatchers.IO).conflate()
}