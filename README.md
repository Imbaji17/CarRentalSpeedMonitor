# User Explorer App

A modern Android application that demonstrates clean architecture, modern Android development practices, and Jetpack Compose UI. The app allows users to browse through a list of users and view their detailed information.

## Architecture

The project follows Clean Architecture principles with a modular structure:
- `app`: Main application module
- `core`: Core functionality
  - `domain`: Business logic and interfaces
  - `data`: Data layer implementation
- `feature`: Feature modules (users)

## Technologies & Tools

### Core
- **Language**: Kotlin 1.9.10
- **Minimum SDK**: 24
- **Target SDK**: 35
- **Build System**: Gradle with Kotlin DSL

### UI
- **Jetpack Compose**: 2023.10.01 (BOM)
- **Material Design 3**
- **Coil**: 2.5.0 (Image loading)
- **Navigation Compose**: 2.7.7

### Architecture Components
- **ViewModel**: Lifecycle-aware data holder
- **StateFlow**: Reactive state management
- **Coroutines**: Asynchronous programming
- **Navigation**: Screen navigation and argument passing

### Dependency Injection
- **Koin**: 3.3.3
- **Koin Compose**: 3.4.3

### Networking
- **Retrofit**: 2.9.0
- **OkHttp**: 4.10.0
- **KotlinX Serialization**: 1.4.1

### Testing
- **JUnit**: 4.13.2
- **MockK**: 1.13.9
- **Coroutines Test**: 1.6.4
- **Compose UI Testing**
- **Espresso**: 3.5.1

## Project Structure

```
├── app/                          # Application module
├── core/                         # Core modules
│   ├── data/                    # Data layer
│   └── domain/                  # Domain layer
└── feature/                      # Feature modules
    └── users/                   # Users feature
```

## Key Features
- Clean Architecture implementation
- Modular project structure
- Reactive state management
- Modern UI with Jetpack Compose
- Comprehensive test coverage
- Type-safe navigation
- Error handling
- Image loading and caching

## Assumptions
1. Network connectivity is required for the app to function
2. User data structure remains consistent with the defined model
3. API endpoints follow RESTful conventions
4. Device has sufficient memory to handle image loading
5. User permissions for internet access are granted

## Potential Improvements

### Architecture & Code
1. Add local data persistence using Room
2. Implement offline-first architecture
3. Add use cases layer in domain module
4. Implement data caching strategy
5. Add pagination for user list
6. Implement retry mechanism for failed network requests

### Features
1. Add user search functionality
2. Implement user filtering and sorting
3. Add pull-to-refresh functionality
4. Implement user data editing
5. Add user favorites feature
6. Implement dark/light theme switching

### Testing
1. Add integration tests
2. Implement UI automation tests
3. Add performance testing
4. Implement screenshot testing
5. Add API response mocking for testing
6. Increase test coverage for edge cases

### Performance
1. Implement image caching strategy
2. Add memory optimization for image loading
3. Implement lazy loading for user list
4. Add performance monitoring
5. Optimize app startup time
6. Implement proper memory management

### User Experience
1. Add loading animations
2. Implement error state UI improvements
3. Add gesture navigation
4. Implement accessibility features
5. Add user feedback mechanisms
6. Improve error messages

### Security
1. Implement API key security
2. Add certificate pinning
3. Implement proper data encryption
4. Add user data privacy features
5. Implement secure storage for sensitive data
6. Add security headers in API requests

## Getting Started

### Prerequisites
- Android Studio Arctic Fox or later
- JDK 11
- Android SDK with minimum API 24

### Setup
1. Clone the repository
2. Open project in Android Studio
3. Sync project with Gradle files
4. Run the app on an emulator or physical device
