package org.m2i.app_gestion_financiere.screen.budget

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import org.m2i.app_gestion_financiere.model.Budget
import org.m2i.app_gestion_financiere.repository.BudgetRepository
import javax.inject.Inject

//@HiltViewModel
class BudgetViewModel @Inject constructor(private val repository: BudgetRepository) : ViewModel() {
    private val _budgetsList = MutableStateFlow<List<Budget>>(emptyList())
    val budgetList = _budgetsList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllBudgets().distinctUntilChanged()
                .collect{listOfBudgets ->
                    if (listOfBudgets.isNullOrEmpty()){
                        Log.d("TAG", "Empty List")
                    }else{
                        _budgetsList.value = listOfBudgets
                    }
                }
        }
    }
    fun addBudget(budget: Budget) = viewModelScope.launch { repository.addBudget(budget = budget) }
}
