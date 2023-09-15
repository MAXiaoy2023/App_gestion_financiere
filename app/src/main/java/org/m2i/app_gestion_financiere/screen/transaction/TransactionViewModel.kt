package org.m2i.app_gestion_financiere.screen.transaction

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import org.m2i.app_gestion_financiere.model.Transaction
import org.m2i.app_gestion_financiere.repository.TransactionRepository
import javax.inject.Inject

@HiltViewModel
class TransactionViewModel @Inject constructor(private val repository: TransactionRepository): ViewModel(){
    private val _transactionsList = MutableStateFlow<List<Transaction>>(emptyList())
    val transactionsList = _transactionsList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllTransactions().distinctUntilChanged()
                .collect{ listOfTransactions ->
                    if (listOfTransactions.isNullOrEmpty()){
                        Log.d("TAG", "Empty List")
                    }else{
                        _transactionsList.value = listOfTransactions
                    }
                }
        }
    }
    fun addTransaction(transaction: Transaction) = viewModelScope.launch { repository.addTransaction(transaction = transaction) }
}