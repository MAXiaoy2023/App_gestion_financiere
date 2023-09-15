package org.m2i.app_gestion_financiere.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.m2i.app_gestion_financiere.screen.SplashScreen
import org.m2i.app_gestion_financiere.screen.alerte.AlerteScreen
import org.m2i.app_gestion_financiere.screen.budget.AjouterBudgetScreen
import org.m2i.app_gestion_financiere.screen.budget.BudgetScreen
import org.m2i.app_gestion_financiere.screen.compte.CompteScreen
import org.m2i.app_gestion_financiere.screen.home.ConnexionScreen
import org.m2i.app_gestion_financiere.screen.home.HomeScreen
import org.m2i.app_gestion_financiere.screen.home.InscriptionScreen
import org.m2i.app_gestion_financiere.screen.transaction.AjouterTransactionScreen
import org.m2i.app_gestion_financiere.screen.transaction.TransactionScreen


@Composable
fun GFNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = GFScreens.SplashScreen.name) {

        composable(GFScreens.SplashScreen.name){
            SplashScreen(navController = navController)
        }

        composable(GFScreens.HomeScreen.name){
            HomeScreen(navController = navController)
        }

        composable(GFScreens.InscriptionScreen.name){
            InscriptionScreen(navController = navController)
        }

        composable(GFScreens.ConnexionScreen.name){
            ConnexionScreen(navController = navController)
        }

        composable(GFScreens.TransactionScreen.name){
            TransactionScreen(navController = navController)
        }

        composable(GFScreens.AjouterTransactionScreen.name){
            AjouterTransactionScreen(navController = navController)
        }

        composable(GFScreens.BudgetScreen.name){
            BudgetScreen(navController = navController)
        }

        composable(GFScreens.AjouterBudgetScreen.name){
            AjouterBudgetScreen(navController = navController)
        }

        composable(GFScreens.AlerteScreen.name){
            AlerteScreen(navController = navController)
        }

        composable(GFScreens.CompteScreen.name){
            CompteScreen(navController = navController)
        }


    }
}



