package org.m2i.app_gestion_financiere.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.m2i.app_gestion_financiere.model.Budget

@Composable
fun BudgetRow(modifier: Modifier = Modifier,
              budget: Budget
) {
    Surface(
        modifier
            .padding(2.dp)
            .fillMaxWidth(),
        color = Color.White,
        shadowElevation = 3.dp
    ) {
        Row(
            modifier.padding(horizontal = 10.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = budget.title, style = MaterialTheme.typography.bodyMedium)
            Text(text = budget.sumInit, style = MaterialTheme.typography.bodyMedium)
            Text(text = budget.sumFinal, style = MaterialTheme.typography.bodyMedium)
            Text(text = budget.gap, style = MaterialTheme.typography.bodyMedium)

        }
    }
}