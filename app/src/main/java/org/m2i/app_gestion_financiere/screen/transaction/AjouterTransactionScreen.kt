package org.m2i.app_gestion_financiere.screen.transaction

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.m2i.app_gestion_financiere.model.Transaction
import org.m2i.app_gestion_financiere.navigation.GFScreens
import org.m2i.app_gestion_financiere.repository.TransactionRepository


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AjouterTransactionScreen(navController: NavController){

    val context = LocalContext.current
    var title by remember {
        mutableStateOf("")
    }
    var type by remember {
        mutableStateOf("")
    }
    var category by remember {
        mutableStateOf("")
    }
    var amount by remember {
        mutableStateOf("")
    }

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
                    TextField(
                        value = title,
                        onValueChange = { newText ->
                            title = newText
                        },
                        label = { Text(text = "Ajouter le nom de la transaction") },
                        colors = TextFieldDefaults.textFieldColors(containerColor = Color(0xFFE7B7EF))
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    TextField(
                        value = type,
                        onValueChange = { newText ->
                            type = newText
                        },
                        label = { Text(text = "Choisir un Type") },
                        colors = TextFieldDefaults.textFieldColors(containerColor = Color(0xFFE7B7EF))
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    TextField(
                        value = category,
                        onValueChange = { newText ->
                            category = newText
                        },
                        label = { Text(text = "Ajouter une Catégorie") },
                        colors = TextFieldDefaults.textFieldColors(containerColor = Color(0xFFE7B7EF))
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    TextField(
                        value = amount,
                        onValueChange = { newText ->
                            amount = newText
                        },
                        label = { Text(text = "Ajouter le montant") },
                        colors = TextFieldDefaults.textFieldColors(containerColor = Color(0xFFE7B7EF))
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                Button(colors = ButtonDefaults.buttonColors(Color(0xFF9579C6)),
                    onClick = {navController.navigate(GFScreens.TransactionScreen.name)
                    /*if(title.isNotEmpty() && type.isNotEmpty() && category.isNotEmpty() && amount.isNotEmpty()) {
                    TransactionRepository().addTransaction(Transaction(title = title, type = type, category = category, amount = amount))
                        Toast.makeText(context, "Transaction enregistrée", Toast.LENGTH_SHORT).show()
                        title=""
                        type=""
                        category=""
                        amount=""
                        }*/
                    }) {
                    Text(text = "Enregistrer la transaction")
                }
            }
        }
    }


/*
@Preview
@Composable
fun AjouterTransactionScreenPreview(){
    AjouterTransactionScreen(navController = NavController(LocalContext.current))
}*/
