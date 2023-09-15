package org.m2i.app_gestion_financiere.screen.compte

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.m2i.app_gestion_financiere.navigation.GFScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompteScreen(navController: NavController){
    Scaffold (topBar = {
        CenterAlignedTopAppBar(title = { Text(text = "Gestion Financière",
                                            color = Color(0xFF9579C6) ) },
            navigationIcon = { IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu",
                    tint =  Color(0xFF9579C6))

            }})
    },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate(GFScreens.TransactionScreen.name) },
                    icon = { Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Transaction")},
                    label = { Text(text = "Transaction")}
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate(GFScreens.BudgetScreen.name) },
                    icon = { Icon(imageVector = Icons.Default.Create, contentDescription = "Budget")},
                    label = { Text(text = "Budget")}
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate(GFScreens.AlerteScreen.name) },
                    icon = { Icon(imageVector = Icons.Default.Notifications, contentDescription = "Notification")},
                    label = { Text(text = "Alerte")}
                )
                NavigationBarItem(
                    selected = true,
                    onClick = { navController.navigate(GFScreens.CompteScreen.name) },
                    icon = { Icon(imageVector = Icons.Default.Person, contentDescription = "Profile")},
                    label = { Text(text = "Compte")}
                )
            }
        })
    {
            paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Surface(modifier = Modifier
                .size(400.dp)
                .padding(20.dp),
                shape = RectangleShape,
                color = Color(0xFFE7B7EF),
                shadowElevation = 6.dp
            ) {
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    /*Text(text = "Ajouter vos dépenses quotidiennes",
                        color = Color.White,
                        fontSize = 26.sp,
                        textAlign = TextAlign.Center )
                    Spacer(modifier = Modifier.padding(10.dp))
                    Text(text = "Planifier vos budgets vacances",
                        color = Color.White,
                        fontSize = 26.sp,
                        textAlign = TextAlign.Center)
                    Spacer(modifier = Modifier.padding(10.dp))
                    Text(text = "Ajouter les alertes ",
                        color = Color.White,
                        fontSize = 26.sp,
                        textAlign = TextAlign.Center)*/
                }
            }

                Button(colors = ButtonDefaults.buttonColors(Color(0xFF9579C6)),
                    onClick = { /*TODO*/ }) {
                    Text(text = "Changer le mot de passe")
            }
        }
    }
}

/*@Preview
@Composable
fun CompteScreenPreview(){
    CompteScreen()
}*/