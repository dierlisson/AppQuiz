package com.example.quizapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import com.example.quizapp.viewmodel.QuizViewModel

@Composable
fun QuizAppNavigation() {
    val navController = rememberNavController()
    val viewModel: QuizViewModel = viewModel()

    val animationDuration = 500

    NavHost(
        navController = navController,
        startDestination = "start_screen",
        enterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(animationDuration)
            )
        },
        exitTransition = {
            fadeOut(animationSpec = tween(animationDuration))
        },
        popEnterTransition = {
            fadeIn(animationSpec = tween(animationDuration))
        },
        popExitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(animationDuration)
            )
        }
    ) {

        // Tela 1: Início
        composable("start_screen") {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Quiz de Android", fontSize = 32.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(32.dp))
                Button(onClick = { navController.navigate("quiz_screen") }) {
                    Text("Iniciar Quiz", fontSize = 20.sp)
                }
            }
        }

        // Tela 2: Perguntas
        composable("quiz_screen") {
            val currentIndex by viewModel.currentIndex.collectAsState()
            val question = viewModel.getCurrentQuestion()
            var selectedOption by remember { mutableStateOf<Int?>(null) }

            Column(
                modifier = Modifier.fillMaxSize().padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Pergunta ${currentIndex + 1} / ${viewModel.totalQuestions}", color = MaterialTheme.colorScheme.secondary)
                Spacer(modifier = Modifier.height(16.dp))

                Text(question.text, fontSize = 20.sp, textAlign = TextAlign.Center, fontWeight = FontWeight.Medium)
                Spacer(modifier = Modifier.height(24.dp))

                question.options.forEachIndexed { index, option ->
                    OutlinedButton(
                        onClick = { selectedOption = index },
                        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = if (selectedOption == index) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surface
                        )
                    ) {
                        Text(option)
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = {
                        selectedOption?.let {
                            val hasNext = viewModel.submitAnswer(it)
                            selectedOption = null // Limpa seleção para a próxima pergunta
                            if (!hasNext) {
                                navController.navigate("result_screen") {
                                    popUpTo("start_screen") { inclusive = false } // Evita voltar pro meio do quiz
                                }
                            }
                        }
                    },
                    enabled = selectedOption != null,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(if (currentIndex == viewModel.totalQuestions - 1) "Finalizar" else "Próxima")
                }
            }
        }

        // Tela 3: Resultados
        composable("result_screen") {
            val score by viewModel.score.collectAsState()

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Resultado Final", fontSize = 28.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(16.dp))
                Text("Você acertou $score de ${viewModel.totalQuestions}!", fontSize = 22.sp)
                Spacer(modifier = Modifier.height(32.dp))
                Button(onClick = {
                    viewModel.resetQuiz()
                    navController.navigate("start_screen") {
                        popUpTo("start_screen") { inclusive = true }
                    }
                }) {
                    Text("Reiniciar Quiz")
                }
            }
        }
    }
}