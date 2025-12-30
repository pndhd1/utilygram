# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this
repository.

## Project Overview

This is a Utilygram, Telegram for Android client with additional features based on the official
Telegram source code.
The codebase is primarily Java with native C++ components accessed via JNI.

## Additional features

## Build Commands

```bash
# Debug build (use this primarily for development)
./gradlew :TMessagesProj_App:assembleAfatDebug

# Main release build (GMS)
./gradlew :TMessagesProj_App:assembleAfatRelease

# Google Play Bundle
./gradlew :TMessagesProj_App:bundleBundleAfatRelease

# Huawei AppGallery build
./gradlew :TMessagesProj_AppHuawei:assembleAfatRelease

# Standalone/Web build
./gradlew :TMessagesProj_AppStandalone:assembleAfatStandalone

# Run instrumented tests
./gradlew :TMessagesProj_AppTests:connectedAndroidTest
```

## Project Structure

```
├── TMessagesProj/              # Core library module (com.android.library)
│   └── src/main/java/org/telegram/
│       ├── messenger/          # Business logic, controllers, services
│       ├── ui/                 # Activities, fragments, custom views
│       ├── tgnet/              # MTProto network layer (JNI interface)
│       └── SQLite/             # Database abstraction
├── TMessagesProj_App/          # Main Play Store application
├── TMessagesProj_AppHuawei/    # Huawei HMS variant
├── TMessagesProj_AppStandalone/# Web/standalone variant
└── TMessagesProj_AppTests/     # Instrumented tests
```