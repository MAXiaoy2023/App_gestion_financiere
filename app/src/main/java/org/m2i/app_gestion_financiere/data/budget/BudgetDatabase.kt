package org.m2i.app_gestion_financiere.data.budget

import androidx.room.Database
import androidx.room.RoomDatabase
import org.m2i.app_gestion_financiere.model.Budget

@Database(entities = [Budget::class], version = 1, exportSchema = false)
abstract class BudgetDatabase : RoomDatabase() {
    abstract fun budgetDao(): BudgetDatabaseDao
}