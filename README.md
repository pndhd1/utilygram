## Utilygram - Telegram for Android with minor but useful set of features.

It contains a set of features that I personally miss in the official client.
Features are added as I feel the need for them during daily use.

> [!IMPORTANT]
> There are NO oficial releases, but you can compile the app yourself by following the instructions
> below.

See [FEATURES.md](FEATURES.md) for list of additional features.

### Compilation Guide

1. Clone the repository
2. Copy your release.keystore into TMessagesProj/config
3. Fill out local.properties (example is provided in local.properties.example):
    - RELEASE_KEY_PASSWORD, RELEASE_KEY_ALIAS, RELEASE_STORE_PASSWORD to access your
      release.keystore
    - TELEGRAM_APP_ID and TELEGRAM_APP_HASH can be obtained by creating an app
      at https://my.telegram.org/apps
4. Go to https://console.firebase.google.com/, create two android apps with application IDs
   io.github.pndhd1.utilygram and io.github.pndhd1.utilygram.beta,
   turn on firebase messaging and download google-services.json, which should be copied to the
   TMessagesProj_App folder
5. You are ready to compile Utilygram.
