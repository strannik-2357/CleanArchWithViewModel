package com.alex.mymvvm.data.source.db.category

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.alex.mymvvm.data.source.db.category.model.CategoryDbModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface CategoryDao {

    @Query("SELECT * FROM category")
    fun getAll(): Single<List<CategoryDbModel>>

    @Insert
    fun insertAll(list: List<CategoryDbModel>): Completable

    @Query("DELETE FROM category")
    fun deleteAll(): Completable

}
