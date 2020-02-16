package com.example.android.common.basedb.basedao

import androidx.room.*

@Dao
interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg t: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(list: List<T?>?)

    @Update
    fun update(vararg t: T): Int

    @Delete
    fun delete(vararg t: T): Int
}