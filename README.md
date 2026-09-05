# F&O Signal Pro — Android APK build

This is a GitHub Actions-ready Android project. It is designed so the APK can be built in GitHub's cloud runners; Android Studio is not required.

## Build
1. Put these files into the root of your GitHub repository.
2. Push to `main` (or `master`).
3. GitHub Actions runs `.github/workflows/build-apk.yml`.
4. Open the completed workflow run and download the `fno-signal-pro-apk` artifact.
5. On your Android phone, install `app-release.apk`.

## Current APK
This is a functional UI demo using simulated market/signal data. Backend APIs, real OTP, subscriptions, live market data, news, and push notification delivery are not wired into this APK yet.

Do not use simulated BUY/PUT/CALL signals for real trading.
