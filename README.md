# 🎮 Sprunki Fawwaz

Koleksi game Sprunki dalam satu aplikasi Android — dibuat khusus untuk anak-anak!

> ⚠️ **Hanya untuk penggunaan pribadi.** Game-game di dalam aplikasi ini adalah milik developer masing-masing. Tidak untuk dipublikasikan ke Google Play Store.

---

## ✨ Fitur

- 🎯 **11 game Sprunki** siap dimainkan langsung
- 🖼️ Tampilan list game dengan thumbnail
- 🌐 WebView dengan dukungan HTML5 penuh
- 🔄 **Cache otomatis** — game yang sudah pernah dibuka tidak perlu loading ulang
- 📱 Orientasi layar otomatis (landscape/portrait) sesuai data game
- 🔙 Tombol back untuk kembali ke home
- 🎨 Desain sederhana & playful untuk anak usia 5 tahun ke atas
- 🌙 Fullscreen immersive mode saat bermain

---

## 🕹️ Daftar Game

| # | Game | Orientasi |
|---|------|-----------|
| 1 | Sprunki (Original) | Landscape |
| 2 | SprunkBig | Landscape |
| 3 | Sprunki Kiss Mod | Landscape |
| 4 | Sprunki With Fan Characters | Landscape |
| 5 | Sprunki Comeback | Landscape |
| 6 | Sprunki 2026 | Landscape |
| 7 | Sprunki OC Real | Landscape |
| 8 | Sprunki Sprunked | Landscape |
| 9 | SKRUMPY | Landscape |
| 10 | Sprunki Mustard | Landscape |
| 11 | Sprunki Grown Up | Landscape |

---

## 📋 Info Aplikasi

| | |
|---|---|
| **Nama** | Sprunki Fawwaz |
| **Package** | `id.onyet.games.sprunki` |
| **Min SDK** | 24 (Android 7.0) |
| **Target SDK** | 34 (Android 14) |
| **Bahasa** | Kotlin |

---

## 🔨 Build

### Prasyarat
- Android Studio Hedgehog atau lebih baru
- JDK 17+
- Android SDK 34

### Via Android Studio
1. Buka folder `android-app` di Android Studio
2. Sync Gradle
3. **Build > Build Bundle(s) / APK(s) > Build APK(s)**

### Via Terminal
```bash
cd android-app
./gradlew assembleDebug
```

APK output: `app/build/outputs/apk/debug/app-debug.apk`

### Install ke Device
```bash
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

### Build Release
```bash
./gradlew assembleRelease
```

---

## 📁 Struktur Proyek

```
android-app/
├── build.gradle.kts              # Root build config
├── settings.gradle.kts
├── gradle.properties
├── local.properties              # SDK path (git-ignored)
│
└── app/
    ├── build.gradle.kts          # App build config & dependencies
    └── src/main/
        ├── AndroidManifest.xml
        ├── java/id/onyet/games/sprunki/
        │   ├── MainActivity.kt       # Home — daftar game
        │   ├── GameActivity.kt       # WebView — main game
        │   ├── adapter/
        │   │   └── GameAdapter.kt    # RecyclerView adapter
        │   └── model/
        │       └── Game.kt           # Data class
        └── res/
            ├── layout/
            │   ├── activity_main.xml  # Layout home
            │   ├── activity_game.xml  # Layout webview
            │   └── item_game.xml      # Layout card game
            ├── drawable/              # Background, icon, shapes
            ├── mipmap-*/              # App icon (all densities)
            ├── values/                # Colors, strings, themes
            ├── xml/                   # Backup rules
            └── raw/
                └── games.json         # Data game
```

---

## ➕ Menambah Game Baru

Edit file `app/src/main/res/raw/games.json`, tambahkan entry:

```json
{
    "name": "Nama Game",
    "link": "https://url-game.com",
    "thumbnail": "https://url-thumbnail.com/image.jpg",
    "orientation": "landscape"
}
```

Field `orientation` bisa diisi `"landscape"` atau `"portrait"`.

Lalu build ulang:
```bash
./gradlew assembleDebug
```

---

## 🛡️ Catatan Penting

- Aplikasi ini **hanya wrapper WebView** yang memuat game dari URL pihak ketiga
- **Tidak boleh dipublikasikan** ke Google Play Store (melanggar policy konten & hak cipta)
- Hanya untuk penggunaan **personal / keluarga**
- Memerlukan koneksi internet untuk load game pertama kali (setelah itu di-cache)
- Semua hak cipta game tetap milik developer asli masing-masing

---

Made with ❤️ by **Onyet** — untuk Fawwaz 🎮
