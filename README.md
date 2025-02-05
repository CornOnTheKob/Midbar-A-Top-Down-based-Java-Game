# Midbar-A-Top-Down-based-Java-Game

# Original Title: Midbar: The Secrets of the Lost Wilderness

**By:** Jacob Lorenzo A. Cano & Maigela Zia L. Garcia  
**Course:** CSCI 22

## How to Run
1. Open your terminal and navigate to the project directory.  
2. Compile the code with:
   ```bash
   javac *.java
   java GameStarter.java

   *For local playing purposes only.

3. Server Multiplayer is currently disabled as the software used for that (AWS) is not used anymore. 

## Introduction

*Midbar: The Secrets of the Lost Wilderness* is a treasure-hunting RPG where two players, twins Martin and Mary, embark on a quest to save their sick grandfather, Lazarus. To heal him, they must find a magical crystal hidden in the lost wilderness. This crystal can only be accessed after collecting the Four Elemental Gemstones: Wind, Water, Earth, and Fire.  

Players will explore a map teeming with magic and danger, encountering mobs, healing pools, teleportation hubs, and hidden paths. Collaboration is key to surviving and solving the challenges presented in *Midbar*.

---

## Game Features

### Gameplay Objectives:
1. **Explore the map:** Discover the four biomes representing Fire, Earth, Water, and Air.
2. **Collect gemstones:** Unlock special powers as you collect each gemstone.
3. **Find the crystal:** Gather all gemstones to reveal and claim the magical crystal.

### Biome Names and Gemstones:
- **Fire (Red):** Mt. Sinai  
- **Earth (Brown):** Midian  
- **Air (Green):** Tof  
- **Water (White):** Siloam  

### Power-Ups:
- **Water Gemstone:** Launch a growing orb [Press Spacebar].  
- **Fire Gemstone:** Shoot flame boomerangs in 8 directions [Press 1].  
- **Earth Gemstone:** Throw a large projectile [Press 2].  
- **Air Gemstone:** Place a growing bubble trap [Press 3].  

### Multiplayer Mechanics:
- Requires two players to start.  
- Both players are teleported to semi-random locations at game start.  

### Additional Features:
- Healing pools inspired by the Pools of Siloam.  
- Interactive signs sharing historical and Biblical context.  
- A "Heaven-Limbo" mechanic for players who lose all lives.  
- Randomized mob movements and item placement, synchronized across clients.

---

## Networking Summary
- Synchronizes player data (e.g., health, lives), mob states, projectiles, and item placements.  
- Utilizes random seeds for mob movement, spawn points, and item locations.

---

## How to Play
1. Start the **GameServer** before launching the game for each player.  
2. Use **W-A-S-D** to move your character.  
3. Work together to explore, collect gemstones, and claim the crystal to win.  

---

## Credits and References
- Biblical themes and characters inspired by stories of Lazarus, Mt. Sinai, and more.  
- Referenced materials:  
  - [Raising of Lazarus Summary and Analysis](https://interestingliterature.com/2021/06/bible-jesus-raising-lazarus-summary-analysis)  
  - [ESV Bible](https://esv.literalword.com/)  

Enjoy the adventure and uncover the secrets of *Midbar*!
