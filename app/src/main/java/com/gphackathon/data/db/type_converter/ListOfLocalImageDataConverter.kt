package com.gphackathon.data.db.type_converter

import androidx.room.TypeConverter

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


/*
 * Created by : 
 * <a href="https://www.github.com/ashiqursuperfly">Ashiqur Rahman</a> on 12/8/20.
*/

/*
class ListOfLocalImageDataConverter {

    @TypeConverter
    fun restoreList(listOfString: String): ArrayList<LocalImageDataEntry?>? {
        return Gson().fromJson(
            listOfString,
            object : TypeToken<ArrayList<LocalImageDataEntry?>?>(){}.type
        )
    }

    @TypeConverter
    fun saveList(listOfOptions: ArrayList<LocalImageDataEntry?>?): String {
        return Gson().toJson(listOfOptions)
    }

}*/
