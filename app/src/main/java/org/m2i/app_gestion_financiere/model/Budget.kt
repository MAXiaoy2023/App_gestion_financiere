package org.m2i.app_gestion_financiere.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "budgets_tbl")
data class Budget(
    @PrimaryKey
    val id:UUID = UUID.randomUUID(),
    @ColumnInfo(name = "budget_title")
    val title:String,
    @ColumnInfo(name = "budget_sumInit")
    val sumInit : String,
    @ColumnInfo(name = "budget_sumFinal")
    val sumFinal: String,
    @ColumnInfo(name = "budget_gap")
    val gap: String
)
