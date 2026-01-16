# Welcome Message Plugin 🎮

> A lightweight Hytale server plugin to welcome your players with style.

![Hytale](https://img.shields.io/badge/game-Hytale-green.svg)

## ✨ Features

- **Dual-Line Welcome Titles**: Display a vibrant main title (center) and a subtitle (top) when a player joins.
- **Fully Configurable**: Set your messages directly in-game using chat commands.
- **Toggleable**: Admins can easily enable or disable the welcome message.
- **Smart Input Flow**: New 2-step setup wizard with "skip" options for granular control.
- **Persistence**: Settings are saved automatically and persist across server restarts (`settings.json`).

## 🛠️ Usage

### Commands

| Command          | Description                            | Permission |
| :--------------- | :------------------------------------- | :--------- |
| `/togglewelcome` | Toggle auto-welcome message on/off.    | Admin      |
| `/setmessage`    | Start setup wizard (Title & Subtitle). | Admin      |
| `/message`       | Preview current welcome message.       | Admin      |

---

### How to Configure (`/setmessage`)

1.  **Message Up (Subtitle)**: The smaller text displayed above the main title.
2.  **Message Center (Title)**: The main, large text displayed in the center.

_Tip: Type `skip` during any step to leave that line empty._

![Example 1](https://i.imgur.com/eAL3lqw.gif)

---

![Example 2](https://i.imgur.com/d8zmAcM.gif)

## ⚙️ Configuration File

The plugin automatically generates a `settings.json` file in your server's root directory for easy editing.

---

### Links

- **Source Code**: [GitHub Repository](https://github.com/Nyxis-Studio/Hytale-Plugin-WelcomeMessage)
- **Issues**: [Report a Bug](https://github.com/Nyxis-Studio/Hytale-Plugin-WelcomeMessage/issues)

---

_Made for Hytale with ❤️ by Nyxis_
