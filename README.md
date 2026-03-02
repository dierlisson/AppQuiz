
# 🧠 Android Quiz App - Desafio Jetpack Compose

> *Aplicativo interativo de perguntas e respostas com foco em desenvolvimento Android moderno utilizando Jetpack Compose.*

## 📱 Sobre o Projeto

O **Android Quiz App** é um aplicativo nativo desenvolvido para testar conhecimentos sobre o ecossistema Android e a linguagem Kotlin. O objetivo principal deste projeto é demonstrar a criação de uma interface de usuário 100% declarativa, gerenciamento de estado e navegação fluida utilizando as mais recentes recomendações do Google.

O app conta com um banco de perguntas local, cálculo de pontuação em tempo real e transições animadas entre as telas, tudo isso orquestrado por uma arquitetura **MVVM** limpa e reativa.

---

## 📸 Screenshots

| Tela Inicial | Pergunta Ativa | Resultado Final |
|:---:|:---:|:---:|
| <img src="https://github.com/user-attachments/assets/63c990cb-d9cd-4958-af3c-105d511928e0" width="200" alt="Tela Inicial do Quiz" /> | <img src="https://github.com/user-attachments/assets/ab611851-fafe-4ce3-b68d-fcf4de753b8b" width="200" alt="Tela de Pergunta com opções" /> | <img src="https://github.com/user-attachments/assets/8f5a9623-8a57-433d-a7ca-8695608c594f" width="200" alt="Tela de Resultado com pontuação" /> |

---


## 🛠 Tecnologias e Bibliotecas

O projeto foi construído utilizando as ferramentas mais atuais do ecossistema Android para UI declarativa:

* **Linguagem:** [Kotlin](https://kotlinlang.org/)
* **Arquitetura:** MVVM (Model-View-ViewModel)
* **UI Toolkit:** [Jetpack Compose](https://developer.android.com/jetpack/compose) (Material Design 3)
* **Gerenciamento de Estado:** `StateFlow` & `ViewModel` (`lifecycle-viewmodel-compose`)
* **Navegação:** [Jetpack Compose Navigation](https://developer.android.com/guide/navigation) (`navigation-compose`)
* **Animações:** Transições nativas do Navigation (`AnimatedContentTransitionScope`, `tween`)

---

## ✨ Funcionalidades

* ✅ **Banco de Questões Temático:** Perguntas focadas em desenvolvimento Android, Kotlin e arquitetura.
* ✅ **Gerenciamento de Estado Seguro:** O progresso do usuário e a pontuação são mantidos seguros no `ViewModel`, sobrevivendo a mudanças de configuração (como rotação de tela).
* ✅ **Navegação Fluida com Animações:** Transições de tela suaves configuradas diretamente no `NavHost` (Slide In/Out e Fade In/Out).
* ✅ **Prevenção de Erros de Fluxo:** Utilização do `popUpTo` na navegação para impedir que o usuário volte acidentalmente para o meio do quiz após finalizá-lo.
* ✅ **Feedback Imediato:** Destaque visual na opção selecionada utilizando as cores temáticas do Material Design 3.

---

## 🚀 Como Executar o Projeto

Como este projeto utiliza dados locais e não depende de chaves de API externas, executá-lo é muito simples.

### Pré-requisitos
1.  Android Studio (Versão Iguana, Jellyfish ou superior recomendada).
2.  Emulador Android ou dispositivo físico configurado para depuração.

### Passo a Passo

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/dierlisson/AppQuiz.git](https://github.com/dierlisson/AppQuiz.git)
    ```
2.  **Abra o projeto** no Android Studio.
3.  Aguarde o Android Studio realizar a **sincronização do Gradle** (Sync Project with Gradle Files).
4.  Clique no botão **Run (Shift + F10)** para instalar e abrir o aplicativo no seu emulador ou dispositivo.

---

## 📂 Estrutura do Código

A organização do projeto separa os dados, a lógica e a interface de forma clara:

```text
com.seupacote.quizapp
├── model
│   └── QuizData.kt           # Estrutura de dados (Question) e o banco de perguntas local
├── viewmodel
│   └── QuizViewModel.kt      # Lógica de negócios, pontuação e controle da pergunta atual (StateFlow)
└── ui
    ├── QuizApp.kt            # NavHost configurado com as rotas, animações e telas (Composables)
    └── MainActivity.kt       # Ponto de entrada do app (ComponentActivity + setContent)
 ```
## 👤 Autor

Desenvolvido por **Dierlisson Justiniano** como parte de um desafio prático de desenvolvimento Android.
