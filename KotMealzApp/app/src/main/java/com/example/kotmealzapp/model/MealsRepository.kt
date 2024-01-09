package com.example.kotmealzapp.model

import com.example.kotmealzapp.model.api.MealsWebService
import com.example.kotmealzapp.model.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {

    // getting the response api json thru retrofit
    suspend fun getMeals() : MealsCategoriesResponse {

        // webService.getMeals() --> Async task = response comes in the future ( need coroutines to wait for all the info)
        return webService.getMeals()
    }
}
