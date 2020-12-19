package com.gphackathon.data.models.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gphackathon.data.Const


/*
 * Created by : 
 * <a href="https://www.github.com/ashiqursuperfly">Ashiqur Rahman</a> on 12/19/20.
*/
@Entity(tableName = Const.DB.TABLE_NAME.WISHLIST)
data class WishlistEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val poster_path: String,
    val date: String,
    val type: String
)
