# WelcomeMessage Plugin 🎮

> A lightweight Hytale server plugin to welcome your players with style.

![Version](https://img.shields.io/badge/version-0.0.1-blue.svg)
![Hytale](https://img.shields.io/badge/game-Hytale-green.svg)

## ✨ Features

- **Dual-Line Welcome Titles**: Display a main title (center) and a subtitle (top) when a player joins.
- **Fully Configurable**: Set your messages directly in-game using chat commands.
- **Toggleable**: Admins can easily enable or disable the welcome message.
- **Smart Input Flow**: intuitive 2-step configuration with "skip" options for granular control.
- **Persistence**: Settings are saved automatically and persist across server restarts (`settings.json`).

## 📥 Installation

1. Download the latest `WelcomeMessage-x.x.x.jar`.
2. Place the `.jar` file into your Hytale server's `mods` directory.
3. Start or restart your server.

## 🛠️ Usage

### Commands

| Command          | Description                                              | Permission |
| ---------------- | -------------------------------------------------------- | ---------- |
| `/togglewelcome` | Enables or disables the auto-welcome message.            | Admin      |
| `/setmessage`    | Starts the configuration wizard for the welcome message. | Admin      |
| `/message`       | previews the current welcome message to yourself.        | Admin      |

### Configuration Wizard (`/setmessage`)

The configuration process is split into two simple steps:

1.  **Message Up (Subtitle)**: The smaller text displayed above the main title.
    - _Type `skip` to leave this empty._
2.  **Message Center (Title)**: The main, large text displayed in the center.
    - _Type `skip` to leave this empty._

## ⚙️ Configuration File

The plugin automatically generates a `settings.json` file in your server's root directory:

```json
{
  "welcomeMessage": "Welcome to the Server!",
  "welcomeSubtitle": "Enjoy your stay",
  "isWelcomeEnabled": true
}
```

## 👨‍💻 Developer

**Nyxis**

---

_Made for Hytale with ❤️_
