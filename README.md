# spotifun
Project Structure

The project is organized into several modules. Each folder has a specific responsibility, and all data structures used in the project are implemented from scratch (no Java built-in structures such as ArrayList, HashMap, Stack, etc.).

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

🧩 Custom Data Structures Used

To meet the project’s requirements, several core data structures were implemented manually:
SparseSet — for efficient artist indexing (O(1) add/remove/find)
SongList — custom dynamic array for storing songs
Stack — used for playback history and undo_playm
Queue — used internally for command handling
MinMaxHeap — used for retrieving highest/lowest-rated songs efficiently

These structures ensure:
No built-in data-structure libraries
Full control over performance
Optimized time/space complexity
