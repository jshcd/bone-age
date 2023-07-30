package es.jshcd.edadosea

import MainScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import es.jshcd.edadosea.core.Patient
import es.jshcd.edadosea.ui.screen.AboutScreen
import es.jshcd.edadosea.ui.screen.BoneImageScreen
import es.jshcd.edadosea.ui.screen.ResultScreen
import es.jshcd.edadosea.ui.theme.BoneAgeTheme
import es.jshcd.edadosea.ui.viewmodel.PatientViewModel

const val ROUTE_MAIN = "main"
const val ROUTE_ABOUT = "about"
const val ROUTE_RESULT = "result"
const val ROUTE_BONE_IMAGE = "boneImage"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = PatientViewModel()

        setContent {
            val uiState = viewModel.uiState.collectAsState()
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = ROUTE_MAIN) {
                composable(ROUTE_ABOUT) {
                    BoneAgeTheme {
                        AboutScreen(
                            versionName = BuildConfig.VERSION_NAME,
                            versionNumber = BuildConfig.VERSION_CODE,
                            onBackArrowPressed = { navController.popBackStack() }
                        )
                    }
                }
                composable(ROUTE_MAIN) {
                    BoneAgeTheme {
                        MainScreen(
                            state = uiState.value,
                            onActionButtonClick = { selectedAction ->
                                when(selectedAction) {
                                    "About" -> navController.navigate(ROUTE_ABOUT)
                                }
                            },
                            onPreviousClick = { viewModel.onPrevious() },
                            onNextClick = { viewModel.onNext() },
                            onCalculateBoneAgeClick = {
                                try {
                                    val patientAge = viewModel.onCalculateBoneAge()
                                    val routeToGo = "$ROUTE_RESULT/$patientAge/OK"
                                    navController.navigate(routeToGo)
                                } catch (e: Patient.WrongEstadioException) {
                                    val routeToGo = "$ROUTE_RESULT/ /${e.message}"
                                    navController.navigate(routeToGo)
                                } catch (e: Patient.InvalidPatientSexException) {
                                    val routeToGo = "$ROUTE_RESULT/ /${e.message}"
                                    navController.navigate(routeToGo)
                                } catch (e: Patient.PatientIsAdultException) {
                                    val routeToGo = "$ROUTE_RESULT/ /${e.message}"
                                    navController.navigate(routeToGo)
                                }
                            },
                            onShowFullScreenImage = {
                                navController.navigate(ROUTE_BONE_IMAGE)
                            }
                        )
                    }
                }
                composable(
                    route = ROUTE_BONE_IMAGE,
                ) {
                    BoneAgeTheme {
                        BoneImageScreen(
                            state = uiState.value,
                            onBackArrowPressed = { navController.popBackStack() },
                            onActionButtonClick = { selectedAction ->
                                when(selectedAction) {
                                    "About" -> navController.navigate(ROUTE_ABOUT)
                                }
                            }
                        )
                    }
                }
                composable(
                    route =  "$ROUTE_RESULT/{patientAge}/{error}",
                    arguments = listOf(
                        navArgument(name = "patientAge") { NavType.StringType },
                        navArgument(name = "error") { NavType.StringType }
                    )
                ) { backStackEntry ->
                    val error = backStackEntry.arguments?.getString("error")
                    val patientAge = if (error == "OK") backStackEntry.arguments?.getString("patientAge")?.toFloat() else 0.0f
                    BoneAgeTheme {
                        ResultScreen(
                            onActionButtonClick = { selectedAction ->
                                when(selectedAction) {
                                    "About" -> navController.navigate(ROUTE_ABOUT)
                                }
                            },
                            onBackArrowPressed = { navController.popBackStack() },
                            onNewCalculationClick = {
                                viewModel.resetUiState()
                                navController.popBackStack()
                                                    },
                            patientAge = patientAge,
                            error = error
                        )
                    }
                }
            }
        }
    }
}