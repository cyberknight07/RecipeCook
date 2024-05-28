package com.example.recipebook

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(navController: NavHostController){
    val recipeViewModel : MainViewModel = viewModel()
    val viewState by recipeViewModel.categoriesState

    NavHost(navController = navController, startDestination = Screen.RecipeScreen.route) {
        composable(route = Screen.RecipeScreen.route){
            RecipeScreen(
                viewState= viewState,
                navigateToDetailScreen = {
                    //This is responsible for passing ata frm the current screen to the detail Screen.
                    //It utilizes the savedStateHandle, which is a component of the Compose Navigation Framework.
                navController.currentBackStackEntry?.savedStateHandle?.set("cat", it)
                navController.navigate(Screen.DetailScreen.route)
            })
        }
        composable(route = Screen.DetailScreen.route) {
                val category =  navController.previousBackStackEntry?.savedStateHandle?.get<Category>("cat") ?: Category("", "", "", "")
            CategoriesDetailScreen(category = category, navigateToRecipeScreen = {
                navController.navigate(Screen.RecipeScreen.route)
            })
        }
    }
}