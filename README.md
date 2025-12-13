# 🎵 Music Management System (Java)

A command-line music management application written in **Java**, designed with a strong focus on **data structures**, **performance**, and **clean architecture**. All core data structures are implemented **from scratch**, without relying on Java’s built-in collections.

---

## 📌 Project Overview

This project simulates a lightweight music platform where users can:

* Manage artists and songs
* Create and manipulate playlists
* Track playback history with undo support
* Retrieve highest- and lowest-rated songs efficiently

The application follows a **modular design**, separating data storage, command handling, and business logic to ensure maintainability and clarity.

---

## 📂 Project Structure

```
src/
│
├── containers/
│   ├── SparseSet        # Custom O(1) artist lookup & storage
│   ├── Queue            # Custom FIFO queue implementation
│   ├── Stack            # Custom stack for playback history (undo)
│   ├── MinMaxHeap       # Custom heap for highest/lowest-rated songs
│
├── handlers/
│   ├── CommandHandler   # Parses and routes all commands
│   ├── ArtistCommand    # Artist-related commands
│   ├── PlayListCommand  # Playlist-related commands
│   ├── HistoryCommand   # Playback history commands
│   └── Command          # Base command type
│
├── holders/
│   └── SongList         # Custom dynamic list for storing songs
│
├── models/
│   ├── Artist           # Artist model
│   ├── Song             # Song model
│   ├── PlayList         # Playlist model
│   └── History          # Playback history entry
│
├── operations/
│   ├── ArtistOps        # Logic for handling artist operations
│   ├── SongOps          # Logic for managing songs
│   └── PlayListOps      # Logic for playlist operations
│
└── Main.java            # Application entry point & CLI loop
```

---

## 🧩 Custom Data Structures

To meet the project requirements, **all core data structures were implemented manually**, without using Java collections such as `ArrayList`, `HashMap`, or `Stack`.

| Data Structure | Purpose                                                |
| -------------- | ------------------------------------------------------ |
| **SparseSet**  | O(1) artist insertion, removal, and lookup             |
| **SongList**   | Custom dynamic array for storing songs                 |
| **Stack**      | Playback history tracking and undo functionality       |
| **Queue**      | Internal command processing (FIFO)                     |
| **MinMaxHeap** | Efficient retrieval of highest- and lowest-rated songs |

These implementations provide:

* Full control over memory and performance
* Predictable time and space complexity
* Deeper understanding of low-level data handling

---

## ⚙️ Architecture Overview

The system is organized into clear layers:

* **Models** — Core entities such as `Artist`, `Song`, and `PlayList`
* **Containers / Holders** — Custom-built data structures
* **Operations** — Business logic for managing entities
* **Handlers** — Command parsing and routing
* **Main** — Application entry point and CLI loop

This separation of concerns makes the codebase easy to extend and test.

---

## ▶️ How to Run

1. Compile the project:

   ```bash
   javac src/Main.java
   ```

2. Run the application:

   ```bash
   java src.Main
   ```

3. Interact with the CLI using supported commands.

---

## 🎯 Key Learning Outcomes

* Implementing fundamental data structures from scratch
* Designing modular Java applications
* Managing time and space complexity
* Building command-driven systems
* Applying clean code and separation of concerns principles

---

## 📄 Notes

* No Java collection framework classes are used
* Designed for educational and academic purposes
* Emphasis on correctness, performance, and clarity

---

## 👤 Author

Developed as part of a data structures–focused Java project.

---

⭐ *Feel free to explore, review, and extend the project!*
