# Sprunki Games - Android App

Aplikasi Android untuk memainkan koleksi game Sprunki dalam WebView.

## Fitur
- Menampilkan list game dengan thumbnail
- WebView untuk memainkan game HTML5
- Orientasi layar otomatis sesuai data game (landscape/portrait)
- Desain playful untuk anak-anak 5 tahun ke atas
- Tombol back untuk kembali ke home

## Identifier
- **Package Name:** `id.onyet.games.sprunki`
- **Min SDK:** 24 (Android 7.0)
- **Target SDK:** 34 (Android 14)

## Build Instructions

### Prerequisites
- Android Studio Hedgehog atau lebih baru
- JDK 17 atau lebih baru

### Build APK

1. Buka folder `android-app` di Android Studio
2. Sync Gradle
3. Build > Build Bundle(s) / APK(s) > Build APK(s)

Atau via command line:
```bash
cd android-app
./gradlew assembleDebug
```

APK akan tersedia di: `app/build/outputs/apk/debug/app-debug.apk`

### Build Release APK
```bash
./gradlew assembleRelease
```

## Struktur Proyek
```
android-app/
├── app/
│   └── src/main/
│       ├── java/id/onyet/games/sprunki/
│       │   ├── MainActivity.kt       # List game
│       │   ├── GameActivity.kt       # WebView game
│       │   ├── adapter/
│       │   │   └── GameAdapter.kt    # RecyclerView adapter
│       │   └── model/
│       │       └── Game.kt           # Data class game
│       └── res/
│           ├── layout/               # XML layouts
│           ├── values/               # Colors, strings, themes
│           ├── drawable/             # Icons & backgrounds
│           ├── mipmap-*/             # App icons
│           └── raw/
│               └── games.json        # Data game
└── build.gradle.kts
```

## Menambah Game Baru

Edit file `app/src/main/res/raw/games.json`:

```json
{
    "name": "Nama Game",
    "link": "https://url-game.com",
    "thumbnail": "https://url-thumbnail.com/image.jpg",
    "orientation": "landscape"  // atau "portrait"
}
```

## Screenshots

*Coming soon*

---
Made with ❤️ by Onyet
