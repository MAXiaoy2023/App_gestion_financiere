package org.m2i.app_gestion_financiere.navigation

import java.lang.IllegalArgumentException

enum class GFScreens {
    SplashScreen,
    HomeScreen,
    InscriptionScreen,
    ConnexionScreen,
    TransactionScreen,
    AjouterTransactionScreen,
    BudgetScreen,
    AjouterBudgetScreen,
    AlerteScreen,
    CompteScreen;

    companion object {
        fun fromRoute(route:String): GFScreens
        = when(route?.substringBefore("/")) {
            SplashScreen.name -> SplashScreen
            HomeScreen.name -> HomeScreen
            InscriptionScreen.name -> InscriptionScreen
            ConnexionScreen.name -> ConnexionScreen
            TransactionScreen.name -> TransactionScreen
            AjouterTransactionScreen.name -> AjouterTransactionScreen
            BudgetScreen.name -> BudgetScreen
            AjouterBudgetScreen.name ->AjouterTransactionScreen
            AlerteScreen.name -> AlerteScreen
            CompteScreen.name -> CompteScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")

        }
    }
}