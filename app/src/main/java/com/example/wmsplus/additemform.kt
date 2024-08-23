package com.example.wmsplus
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AddItemForm(onAddItem: (InventoryItem) -> Unit) {
    var name by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var seller by remember { mutableStateOf("") }
    var origin by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = name, onValueChange = { name = it }, label = { Text("Item Name") })
        TextField(value = category, onValueChange = { category = it }, label = { Text("Category") })
        TextField(value = quantity, onValueChange = { quantity = it }, label = { Text("Quantity") })
        TextField(value = location, onValueChange = { location = it }, label = { Text("Location") })
        TextField(value = seller, onValueChange = { seller = it }, label = { Text("Seller") })
        TextField(value = origin, onValueChange = { origin = it }, label = { Text("Origin") })
        TextField(value = price, onValueChange = { price = it }, label = { Text("Price") })

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (name.isNotBlank() && category.isNotBlank() && quantity.isNotBlank() &&
                location.isNotBlank() && seller.isNotBlank() && origin.isNotBlank() && price.isNotBlank()) {

                val newItem = InventoryItem(
                    name = name,
                    category = category,
                    quantity = quantity.toInt(),
                    location = location,
                    seller = seller,
                    origin = origin,
                    price = price.toDouble(),
                    dateAdded = System.currentTimeMillis().toString()
                )
                onAddItem(newItem)
            }
        }) {
            Text("Add Item")
        }
    }
}
