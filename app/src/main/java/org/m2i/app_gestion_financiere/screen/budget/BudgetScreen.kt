package org.m2i.app_gestion_financiere.screen.budget

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.m2i.app_gestion_financiere.components.BudgetRow
import org.m2i.app_gestion_financiere.data.budget.BudgetDataSource
import org.m2i.app_gestion_financiere.navigation.GFScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BudgetScreen(navController: NavController){
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
                    onClick = {navController.navigate(GFScreens.TransactionScreen.name) },
                    icon = { Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Transaction")},
                    label = { Text(text = "Transaction")}
                )
                NavigationBarItem(
                    selected = true,
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
                    selected = false,
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
                .width(400.dp)
                .height(100.dp)
                .padding(5.dp),
                shape = RectangleShape,
                border = BorderStroke(width = 2.dp, color = Color(0xFFE7B7EF)),
                color = Color.White,
                shadowElevation = 6.dp
            ) {
                Column(
                    modifier = Modifier
                        //.padding(paddingValues)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Surface (modifier = Modifier
                        .width(400.dp)
                        .height(30.dp)
                        .padding(2.dp),
                        shape = RectangleShape,
                        color = Color(0xFFE7B7EF),
                        shadowElevation = 3.dp
                    ){
                        Row (modifier = Modifier.padding(1.dp),
                            horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.CenterVertically){
                            Text(text = "Budget total",
                                color = Color.White,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center )
                            Spacer(modifier = Modifier.padding(1.dp))
                            Text(text = "Dépense Réelle",
                                color = Color.White,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center)
                            Spacer(modifier = Modifier.padding(1.dp))
                            Text(text = "Ecart ",
                                color = Color.White,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center)
                        }

                    }

                }
            }
            Surface(modifier = Modifier
                .size(400.dp)
                .padding(5.dp),
                shape = RectangleShape,
                border = BorderStroke(width = 2.dp, color = Color(0xFFE7B7EF)),
                color = Color.White,
                shadowElevation = 6.dp
            ) {
                Column(
                    modifier = Modifier
                        //.padding(paddingValues)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Surface (modifier = Modifier
                        .width(400.dp)
                        .height(30.dp)
                        .padding(2.dp),
                        shape = RectangleShape,
                        color = Color(0xFFE7B7EF),
                        shadowElevation = 3.dp
                    ){
                        Row (modifier = Modifier.padding(1.dp),
                            horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.CenterVertically){
                            Text(text = "Sujet",
                                color = Color.White,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center )
                            Spacer(modifier = Modifier.padding(1.dp))
                            Text(text = "Budget prévu",
                                color = Color.White,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center)
                            Spacer(modifier = Modifier.padding(1.dp))
                            Text(text = "Dépense réelle ",
                                color = Color.White,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center)
                            Spacer(modifier = Modifier.padding(1.dp))
                            Text(text = "Ecart",
                                color = Color.White,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center
                            )
                        }

                    }

                    LazyColumn{
                        items(BudgetDataSource().listBudgets()){budget ->
                            BudgetRow(budget = budget)
                        }
                    }
                }
            }

                Button(colors = ButtonDefaults.buttonColors(Color(0xFF9579C6)),
                    onClick = { navController.navigate(GFScreens.AjouterBudgetScreen.name) }) {
                    Text(text = "Plannifier un budget")
                }
        }
    }
}

/*
@Preview
@Composable
fun BudgetScreenPreview(){
    BudgetScreen(navController = NavController(LocalContext.current))
}*/
