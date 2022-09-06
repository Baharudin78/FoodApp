package com.baharudin.foodapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.AnimationEndReason
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.baharudin.foodapp.ui.features.started.GetStartedScreen
import com.baharudin.foodapp.ui.theme.FoodAppTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController


@ExperimentalAnimationApi
@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController : NavHostController = rememberAnimatedNavController(),
    startDestination : String = MainNavigation.GET_STARTED_ROUTE
) {
    AnimatedNavHost(navController = navController,
        startDestination = startDestination,
        modifier = modifier ,
    ) {
        composable(
            route = MainNavigation.GET_STARTED_ROUTE,
            enterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentScope.SlideDirection.Down,
                    animationSpec = tween(MainNavigation.TRANSITION_DURATION)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentScope.SlideDirection.Up,
                    animationSpec = tween(MainNavigation.TRANSITION_DURATION)
                )
            }
        ) {
            GetStartedScreen()
        }
        composable(
            route = MainNavigation.HOME_ROUTE,
            enterTransition = {
                when(initialState.destination.route) {
                    MainNavigation.GET_STARTED_ROUTE -> slideIntoContainer(
                        towards = AnimatedContentScope.SlideDirection.Up,
                        animationSpec = tween(MainNavigation.TRANSITION_DURATION)
                    )
                    else -> slideIntoContainer(
                        towards = AnimatedContentScope.SlideDirection.Right,
                        animationSpec = tween(MainNavigation.TRANSITION_DURATION),
                    )
                }
            },
            exitTransition = {
                when(targetState.destination.route) {
                    MainNavigation.GET_STARTED_ROUTE -> slideOutOfContainer(
                        towards = AnimatedContentScope.SlideDirection.Down,
                        animationSpec = tween(MainNavigation.TRANSITION_DURATION)
                    )
                    else -> slideOutOfContainer(
                        towards = AnimatedContentScope.SlideDirection.Left,
                        animationSpec = tween(MainNavigation.TRANSITION_DURATION)
                    )
                }
            }
        ) {
            //Home
        }
        composable(
            route = MainNavigation.DETAIL_ROUTE,
            enterTransition = {
                slideIntoContainer(
                        towards = AnimatedContentScope.SlideDirection.Left,
                        animationSpec = tween(MainNavigation.TRANSITION_DURATION)
                    )
            },
            exitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentScope.SlideDirection.Right,
                    animationSpec = tween(MainNavigation.TRANSITION_DURATION)
                )
            }
        ) {
            //Detail
        }
    }
}

object MainNavigation{
    const val GET_STARTED_ROUTE = "onboarding"
    const val HOME_ROUTE = "home"
    const val DETAIL_ROUTE = "detail"

    const val TRANSITION_DURATION = 500
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FoodAppTheme {
    }
}