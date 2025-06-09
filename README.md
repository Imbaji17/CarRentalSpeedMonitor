# User Explorer

A modern Android application built with Kotlin and Jetpack Compose that allows users to explore and manage user data.

## 🛠 Technologies Used

- **Kotlin** - Primary programming language
- **Kotlin Flow** - Reactive streams for asynchronous data handling
  - StateFlow - State holder with value
  - SharedFlow - Hot stream of events
  - Flow operators - map, filter, combine, etc.
- **Jetpack Compose** - Modern Android UI toolkit
- **Material 3** - Material Design components
- **Koin** - Dependency injection framework
- **Kotlinx Serialization** - JSON serialization
- **Android Architecture Components**
  - Navigation Compose
  - Lifecycle
  - ViewModel
- **Coroutines** - Asynchronous programming
- **Clean Architecture** - Project structure and organization

## 📱 Screenshots

| Users List | User Details | Error State |
|------------|--------------|-------------|
| <img src="screenshots/UsersList.png" width="250" alt="Users List Screen"/> | <img src="screenshots/UserDetail.png" width="250" alt="User Details Screen"/> | <img src="screenshots/UsersListError.png" width="250" alt="Error State"/> |
| List of users with search functionality | Detailed user information view | Error handling with retry option |

## 🏗 Architecture

The project follows Clean Architecture principles and is organized into the following modules:

```
app/
├── core/
│   ├── data/         # Data layer (repositories, data sources)
│   └── domain/       # Domain layer (use cases, entities)
├── feature/
│   └── users/        # User feature module
└── app/              # Application module (UI, navigation)
```

### Architecture Diagram

```
┌─────────────────────────────────────────────────────────────────────────┐
│                           Presentation Layer                            │
│                                                                         │
│  ┌─────────────┐    ┌─────────────┐    ┌───────────────────────────┐   │
│  │   Screens   │    │ ViewModels  │    │      Navigation           │   │
│  │  (Compose)  │◄───┤  (StateFlow)│◄───┤    (Navigation Compose)    │   │
│  └─────────────┘    └─────────────┘    └───────────────────────────┘   │
└───────────────────────────┬─────────────────────────────────────────────┘
                            │
┌───────────────────────────▼─────────────────────────────────────────────┐
│                           Domain Layer                                  │
│                                                                         │
│  ┌─────────────┐    ┌─────────────┐    ┌───────────────────────────┐   │
│  │  Use Cases  │    │  Entities   │    │ Repository Interfaces     │   │
│  │  (Flow)     │◄───┤  (Models)   │◄───┤    (Contracts)            │   │
│  └─────────────┘    └─────────────┘    └───────────────────────────┘   │
└───────────────────────────┬─────────────────────────────────────────────┘
                            │
┌───────────────────────────▼─────────────────────────────────────────────┐
│                           Data Layer                                     │
│                                                                         │
│  ┌─────────────┐    ┌─────────────┐    ┌───────────────────────────┐   │
│  │Repository   │    │ DataSource  │    │         DTOs              │   │
│  │Implementation│◄───┤  (Remote)   │◄───┤    (Data Objects)        │   │
│  └─────────────┘    └─────────────┘    └───────────────────────────┘   │
└─────────────────────────────────────────────────────────────────────────┘

Data Flow:
1. UI triggers action in ViewModel
2. ViewModel executes UseCase
3. UseCase uses Repository
4. Repository fetches data from DataSource
5. Data flows back up through the layers
6. UI updates via StateFlow
```

## 🚀 Features

- Modern Material 3 UI design
- Clean Architecture implementation
- Dependency injection with Koin
- Kotlin Coroutines for asynchronous operations
- Jetpack Compose for UI
- Navigation using Navigation Compose

## 🛠 Setup and Installation

1. Clone the repository
2. Open the project in Android Studio
3. Sync the project with Gradle files
4. Run the application on an emulator or physical device

## 📋 Requirements

- Android Studio Hedgehog | 2023.1.1 or later
- JDK 11
- Android SDK 24+
- Kotlin 1.9.0 or later

## 🧪 Testing

The project includes:
- Unit tests using JUnit and MockK
- UI tests using Espresso and Compose UI testing
- Integration tests for repository and use cases

## 🔄 Future Improvements

1. **Feature Enhancements**
   - Add user search functionality
   - Add offline support

2. **Architecture**
   - Implement error handling strategy
   - Add analytics tracking
   - Implement proper logging system
