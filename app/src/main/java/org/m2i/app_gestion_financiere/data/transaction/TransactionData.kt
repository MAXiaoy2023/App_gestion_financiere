package org.m2i.app_gestion_financiere.data.transaction

import org.m2i.app_gestion_financiere.model.Transaction

class TransactionDataSource {
    fun listTransactions(): List<Transaction> {
        return listOf(
            Transaction(title = "Hotel à Paris", type = "Dépenses", category = "Voyage", amount = "200€", date="01/09/2023"),
            Transaction(title = "Achat pantalon", type = "Dépenses", category = "Shopping", amount = "30€", date="02/09/2023"),
            Transaction(title = "Achat légumes", type = "Dépenses", category = "Alimentation", amount = "10€", date="01/08/2023"),
            Transaction(title = "Virement de l'entreprise", type = "Revenus", category = "Salaire", amount = "2500€", date="01/07/2023"),
            Transaction(title = "SRD AIRBUS", type = "Investissements", category = "Bourse", amount = "600€", date="01/06/2023")
        )
    }

}