package org.m2i.app_gestion_financiere.data.budget

import org.m2i.app_gestion_financiere.model.Budget

class BudgetDataSource {
    fun listBudgets(): List<Budget>{
        return listOf(
            Budget(title = "Séjour en Espagne", sumInit = "800€", sumFinal = "", gap = ""),
            Budget(title = "Achat frigo", sumInit = "1000€", sumFinal = "", gap = ""),
            Budget(title = "Cours de piano", sumInit = "500€", sumFinal = "", gap = "")
        )
    }
}