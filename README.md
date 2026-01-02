## Utilygram - Telegram for Android with minor but useful set of features.

Utilygram is a Telegram client for Android with additional features based on the official Telegram source code.
I'm maintaining this fork for personal use as a hobby project.

See [FEATURES.md](FEATURES.md) for list of additional features.

### Compilation Guide

1. Clone the repository
2. Copy your release.keystore into TMessagesProj/config
3. Fill out local.properties (example is provided in local.properties.example):
   - TELEGRAM_APP_ID and TELEGRAM_APP_HASH can be obtained by creating an app at https://my.telegram.org/apps
   - RELEASE_KEY_PASSWORD, RELEASE_KEY_ALIAS and RELEASE_STORE_PASSWORD should match your release.keystore
4. Go to https://console.firebase.google.com/, create two android apps with application IDs io.github.pndhd1.utilygram and io.github.pndhd1.utilygram.beta,
turn on firebase messaging and download google-services.json, which should be copied to the same folder as TMessagesProj_App.
5. Open the project in the Studio (note that it should be opened, NOT imported).
6. You are ready to compile Utilygram.
