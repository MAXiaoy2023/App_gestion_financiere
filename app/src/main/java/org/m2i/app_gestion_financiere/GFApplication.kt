package org.m2i.app_gestion_financiere

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.m2i.app_gestion_financiere.data.transaction.TransactionDatabase
import org.m2i.app_gestion_financiere.model.Transaction
import org.m2i.app_gestion_financiere.repository.TransactionRepository

//@HiltAndroidApp
class GFApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { TransactionDatabase.getTransactionDB(this, applicationScope) }
    val repository by lazy { TransactionRepository(database.transactionDao()) }
}
