package org.m2i.app_gestion_financiere.data.transaction

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.m2i.app_gestion_financiere.model.Transaction

@Dao
interface TransactionDao {

    @Query("SELECT * from transactions_tbl")
    fun getTransactions(): Flow<List<Transaction>>

    @Query("SELECT * from transactions_tbl where id = :id")
    suspend fun getTransactionById(id:String): Transaction

/*    @Query("SELECT * from transactions_tbl where date = :date")
    suspend fun getTransactionsByDate(date:String): Transaction*/

    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun insert(transaction: Transaction)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(transaction: Transaction)

    @Delete
    suspend fun delete(transaction: Transaction)

    @Query("DELETE from transactions_tbl")
    suspend fun deleteAll()
}