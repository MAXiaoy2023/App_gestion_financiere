package org.m2i.app_gestion_financiere.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.m2i.app_gestion_financiere.model.Transaction

@Composable
fun TransactionRow(modifier: Modifier = Modifier,
                   transaction: Transaction
) {
    Surface(
        modifier
            .padding(2.dp)
            .fillMaxWidth(),
        color = Color.White,
        shadowElevation = 3.dp
    ){
        Row (modifier.padding(horizontal = 10.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceAround){
            Text(text = transaction.title, style = MaterialTheme.typography.bodyMedium)
            Text(text = transaction.type, style = MaterialTheme.typography.bodyMedium)
            Text(text = transaction.category, style = MaterialTheme.typography.bodyMedium)
            Text(text = transaction.amount, style = MaterialTheme.typography.bodyMedium)
        }

    }

}