# Node Bot Dashboard (Android)

A Kotlin-based Android app for managing Discord bot workflows with:
- an in-app terminal,
- bot profile setup (JavaScript/Python),
- operational dashboard sections,
- and embedded Node.js runtime startup hooks.

## Main menu
- Terminal
- Add a Discord Bot (JavaScript)
- Add a Discord Bot (Python)
- Settings
- About

Version is shown on the top-right of the main menu.

## Bot dashboard sections
Each bot dashboard contains:
- Dashboard (start/stop/restart + status + RAM/Disk usage)
- StartUp (startup command)
- Modules (download/install modules placeholder)
- Network
- Explorer + Editor

## Build
1. Set your Android SDK path in `local.properties`:
   `sdk.dir=/absolute/path/to/android/sdk`
2. Build debug APK:
   ```bash
   ./gradlew assembleDebug
   ```
3. APK output (typical path):
   `app/build/outputs/apk/debug/app-debug.apk`

## Notes
- Embedded Node startup is wired via JNI (`native-lib` + `node` shared libraries).
- You still need to package/provide `libnode.so` for target ABIs.
