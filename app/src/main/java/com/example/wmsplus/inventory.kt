package com.example.wmsplus

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase

@Entity(tableName = "inventory")
data class InventoryItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val category: String,
    val quantity: Int,
    val location: String
)


@Dao
interface InventoryDao {
    @Query("SELECT * FROM inventory WHERE category = :category")
    fun getItemsByCategory(category: String): List<InventoryItem>

    @Insert
    fun insertItem(item: InventoryItem)

    @Delete
    fun deleteItem(item: InventoryItem)
}

@Database(entities = [InventoryItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun inventoryDao(): InventoryDao
}

