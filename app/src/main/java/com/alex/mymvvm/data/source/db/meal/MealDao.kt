package com.alex.mymvvm.data.source.db.meal

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.alex.mymvvm.data.source.db.meal.model.MealDbModel
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

@Dao
interface MealDao {

    @Query("SELECT * FROM meal WHERE (category LIKE :category) ORDER BY title")
    fun getAllByCategory(category: String): Single<List<MealDbModel>>

    @Insert
    fun insertAll(list: List<MealDbModel>)

    @Query("DELETE FROM meal WHERE category LIKE :category")
    fun deleteMealsByCategory(category: String)

    @Query("SELECT * FROM meal WHERE id = :id")
    fun getMeal(id: Long): Maybe<MealDbModel>

}
