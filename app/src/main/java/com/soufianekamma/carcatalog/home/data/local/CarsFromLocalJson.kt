package com.soufianekamma.carcatalog.home.data.local

import android.app.Application
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import com.soufianekamma.carcatalog.home.domain.model.Car
import javax.inject.Inject

class CarsFromLocalJson @Inject constructor(
    private val application: Application
) {

    fun getCarsFromLocalJson(): List<Car> {
        val jsonString = application.assets.open("carssss.json")
            .bufferedReader()
            .use { it.readText() }
        val jsonObject = Gson().fromJson(jsonString, JsonObject::class.java)
        val carsJsonArray = jsonObject.getAsJsonArray("Models")
        val listType = object : TypeToken<List<Car>>() {}.type
        return Gson().fromJson<List<Car>?>(carsJsonArray, listType)
            .filter { it.make.equals("renault", ignoreCase = true) }

    }
}