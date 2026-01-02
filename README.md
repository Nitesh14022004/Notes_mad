# Notes MAD - Android Notes Application

A simple and efficient notes application built for Android using Java. This app allows users to create, view, and manage their notes with persistent storage using SharedPreferences.

## 📱 Project Overview

Notes MAD is a native Android application that provides a clean and intuitive interface for managing personal notes. The app features a minimalist design with core functionality to add, display, and persist notes locally on the device.

### Key Features
- ✏️ Create and save notes
- 📋 View all saved notes in a list
- 💾 Persistent storage using SharedPreferences
- 🎨 Material Design UI components
- 📱 Responsive layout with ConstraintLayout

## 🛠️ Tech Stack

### Core Technologies
- **Language**: Java 11
- **Build System**: Gradle (Kotlin DSL)
- **Minimum SDK**: API 21 (Android 5.0 Lollipop)
- **Target SDK**: API 35 (Android 15)
- **Compile SDK**: API 35

### Libraries & Dependencies

| Library | Version | Purpose |
|---------|---------|---------|
| AndroidX AppCompat | 1.7.0 | Backward compatibility |
| Material Components | 1.12.0 | Material Design UI |
| ConstraintLayout | 2.2.1 | Flexible layouts |
| AndroidX Activity | 1.10.1 | Activity support |

### Development Tools
- **Android Gradle Plugin**: 8.9.1
- **Java Version**: JavaSE-21 LTS (development environment)
- **Java Compatibility**: Java 11 (source & target)

### Testing Dependencies
- **JUnit**: 4.13.2 (Unit testing)
- **AndroidX Test JUnit**: 1.2.1 (Instrumented testing)
- **Espresso Core**: 3.6.1 (UI testing)

## 📂 Folder Structure

```
Notes_MAD/
├── app/
│   ├── build.gradle.kts              # App-level build configuration
│   ├── proguard-rules.pro            # ProGuard rules for code obfuscation
│   ├── src/
│   │   ├── main/
│   │   │   ├── AndroidManifest.xml   # App manifest file
│   │   │   ├── java/
│   │   │   │   ├── com/example/notes_mad/
│   │   │   │   │   └── MainActivity.java    # Main activity
│   │   │   │   └── NoteAdapter.java         # RecyclerView adapter
│   │   │   └── res/
│   │   │       ├── layout/           # XML layout files
│   │   │       ├── values/           # Strings, colors, themes
│   │   │       └── mipmap/           # App icons
│   │   ├── androidTest/              # Instrumented tests
│   │   │   └── java/
│   │   │       └── com/example/notes_mad/
│   │   │           └── ExampleInstrumentedTest.java
│   │   └── test/                     # Unit tests
│   │       └── java/
│   │           └── com/example/notes_mad/
│   │               └── ExampleUnitTest.java
│   └── build/                        # Build outputs (generated)
├── gradle/
│   ├── libs.versions.toml            # Version catalog for dependencies
│   └── wrapper/                      # Gradle wrapper files
├── build.gradle.kts                  # Project-level build configuration
├── settings.gradle.kts               # Project settings
├── gradle.properties                 # Gradle properties
├── gradlew                          # Gradle wrapper script (Unix)
├── gradlew.bat                      # Gradle wrapper script (Windows)
└── local.properties                 # Local SDK path (not in VCS)
```

## 🚀 Setup Instructions

### Prerequisites
- **Android Studio**: Arctic Fox (2020.3.1) or later recommended
- **JDK**: Java Development Kit 11 or higher
- **Android SDK**: API Level 21 to 35
- **Gradle**: 8.9.1 (included via wrapper)

### Installation Steps

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd Notes_MAD
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an Existing Project"
   - Navigate to the cloned directory and select it

3. **Configure local.properties**
   - Create or verify `local.properties` file in the root directory
   - Add your Android SDK path:
     ```properties
     sdk.dir=C\:\\Users\\YourUsername\\AppData\\Local\\Android\\Sdk
     ```
   - On macOS/Linux:
     ```properties
     sdk.dir=/Users/YourUsername/Library/Android/sdk
     ```

4. **Sync Gradle**
   - Android Studio should automatically prompt to sync
   - Or manually sync via: `File → Sync Project with Gradle Files`

5. **Build the project**
   ```bash
   ./gradlew build
   ```
   On Windows:
   ```bash
   gradlew.bat build
   ```

6. **Run the app**
   - Connect an Android device via USB (with USB debugging enabled)
   - Or start an Android emulator
   - Click the "Run" button (▶️) in Android Studio
   - Or use command line:
     ```bash
     ./gradlew installDebug
     ```

## 🔧 Configuration

### Build Variants
The app supports two build types:

- **Debug**: Development build with debugging enabled
  - Minification: Disabled
  - Debug symbols included

- **Release**: Production-ready build
  - Minification: Disabled (can be enabled in build.gradle.kts)
  - ProGuard rules applied
  - Optimized for performance

### ProGuard Configuration
ProGuard rules are defined in:
- `app/proguard-rules.pro` (custom rules)
- Default Android optimization rules

## 🌍 Environment Variables

This project does not require environment variables for basic functionality. However, if you extend the app with backend services or API keys, consider:

1. **Creating a `secrets.properties` file** (add to `.gitignore`):
   ```properties
   API_KEY=your_api_key_here
   BASE_URL=https://api.example.com
   ```

2. **Reading in `build.gradle.kts`**:
   ```kotlin
   val secretsFile = rootProject.file("secrets.properties")
   val secrets = Properties()
   if (secretsFile.exists()) {
       secrets.load(FileInputStream(secretsFile))
   }
   
   android {
       defaultConfig {
           buildConfigField("String", "API_KEY", "\"${secrets["API_KEY"]}\"")
       }
   }
   ```

## 🧪 How to Run Tests

### Unit Tests
Unit tests are located in `app/src/test/java/`

Run all unit tests:
```bash
./gradlew test
```

Run unit tests for debug build:
```bash
./gradlew testDebugUnitTest
```

### Instrumented Tests
Instrumented tests require an Android device or emulator and are located in `app/src/androidTest/java/`

Run all instrumented tests:
```bash
./gradlew connectedAndroidTest
```

Run instrumented tests for debug build:
```bash
./gradlew connectedDebugAndroidTest
```

### Running Tests in Android Studio
1. Right-click on the test file or test method
2. Select "Run 'TestName'"
3. View results in the Run window

### Test Coverage
Generate test coverage report:
```bash
./gradlew createDebugCoverageReport
```

Reports will be generated in:
```
app/build/reports/coverage/debug/
```

## 📱 Application Components

### MainActivity
- Main entry point of the application
- Handles note input and display
- Manages SharedPreferences for data persistence
- Uses ListView with custom adapter for displaying notes

### NoteAdapter
- RecyclerView adapter for displaying notes
- Handles click events on note items
- Shows toast messages when notes are clicked

### Data Persistence
- **Storage**: SharedPreferences
- **Key**: "NotesPrefs"
- **Data Structure**: String Set (HashSet)
- Notes are automatically saved and loaded on app lifecycle events

## 🎨 UI Components

The app uses Material Design components including:
- EditText for note input
- Button for saving notes
- ListView/RecyclerView for displaying notes
- Custom list item layouts

## 🔒 Permissions

This app does not require any special Android permissions. It only uses:
- Storage access via SharedPreferences (built-in, no permission needed)

## 🏗️ Build Commands

| Command | Description |
|---------|-------------|
| `./gradlew build` | Build the app (debug + release) |
| `./gradlew assembleDebug` | Build debug APK |
| `./gradlew assembleRelease` | Build release APK |
| `./gradlew clean` | Clean build artifacts |
| `./gradlew installDebug` | Build and install debug APK |
| `./gradlew lint` | Run Android Lint checks |

## 📦 APK Output Location

After building, APK files can be found at:
- **Debug**: `app/build/outputs/apk/debug/app-debug.apk`
- **Release**: `app/build/outputs/apk/release/app-release-unsigned.apk`

## 🐛 Troubleshooting

### Common Issues

**1. Gradle sync failed**
- Ensure you have a stable internet connection
- Check that `local.properties` has correct SDK path
- Try: `File → Invalidate Caches / Restart`

**2. App crashes on launch**
- Check logcat for error messages
- Verify all layout files exist
- Ensure minimum SDK requirements are met

**3. Build errors**
- Clean and rebuild: `./gradlew clean build`
- Update Android Gradle Plugin if needed
- Check for dependency conflicts

## 📝 Version Information

- **Version Code**: 1
- **Version Name**: 1.0
- **Package Name**: com.example.notes_mad

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is created for educational purposes.

## 👨‍💻 Development

### Code Style
- Follow Android Kotlin Style Guide for Kotlin files
- Follow Google Java Style Guide for Java files
- Use meaningful variable and method names
- Add comments for complex logic

### Future Enhancements
- [ ] Add note editing functionality
- [ ] Implement note deletion
- [ ] Add categories/tags for notes
- [ ] Search and filter notes
- [ ] Cloud sync integration
- [ ] Rich text formatting
- [ ] Voice notes support
- [ ] Dark mode theme

---

**Built with ❤️ for Android**
