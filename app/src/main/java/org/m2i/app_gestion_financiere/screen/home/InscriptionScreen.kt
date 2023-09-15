package org.m2i.app_gestion_financiere.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.m2i.app_gestion_financiere.navigation.GFScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InscriptionScreen(navController: NavController){
    Scaffold (topBar = {
        CenterAlignedTopAppBar(title = { Text(text = "Gestion Financière",
            color = Color(0xFF9579C6) ) },
            navigationIcon = {Surface(modifier = Modifier
                .padding(5.dp)
                .size(35.dp),
                shape = CircleShape,
                color = Color(0xFF9579C6),
                shadowElevation = 6.dp
            ){
                Text(text = "GF",
                    color = Color.White,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Monospace)
            }})
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

                    Text(text = "Espace Inscription",
                        color = Color.DarkGray,
                        fontSize = 26.sp,
                        textAlign = TextAlign.Center )
                    Spacer(modifier = Modifier.padding(10.dp))

            Row (modifier = Modifier.padding(10.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.Bottom){

                Button(colors = ButtonDefaults.buttonColors(Color(0xFF9579C6)),
                    onClick = { navController.navigate(GFScreens.TransactionScreen.name) }) {
                    Text(text = "S'inscrire")
                }
            }
                }
            }


        }



/*@Preview
@Composable
fun InscriptionScreenPreview(){
    InscriptionScreen()
}*/