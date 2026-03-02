package com.example.quizapp.model

data class Question(
    val text: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)

val androidQuizQuestions = listOf(
    Question(
        "Qual anotação é usada para criar uma função de interface no Jetpack Compose?",
        listOf("@Composable", "@UIFunction", "@ComposeView", "@GenerateUI"),
        0
    ),
    Question(
        "No Kotlin, qual escopo é recomendado para lançar Coroutines em um ViewModel?",
        listOf("GlobalScope", "lifecycleScope", "viewModelScope", "MainScope"),
        2
    ),
    Question(
        "Qual é a função do 'Modifier' no Jetpack Compose?",
        listOf("Gerenciar banco de dados", "Alterar o comportamento e aparência da UI", "Fazer requisições de rede", "Navegar entre telas"),
        1
    ),
    Question(
        "Qual componente do Architecture Components sobrevive a mudanças de configuração (como girar a tela)?",
        listOf("Activity", "Fragment", "View", "ViewModel"),
        3
    ),
    Question(
        "Como declaramos uma variável cujo valor pode mudar e notificar a UI no Compose?",
        listOf("var state = mutableStateOf()", "val state = liveData()", "var state = remember { mutableStateOf() }", "val state = Observable()"),
        2
    )
)