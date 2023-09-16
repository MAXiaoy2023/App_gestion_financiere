package org.m2i.app_gestion_financiere.model

import android.icu.util.CurrencyAmount
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName="transactions_tbl")
data class Transaction(
    @PrimaryKey
    val id:UUID = UUID.randomUUID(),
    @ColumnInfo(name = "transaction_title" )
    val title: String,
    @ColumnInfo(name = "transaction_type" )
    val type: String,
    @ColumnInfo(name = "transaction_category" )
    val category: String,
    @ColumnInfo(name = "transaction_amount" )
    val amount: String,
    @ColumnInfo(name = "transaction_date" )
    val date: String?
)
