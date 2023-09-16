package org.m2i.app_gestion_financiere.screen.transaction

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.m2i.app_gestion_financiere.model.Transaction
import org.m2i.app_gestion_financiere.repository.TransactionRepository
import javax.inject.Inject

//@HiltViewModel
class TransactionViewModel @Inject constructor(private val repository: TransactionRepository): ViewModel() {

    val _transactionsList = MutableStateFlow<List<Transaction>>(emptyList())
    val transactionsList = _transactionsList.asStateFlow()

    // Using LiveData and caching what allWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allTransactions: LiveData<List<Transaction>> = repository.allTransactions.asLiveData()

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(transaction: Transaction) = viewModelScope.launch {
        repository.insert(transaction)
    }

    init {
        getAllTrans()
    }

    fun getAllTrans() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.allTransactions.distinctUntilChanged()
                .collect{listOfTransactions ->
                    if (listOfTransactions.isNullOrEmpty()){
                        Log.d("TAG", "Empty List")
                    } else {
                        _transactionsList.value = listOfTransactions
                        Log.d("TAG", "NO Empty List")
                    }
                }
        }
    }

}

class TransactionViewModelFactory(private val repository: TransactionRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TransactionViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TransactionViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
