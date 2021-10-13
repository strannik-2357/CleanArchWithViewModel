package com.alex.mymvvm.data.source.db.category.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
data class CategoryDbModel(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "image") val imageLink: String,
    @ColumnInfo(name = "description") val description: String
)
