package com.alex.mymvvm.data.source.db.meal.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meal")
data class MealDbModel(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "image") val imageLink: String,
    @ColumnInfo(name = "category") val category: String
)
