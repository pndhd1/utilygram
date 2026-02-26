## Project Overview

This is a Utilygram, Telegram for Android client with additional features based on the official
Telegram source code.
The codebase is primarily Java with native C++ components accessed via JNI.

## Additional Features

### Settings Screen
- **Path:** `TMessagesProj/src/main/java/org/telegram/ui/UtilygramSettingsActivity.java`
- **Config:** `TMessagesProj/src/main/java/org/telegram/messenger/SharedConfig.java` (search for `// region Utilygram`)
- **Strings:** `TMessagesProj/src/main/res/values/strings.xml` (search for `<!--region Utilygram-->`)

### Rules for Adding New Features
- After implementing a new feature, update [FEATURES.md](FEATURES.md) with the feature description.

### Feature List
See [FEATURES.md](FEATURES.md) for the full list of additional features.

## Project Structure

```
├── TMessagesProj/              # Core library module (com.android.library)
├── TMessagesProj_App/          # Main Play Store application
├── TMessagesProj_AppHuawei/    # Huawei HMS variant
├── TMessagesProj_AppStandalone/# Web/standalone variant
└── TMessagesProj_AppTests/     # Instrumented tests
```