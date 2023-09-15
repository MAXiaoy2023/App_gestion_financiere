package org.m2i.app_gestion_financiere

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import org.m2i.app_gestion_financiere.navigation.GFNavigation
import org.m2i.app_gestion_financiere.ui.theme.App_gestion_financiereTheme

class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App_gestion_financiereTheme {
               /* val db = FirebaseFirestore.getInstance()
                val user: MutableMap<String, Any> = HashMap();
                user["firstName"] = "Julia"
                user["lastName"] = "Roulet"
                db.collection("users")
                    .add(user)
                    .addOnSuccessListener {
                        Log.d("UserAdd", "OnCreate $it" )
                    }.addOnFailureListener{
                        Log.d("UserAdd", "OnCreate $it" )
                    }*/
                GFApp()
            }

        }
    }
}

@Composable
fun GFApp() {
    Surface(color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            GFNavigation()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    App_gestion_financiereTheme {
        GFApp()
    }
}
