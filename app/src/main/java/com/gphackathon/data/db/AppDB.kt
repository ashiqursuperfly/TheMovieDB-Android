package com.gphackathon.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.gphackathon.GpApp
import com.gphackathon.R
import com.gphackathon.data.Const
import com.gphackathon.data.db.dao.WishlistDao
import com.gphackathon.data.db.type_converter.DateConverter
import com.gphackathon.data.models.local.WishlistEntity


/*
 * Created by : 
 * <a href="https://www.github.com/ashiqursuperfly">Ashiqur Rahman</a> on 12/8/20.
*/

@Database(
    entities = [WishlistEntity::class],
    version = Const.DB.VERSION,
    exportSchema = false
)
@TypeConverters(DateConverter::class)
abstract class AppDB : RoomDatabase() {

    abstract fun wishlistDao(): WishlistDao

    companion object {

        private lateinit var INSTANCE: AppDB

        @Synchronized
        fun initDb(context: Context) {
            if (!Companion::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(context, AppDB::class.java, context.getString(R.string.app_name))
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigrationFrom()
                    .build()
            }
        }

        fun getInstance(): AppDB {
            if(!Companion::INSTANCE.isInitialized) initDb(GpApp.getApplicationContext())
            return INSTANCE
        }
    }
}