package com.example.wmsplus

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InventoryList(items: List<InventoryItem>, filterCategory: String) {
    Column(modifier = Modifier.padding(16.dp)) {
        items.filter { it.category == filterCategory || filterCategory.isBlank() }
            .forEach { item ->
                Column(modifier = Modifier.padding(8.dp)) {
                    BasicText(text = "Name: ${item.name}")
                    BasicText(text = "Category: ${item.category}")
                    BasicText(text = "Quantity: ${item.quantity}")
                    BasicText(text = "Location: ${item.location}")
                    BasicText(text = "Seller: ${item.seller}")
                    BasicText(text = "Origin: ${item.origin}")
                    BasicText(text = "Price: ${item.price}")
                    BasicText(text = "Date Added: ${item.dateAdded}")
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
    }
}
