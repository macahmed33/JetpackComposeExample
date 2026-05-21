# 🚀 Jetpack Compose Example

A modern Android application demonstrating production-ready development with **Jetpack Compose**, **MVVM architecture**, **Room database**, and **Dependency Injection** — covering a full authentication and data flow from Sign In through to a detail screen.

![Kotlin](https://img.shields.io/badge/Kotlin-Android-7F52FF?style=flat&logo=kotlin)
![Compose](https://img.shields.io/badge/UI-Jetpack%20Compose-4285F4?style=flat&logo=jetpackcompose)
![Architecture](https://img.shields.io/badge/Architecture-MVVM-orange?style=flat)
![DI](https://img.shields.io/badge/DI-Hilt%2FDagger-red?style=flat)
![Room](https://img.shields.io/badge/DB-Room-blue?style=flat)

---

## 📱 App Overview

A full-flow Android app built entirely with Jetpack Compose. Users sign in with email and password, land on a home screen displaying a list of items, and can tap through to a detail screen. Data is persisted locally with Room and the app is wired with Dependency Injection for clean, testable architecture.

---

## 🖥️ Screens

| Screen | Description |
|--------|-------------|
| **Sign In** | Email & password login with input validation |
| **Home** | List screen displaying items from local Room database |
| **Detail** | Full detail view for a selected item |

---

## ✨ Features

- 🔐 Sign In screen with email & password fields
- 📋 Home screen with item list (Compose LazyColumn)
- 🔍 Detail screen with full item information
- 💾 Local data persistence with Room database
- 🧩 Dependency Injection for clean, decoupled architecture
- 🧭 Jetpack Navigation between screens
- 📐 MVVM — clear separation of UI, business logic, and data

---

## 🏗️ Project Structure

```
app/src/main/java/
├── network/          # API client & Retrofit interfaces
├── di/               # Dependency injection modules (Hilt/Dagger)
├── model/            # Data classes & domain models
├── navigation/       # Compose navigation graph & routes
├── repository/       # Data layer — abstracts Room & network
├── room/             # Room database, DAOs & entities
├── screens/          # Composable screens (SignIn, Home, Detail)
├── ui/               # Theme, typography, colors
├── utils/            # Extension functions & helpers
├── viewmodel/        # ViewModels with StateFlow/LiveData
├── MainActivity.kt   # Entry point — hosts NavHost
└── MyApplication.kt  # Application class — DI initialisation
```

---

## 🛠️ Tech Stack

| Component | Technology |
|-----------|-----------|
| Language | Kotlin |
| UI | Jetpack Compose |
| Architecture | MVVM + Repository Pattern |
| Navigation | Jetpack Navigation Compose |
| Database | Room |
| Dependency Injection | Hilt / Dagger |
| Async | Coroutines + StateFlow |
| Networking | Retrofit |

---

## 🚀 Getting Started

### Prerequisites
- Android Studio Hedgehog or newer
- Android SDK API 24+
- Kotlin 1.9+

### Run the project

```bash
# Clone the repo
git clone https://github.com/macahmed33/JetpackComposeExample.git

# Open in Android Studio
# File → Open → select the project folder

# Sync Gradle and run
# Click Run ▶ or press Shift+F10
```

---

## 🧭 Navigation Flow

```
SignInScreen
     │
     ▼ (on successful login)
HomeScreen (LazyColumn list)
     │
     ▼ (on item tap)
DetailScreen
```

---

## 📌 About This Project

Built as a hands-on example of **modern Android development** using the latest Jetpack libraries. The goal was to demonstrate a clean, scalable project structure that reflects real production patterns — Compose UI, local persistence, dependency injection, and navigated multi-screen flow all working together.

---

## 👨‍💻 Author

**Mohib Ahmed** — Senior Mobile Engineer
[LinkedIn](https://linkedin.com/in/mohib-ahmed-276b15157) · [mohibahmed3333@gmail.com](mailto:mohibahmed3333@gmail.com)
