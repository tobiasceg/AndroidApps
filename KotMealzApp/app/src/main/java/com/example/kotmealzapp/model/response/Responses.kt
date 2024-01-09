package com.example.kotmealzapp.model.response

import com.google.gson.annotations.SerializedName
import java.lang.invoke.TypeDescriptor

// STORING JSON INTO A CLASS
// JSON --> DATA CLASS
// getting the api json

                                // since categories matches the json, we dont need to @serializedname
data class MealsCategoriesResponse(val categories: List<MealsResponse>)

data class MealsResponse(
     @SerializedName("idCategory") val id: String,
     @SerializedName("strCategory") val name: String,
     @SerializedName("strCategoryDescription") val description: String,
     @SerializedName("strCategoryThumb") val imageUrl:String)

// Gson deserialization --> JSON to data classes
