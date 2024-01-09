package com.example.kotmealzapp.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kotmealzapp.model.response.MealsResponse
import com.example.kotmealzapp.ui.theme.KotMealzAppTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotMealzAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MealzCategoriesScreen()
                }
            }
        }
    }
}

@Composable
fun MealzCategoriesScreen() {

    // View holds reference to view model
    // this binds the view model to this composable --> living in its lifecycle
    // recomposable would not reinitialize the viewmodel everytime
    val viewModel: MealCategoriesViewModel = viewModel()

//    // die with the compose
//    val coroutineScope = rememberCoroutineScope()
//
//    // launched effect runs only once (regardless of recomposition)
//    LaunchedEffect(key1 = "GET_MEALS") {
//        coroutineScope.launch(Dispatchers.IO) {
//            val meals = viewModel.getMeals()
//            rememberMeals.value = meals
//        }
//    }

    val rememberMeals = viewModel.MealsState.value

    LazyColumn{
        items(rememberMeals){
            meal -> Text(text = meal.name)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotMealzAppTheme {
        MealzCategoriesScreen()
    }
}
