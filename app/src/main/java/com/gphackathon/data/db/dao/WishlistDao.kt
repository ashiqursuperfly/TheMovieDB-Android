package com.gphackathon.data.db.dao

import androidx.room.*
import com.gphackathon.data.Const
import com.gphackathon.data.models.local.WishlistEntity


/*
 * Created by :
 * <a href="https://www.github.com/ashiqursuperfly">Ashiqur Rahman</a> on 12/8/20.
*/

@Dao
interface WishlistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(record: WishlistEntity): Long

    @Delete
    fun delete(record: WishlistEntity): Int

    @Query("SELECT * FROM " + Const.DB.TABLE_NAME.WISHLIST + " WHERE id=:id")
    fun get(id: Int): WishlistEntity?

    @Query("SELECT * FROM " + Const.DB.TABLE_NAME.WISHLIST)
    fun getAll(): List<WishlistEntity?>


    /* @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insert(record: LocalCaptureRecord): Long

     @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertAll(record: List<LocalCaptureRecord>): LongArray

     @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertAll(vararg record: LocalCaptureRecord): LongArray

     @Update
     fun update(record: LocalCaptureRecord): Int

     @Delete
     fun delete(record: LocalCaptureRecord): Int

     @Query("SELECT * FROM " + Const.DB.TABLE_NAME.LOCAL_CAPTURE_RECORD)
     fun getAll(): List<LocalCaptureRecord>*/

}