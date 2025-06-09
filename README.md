# User Explorer

A modern Android application built with Kotlin and Jetpack Compose that allows users to explore and manage user data.

## 🎯 Project Overview

This project demonstrates:
- Clean Architecture implementation with MVI pattern
- Modern Android development practices
- SOLID principles adherence
- Test-driven development approach
- Scalable and maintainable codebase

## 🛠 Technologies Used

- **Kotlin**
- **Kotlin Flow**
- **Jetpack Compose**
- **Material 3**
- **Koin**
- **Kotlinx Serialization**
- **Android Architecture Components**
  - Navigation Compose
  - Lifecycle
  - ViewModel
- **Coroutines**
- **Clean Architecture**
- **MVI (Model-View-Intent)**
- **Retrofit**
- **Coil**
- **MockK**

## 📱 Screenshots

| Users List | User Details | Error State |
|------------|--------------|-------------|
| <img src="screenshots/UsersList.png" width="250" alt="Users List Screen"/> | <img src="screenshots/UserDetail.png" width="250" alt="User Details Screen"/> | <img src="screenshots/UsersListError.png" width="250" alt="Error State"/> |
| List of users with search functionality | Detailed user information view | Error handling with retry option |

## 🏗 Architecture

The project follows Clean Architecture principles combined with MVI pattern and is organized into the following modules:

```
app/
├── core/
│   ├── data/         # Data layer (repositories, data sources)
│   └── domain/       # Domain layer (use cases, entities)
├── feature/
│   └── users/        # Different features (Here: users)
└── app/              # Application module (UI, navigation)
```

### Architecture Diagram

```
┌─────────────────────────────────────────────────────────────────────────┐
│                           Presentation Layer (MVI)                      │
│                                                                         │
│  ┌─────────────┐    ┌─────────────┐    ┌───────────────────────────┐    │
│  │   Screens   │    │  ViewModels │    │        Navigation         │    │
│  │  (Compose)  │◄───┤ (StateFlow) │◄───┤    (Navigation Compose)   │    │
│  └─────────────┘    └─────────────┘    └───────────────────────────┘    │
└───────────────────────────┬─────────────────────────────────────────────┘
                            │
┌───────────────────────────▼─────────────────────────────────────────────┐
│                           Domain Layer                                  │
│                                                                         │
│  ┌─────────────┐    ┌─────────────┐    ┌───────────────────────────┐    │
│  │  Use Cases  │    │  Entities   │    │ Repository Interfaces     │    │
│  │  (Flow)     │◄───┤  (Models)   │◄───┤    (Contracts)            │    │
│  └─────────────┘    └─────────────┘    └───────────────────────────┘    │
└───────────────────────────┬─────────────────────────────────────────────┘
                            │
┌───────────────────────────▼─────────────────────────────────────────────┐
│                           Data Layer                                    │
│                                                                         │
│  ┌─────────────┐    ┌─────────────┐    ┌───────────────────────────┐    │
│  │Repository   │    │ DataSource  │    │         DTOs              │    │
│  │   Impl      │◄───┤  (Remote)   │◄───┤     (Data Objects)        │    │
│  └─────────────┘    └─────────────┘    └───────────────────────────┘    │
└─────────────────────────────────────────────────────────────────────────┘

Data Flow:
1. UI triggers Intent in ViewModel
2. ViewModel processes Intent and updates State
3. ViewModel executes UseCase
4. UseCase uses Repository
5. Repository fetches data from DataSource
6. Data flows back up through the layers
7. UI updates via StateFlow
```

## 🧪 Testing Strategy

- **Unit Tests**
  - ViewModels
  - Use Cases
  - Repositories
  - Data Sources

- **Integration Tests**
  - Repository implementations
  - Data source implementations

## 💡 Key Features

- **Clean Architecture**
  - Clear separation of concerns
  - Independent of frameworks
  - Testable business logic
  - Independent of UI
  - Independent of data

- **MVI Pattern**
  - Unidirectional data flow
  - Predictable state management
  - Easy to test
  - Clear state representation

- **Error Handling**
  - Graceful error states
  - Retry mechanisms
  - User-friendly error messages

## 🔄 Future Improvements

1. **Feature Enhancements**
   - Add user search functionality
   - Add offline support

2. **Architecture**
   - Implement error handling strategy
   - Add analytics tracking
   - Implement proper logging system

## 📝 Code Quality

- **Clean Code Practices**
  - SOLID Principles
  - Meaningful naming
  - Small functions
  - DRY (Don't Repeat Yourself)
  - KISS (Keep It Simple, Stupid)
