# The-Last-Warrior
This a simple but interesting command line input game.

HOW TO PLAY
# Clone the repository
git clone https://github.com/Arnav-real/The-Last-Warrior.git

# Navigate to project
cd The-Last-Warrior
$OutputEncoding = [Console]::OutputEncoding = [Text.Encoding]::UTF8\n
Windows users: Run chcp 65001 in terminal before running for proper character rendering.

# Compile
javac Main.java

# Run
java Main

⚡ Features

Endless wave survival — Waves scale in difficulty infinitely. How long can you last?
Turn-based combat — Strategic decisions every turn. Manage your AP wisely.
4 unique abilities — Basic Attack, Fireball, Arrow Shot, Lightning with stun mechanics
6 enemy types — Each with unique special abilities and behaviors
Power-up system — Choose 1 of 3 random power-ups every 3rd wave
Shop system — Spend gold earned from kills between waves
XP & leveling — Kill enemies to level up and permanently boost stats
Fortress structures — Activate defensive mechanisms before waves
Local leaderboard — Your high scores saved between sessions
Real-time countdown — Multithreaded timer during power-up selection


👹 Enemy Types
EnemySpecial Ability👺 GoblinAttacks twice per turn⚔️ SwordsmanBalanced fighter, reliable damage🏹 Archer30% chance to bypass armor🗿 GiantMassive HP, skips every 3rd turn🧙 WizardHeals allies each turn — kill first!🐉 DragonFire Breath every 3rd turn — 1.5x damage

⚡ Abilities
AbilityAP CostEffectBasic AttackFreeDeals ATK damage to one target🔥 Fireball20 APHits all enemies for 30 damage🏹 Arrow Shot10 AP45 damage, ignores DEF completely⚡ Lightning30 APRandom 50% enemies, 60 dmg + 40% stun

🛡️ Power-ups
Power-upEffect🔥 Berserker RageATK +50% for 2 waves🛡️ Iron SkinPermanent DEF +10🧊 Frost BloodEnemies have 25% miss chance🩸 Vampiric StrikeHeal 20% of damage dealt⚡ Last StandATK doubles when HP < 30🌩️ Thunder ClapAuto-hits all enemies every 3rd turn💀 Death's BargainStart at 50% HP but earn 3x gold

🏗️ Architecture & Technical Highlights
This project was built with a strong emphasis on Object-Oriented Design:
Design Patterns Used

Singleton — GameEngine ensures only one game instance exists
Factory — EnemyFactory handles all enemy creation and wave composition
Strategy — Each PowerUp is a swappable strategy object applied to the warrior
Observer — WaveListener interface notifies subscribers on wave events

OOP Concepts Applied

Abstract Classes — Entity, Enemy, Item define shared behavior
Inheritance — Full hierarchy: Entity → Enemy → Goblin/Dragon/etc
Polymorphism — enemy.attack() and enemy.specialAction() behave differently per type
Encapsulation — All fields private/protected, accessed via getters/setters
Interfaces — Attackable, Purchasable, Saveable, WaveListener

Multithreading

CountdownThread runs alongside the main thread during power-up selection
Player has 15 seconds to choose — random pick if timer expires
Uses volatile boolean for safe cross-thread communication


📁 Project Structure
Last-Warrior/
├── engine/
│   ├── GameEngine.java       # Singleton — master game loop
│   ├── BattleEngine.java     # Turn-by-turn combat system
│   └── WaveComposer.java     # Wave difficulty management
├── model/
│   ├── entity/               # Hero, Enemy hierarchy (6 enemy types)
│   ├── item/                 # Abilities, Items, Potions
│   └── structure/            # Fortress defense mechanisms
├── factory/
│   └── EnemyFactory.java     # Wave composition and enemy scaling
├── strategy/                 # 7 PowerUp implementations
├── threads/
│   └── CountdownThread.java  # Real-time powerup timer
├── persistence/
│   └── LeaderboardManager.java
├── exceptions/               # Custom game exceptions
├── ui/
│   └── CLIPrinter.java       # All terminal output, ANSI colors
└── Main.java

🛠️ Built With

Java — Core language
OOP — Abstraction, Inheritance, Polymorphism, Encapsulation
Design Patterns — Singleton, Factory, Strategy, Observer
Multithreading — Java Thread API
ANSI Escape Codes — Terminal colors and styling
File I/O — Leaderboard persistence

👨‍💻 Developer
Arnav Badhe

GitHub: @Arnav-real
