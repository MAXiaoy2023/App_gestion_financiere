package org.m2i.app_gestion_financiere.data.budget

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.m2i.app_gestion_financiere.model.Budget

@Dao
interface BudgetDatabaseDao {
    @Query("SELECT * from budgets_tbl")
    fun getBudgets(): Flow<List<Budget>>
    @Query("SELECT * from budgets_tbl where id=:id")
    suspend fun  getBudgetById(id:String): Budget
    @Query("DELETE from budgets_tbl")
    suspend fun deleteAll()
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun insert(budget: Budget)
    @Update(onConflict= OnConflictStrategy.REPLACE)
    suspend fun update(budget: Budget)
    @Delete
    suspend fun deleteBudget(budget: Budget)


}