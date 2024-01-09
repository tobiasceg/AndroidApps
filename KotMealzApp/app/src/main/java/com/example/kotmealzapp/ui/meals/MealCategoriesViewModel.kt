package com.example.kotmealzapp.ui.meals

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.ViewModel
import com.example.kotmealzapp.model.MealsRepository
import com.example.kotmealzapp.model.response.MealsCategoriesResponse
import com.example.kotmealzapp.model.response.MealsResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

// hooking up view model to repository
class MealCategoriesViewModel(private val repository: MealsRepository = MealsRepository()): ViewModel() {

    val MealsState: MutableState<List<MealsResponse>> =  mutableStateOf(emptyList<MealsResponse>())

    // controls the how long the fetching of info from api takes
    private val mealsJob = Job()

    init {
        val scope = CoroutineScope(mealsJob + Dispatchers.IO) // dispatcher is for chosing which thread
        scope.launch() {
            val meals = getMeals()
            MealsState.value = meals
        }
    }

    override fun onCleared() {
        super.onCleared()

        // killing the coroutine if destroyed
        mealsJob.cancel()
    }

    // its .category as we want to prepare the info in the VM not the view
    private suspend fun getMeals(): List<MealsResponse> {
        return repository.getMeals().categories
    }
}
