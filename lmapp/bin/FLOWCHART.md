# 📊 Application Flow Charts and Diagrams

## 🎯 Overview

This document contains detailed flowcharts and diagrams illustrating the application flow, decision processes, and system architecture of the LockedMe.com file management application.

## 🚀 Main Application Flow

```
┌─────────────────────────────────────────────────────────────────┐
│                        APPLICATION START                        │
└─────────────────────────┬───────────────────────────────────────┘
                          │
                          ▼
┌─────────────────────────────────────────────────────────────────┐
│                    DISPLAY WELCOME SCREEN                      │
│  🔐 LockedMe.com v1.0                                         │
│  📋 File Management System                                     │
│  🏢 Company Lockers Pvt. Ltd.                                │
│  👨‍💻 Developed by: Your Name                                  │
│  📅 Current Date                                               │
│  🎯 Application Features List                                  │
└─────────────────────────┬───────────────────────────────────────┘
                          │
                          ▼
┌─────────────────────────────────────────────────────────────────┐
│                     INITIALIZE COMPONENTS                      │
│  • Create FileManager instance                                 │
│  • Create InputValidator instance                              │
│  • Initialize Scanner for user input                           │
│  • Set application running flag to true                        │
└─────────────────────────┬───────────────────────────────────────┘
                          │
                          ▼
                    ┌─────────┐
                    │ MAIN    │ ◄─────────────────────┐
                    │ MENU    │                       │
                    │ LOOP    │                       │
                    └────┬────┘                       │
                         │                            │
                         ▼                            │
┌─────────────────────────────────────────────────────────────────┐
│                    DISPLAY MAIN MENU                           │
│  ────────────────────────────────────────────────              │
│  📁 LockedMe.com - Main Menu                                   │
│  ────────────────────────────────────────────────              │
│  1. 📊 Display files in ascending order                        │
│  2. ⚙️  File operations menu                                   │
│  3. 🚪 Exit application                                         │
│  ────────────────────────────────────────────────              │
│  Please select an option (1-3):                                │
└─────────────────────────┬───────────────────────────────────────┘
                          │
                          ▼
┌─────────────────────────────────────────────────────────────────┐
│                      GET USER INPUT                            │
│  • Read user input from console                                │
│  • Validate input using InputValidator                         │
│  • Handle invalid input with error messages                    │
│  • Retry on invalid input                                      │
└─────────────────────────┬───────────────────────────────────────┘
                          │
                          ▼
                    ┌─────────┐
                    │ CHOICE  │
                    │ SWITCH  │
                    └────┬────┘
                         │
         ┌───────────────┼───────────────┐
         │               │               │
         ▼               ▼               ▼
    ┌────────┐    ┌─────────────┐   ┌────────┐
    │Choice 1│    │  Choice 2   │   │Choice 3│
    │Display │    │File Operations│   │  Exit  │
    │ Files  │    │    Menu     │   │  App   │
    └───┬────┘    └─────┬───────┘   └───┬────┘
        │               │               │
        │               │               ▼
        │               │         ┌──────────┐
        │               │         │ CLEANUP  │
        │               │         │ & EXIT   │
        │               │         └──────────┘
        │               │
        │               ▼
        │    ┌─────────────────────┐
        │    │  FILE OPERATIONS    │
        │    │      SUBMENU        │
        │    └─────────┬───────────┘
        │              │
        │              ▼
        │    [See File Operations Flow]
        │
        ▼
┌──────────────────────┐
│  DISPLAY FILES       │
│  IN ASCENDING ORDER  │
└─────────┬────────────┘
          │
          ▼
[See File Display Flow]
```

## 📊 File Display Flow

```
┌─────────────────────────────────────────────────────────────────┐
│                    DISPLAY FILES FLOW                          │
└─────────────────────────┬───────────────────────────────────────┘
                          │
                          ▼
┌─────────────────────────────────────────────────────────────────┐
│               CALL FileManager.getAllFilesSorted()             │
└─────────────────────────┬───────────────────────────────────────┘
                          │
                          ▼
                    ┌─────────┐
                    │ FILES   │
                    │ EMPTY?  │
                    └────┬────┘
                         │
                ┌────────┴────────┐
                │                 │
               YES                NO
                │                 │
                ▼                 ▼
┌─────────────────────┐ ┌─────────────────────┐
│  DISPLAY MESSAGE:   │ │    DISPLAY FILES    │
│  "Directory is      │ │  ──────────────────  │
│  empty - no files   │ │  📁 Found X file(s): │
│  found."            │ │  1. filename1.txt    │
└─────────┬───────────┘ │  2. filename2.doc    │
          │             │  3. filename3.pdf    │
          │             │  ... (numbered list) │
          │             └─────────┬───────────┘
          │                       │
          └───────────────────────┘
                          │
                          ▼
┌─────────────────────────────────────────────────────────────────┐
│                WAIT FOR USER TO PRESS ENTER                    │
│               "Press Enter to return to main menu..."          │
└─────────────────────────┬───────────────────────────────────────┘
                          │
                          ▼
                    ┌─────────┐
                    │ RETURN  │
                    │ TO MAIN │
                    │  MENU   │
                    └─────────┘
```

## ⚙️ File Operations Flow

```
┌─────────────────────────────────────────────────────────────────┐
│                  FILE OPERATIONS MENU FLOW                     │
└─────────────────────────┬───────────────────────────────────────┘
                          │
                          ▼
                    ┌─────────┐
                    │ SUBMENU │ ◄────────────────────┐
                    │  LOOP   │                      │
                    └────┬────┘                      │
                         │                           │
                         ▼                           │
┌─────────────────────────────────────────────────────────────────┐
│                 DISPLAY FILE OPERATIONS MENU                   │
│  ──────────────────────────────────────────────────            │
│  ⚙️  File Operations Menu                                       │
│  ──────────────────────────────────────────────────            │
│  1. ➕ Add a file                                               │
│  2. ➖ Delete a file                                             │
│  3. 🔍 Search for a file                                        │
│  4. ⬅️  Return to main menu                                      │
│  ──────────────────────────────────────────────────            │
│  Please select an option (1-4):                                │
└─────────────────────────┬───────────────────────────────────────┘
                          │
                          ▼
┌─────────────────────────────────────────────────────────────────┐
│                    GET USER CHOICE (1-4)                       │
└─────────────────────────┬───────────────────────────────────────┘
                          │
                          ▼
                    ┌─────────┐
                    │ CHOICE  │
                    │ SWITCH  │
                    └────┬────┘
                         │
         ┌───────────────┼─────────────────┐
         │               │                 │
         ▼               ▼                 ▼
    ┌────────┐    ┌─────────────┐    ┌─────────┐
    │Choice 1│    │   Choice 2  │    │Choice 3 │
    │Add File│    │ Delete File │    │ Search  │
    └───┬────┘    └─────┬───────┘    │  File   │
        │               │            └────┬────┘
        │               │                 │
        ▼               ▼                 ▼
[Add File Flow]  [Delete File Flow] [Search File Flow]
        │               │                 │
        │               │                 │
        └───────────────┼─────────────────┘
                        │
                        ▼
                  ┌──────────┐
                  │ Choice 4 │
                  │ Return   │
                  │ to Main  │
                  └─────┬────┘
                        │
                        ▼
                  ┌──────────┐
                  │ EXIT     │
                  │ SUBMENU  │
                  │ LOOP     │
                  └──────────┘
```

## ➕ Add File Flow

```
┌─────────────────────────────────────────────────────────────────┐
│                        ADD FILE FLOW                           │
└─────────────────────────┬───────────────────────────────────────┘
                          │
                          ▼
┌─────────────────────────────────────────────────────────────────┐
│                   PROMPT FOR FILE NAME                         │
│  "Enter file name to add: "                                    │
└─────────────────────────┬───────────────────────────────────────┘
                          │
                          ▼
┌─────────────────────────────────────────────────────────────────┐
│                     GET USER INPUT                             │
│  • Read file name from console                                 │
│  • Trim whitespace                                             │
└─────────────────────────┬───────────────────────────────────────┘
                          │
                          ▼
┌─────────────────────────────────────────────────────────────────┐
│               VALIDATE FILE NAME                               │
│  • Check if null or empty                                      │
│  • Check length (3-255 characters)                             │
│  • Check for invalid characters                                │
│  • Check for reserved names                                    │
│  • Check for proper extension                                  │
└─────────────────────────┬───────────────────────────────────────┘
                          │
                    ┌─────┴─────┐
                    │ VALID?    │
                    └─────┬─────┘
                          │
                 ┌────────┴────────┐
                 │                 │
                NO                YES
                 │                 │
                 ▼                 ▼
┌─────────────────────┐  ┌─────────────────────┐
│  DISPLAY ERROR:     │  │ CALL FileManager   │
│  "Invalid file name!│  │ .addFile(fileName)  │
│  Please enter a     │  └─────────┬───────────┘
│  valid file name."  │            │
└─────────┬───────────┘            ▼
          │              ┌─────────────────────┐
          │              │    FILE EXISTS?     │
          │              └─────────┬───────────┘
          │                        │
          │               ┌────────┴────────┐
          │               │                 │
          │              YES                NO
          │               │                 │
          │               ▼                 ▼
          │    ┌─────────────────┐ ┌─────────────────┐
          │    │ DISPLAY WARNING:│ │ CREATE FILE AND │
          │    │ "File already   │ │ ADD TO SYSTEM   │
          │    │ exists in the   │ └─────────┬───────┘
          │    │ directory."     │           │
          │    └─────────┬───────┘           ▼
          │              │         ┌─────────────────┐
          │              │         │ DISPLAY SUCCESS:│
          │              │         │ "File 'X' added │
          │              │         │ successfully!"  │
          │              │         └─────────┬───────┘
          │              │                   │
          └──────────────┼───────────────────┘
                         │
                         ▼
┌─────────────────────────────────────────────────────────────────┐
│            WAIT FOR USER TO PRESS ENTER                        │
│                "Press Enter to continue..."                    │
└─────────────────────────┬───────────────────────────────────────┘
                          │
                          ▼
                    ┌─────────┐
                    │ RETURN  │
                    │ TO FILE │
                    │ OPERATIONS│
                    └─────────┘
```

## ➖ Delete File Flow

```
┌─────────────────────────────────────────────────────────────────┐
│                      DELETE FILE FLOW                          │
└─────────────────────────┬───────────────────────────────────────┘
                          │
                          ▼
┌─────────────────────────────────────────────────────────────────┐
│                 PROMPT FOR FILE NAME                           │
│  "Enter file name to delete (case-sensitive): "               │
└─────────────────────────┬───────────────────────────────────────┘
                          │
                          ▼
┌─────────────────────────────────────────────────────────────────┐
│                    GET USER INPUT                              │
│  • Read file name from console                                 │
│  • Trim whitespace                                             │
└─────────────────────────┬───────────────────────────────────────┘
                          │
                          ▼
┌─────────────────────────────────────────────────────────────────┐
│              VALIDATE FILE NAME FORMAT                         │
│  • Check if null or empty                                      │
│  • Basic format validation                                     │
└─────────────────────────┬───────────────────────────────────────┘
                          │
                    ┌─────┴─────┐
                    │ VALID?    │
                    └─────┬─────┘
                          │
                 ┌────────┴────────┐
                 │                 │
                NO                YES
                 │                 │
                 ▼                 ▼
┌─────────────────────┐  ┌─────────────────────┐
│  DISPLAY ERROR:     │  │ CALL FileManager   │
│  "Invalid file name!│  │.deleteFile(fileName)│
│  Please enter a     │  └─────────┬───────────┘
│  valid file name."  │            │
└─────────┬───────────┘            ▼
          │              ┌─────────────────────┐
          │              │    FILE FOUND?      │
          │              └─────────┬───────────┘
          │                        │
          │               ┌────────┴────────┐
          │               │                 │
          │              NO                YES
          │               │                 │
          │               ▼                 ▼
          │    ┌─────────────────┐ ┌─────────────────┐
          │    │ DISPLAY ERROR:  │ │ DELETE FILE AND │
          │    │ "File Not Found │ │ REMOVE FROM     │
          │    │ (FNF): 'X' does │ │ SYSTEM          │
          │    │ not exist in    │ └─────────┬───────┘
          │    │ the directory." │           │
          │    └─────────┬───────┘           ▼
          │              │         ┌─────────────────┐
          │              │         │ DISPLAY SUCCESS:│
          │              │         │ "File 'X'       │
          │              │         │ deleted         │
          │              │         │ successfully!"  │
          │              │         └─────────┬───────┘
          │              │                   │
          └──────────────┼───────────────────┘
                         │
                         ▼
┌─────────────────────────────────────────────────────────────────┐
│            WAIT FOR USER TO PRESS ENTER                        │
│                "Press Enter to continue..."                    │
└─────────────────────────┬───────────────────────────────────────┘
                          │
                          ▼
                    ┌─────────┐
                    │ RETURN  │
                    │ TO FILE │
                    │ OPERATIONS│
                    └─────────┘
```

## 🔍 Search File Flow

```
┌─────────────────────────────────────────────────────────────────┐
│                      SEARCH FILE FLOW                          │
└─────────────────────────┬───────────────────────────────────────┘
                          │
                          ▼
┌─────────────────────────────────────────────────────────────────┐
│                 PROMPT FOR FILE NAME                           │
│  "Enter file name to search (case-sensitive): "               │
└─────────────────────────┬───────────────────────────────────────┘
                          │
                          ▼
┌─────────────────────────────────────────────────────────────────┐
│                    GET USER INPUT                              │
│  • Read file name from console                                 │
│  • Trim whitespace                                             │
└─────────────────────────┬───────────────────────────────────────┘
                          │
                          ▼
┌─────────────────────────────────────────────────────────────────┐
│              VALIDATE FILE NAME FORMAT                         │
│  • Check if null or empty                                      │
│  • Basic format validation                                     │
└─────────────────────────┬───────────────────────────────────────┘
                          │
                    ┌─────┴─────┐
                    │ VALID?    │
                    └─────┬─────┘
                          │
                 ┌────────┴────────┐
                 │                 │
                NO                YES
                 │                 │
                 ▼                 ▼
┌─────────────────────┐  ┌─────────────────────┐
│  DISPLAY ERROR:     │  │ CALL FileManager   │
│  "Invalid file name!│  │.searchFile(fileName)│
│  Please enter a     │  └─────────┬───────────┘
│  valid file name."  │            │
└─────────┬───────────┘            ▼
          │              ┌─────────────────────┐
          │              │    FILE FOUND?      │
          │              └─────────┬───────────┘
          │                        │
          │               ┌────────┴────────┐
          │               │                 │
          │              NO                YES
          │               │                 │
          │               ▼                 ▼
          │    ┌─────────────────┐ ┌─────────────────┐
          │    │ DISPLAY RESULT: │ │ DISPLAY RESULT: │
          │    │ "File Not Found:│ │ "File Found: 'X'│
          │    │ 'X' does not    │ │ exists in the   │
          │    │ exist in the    │ │ directory."     │
          │    │ directory."     │ └─────────┬───────┘
          │    └─────────┬───────┘           │
          │              │                   │
          └──────────────┼───────────────────┘
                         │
                         ▼
┌─────────────────────────────────────────────────────────────────┐
│            WAIT FOR USER TO PRESS ENTER                        │
│                "Press Enter to continue..."                    │
└─────────────────────────┬───────────────────────────────────────┘
                          │
                          ▼
                    ┌─────────┐
                    │ RETURN  │
                    │ TO FILE │
                    │ OPERATIONS│
                    └─────────┘
```

## 🔧 FileManager Internal Flow

```
┌─────────────────────────────────────────────────────────────────┐
│                   FileManager INITIALIZATION                   │
└─────────────────────────┬───────────────────────────────────────┘
                          │
                          ▼
┌─────────────────────────────────────────────────────────────────┐
│                  CREATE TreeSet INSTANCE                       │
│  Set<String> virtualFileSystem = new TreeSet<>                │
│  (String.CASE_INSENSITIVE_ORDER);                             │
└─────────────────────────┬───────────────────────────────────────┘
                          │
                          ▼
┌─────────────────────────────────────────────────────────────────┐
│                INITIALIZE DIRECTORY PATH                       │
│  Path directoryPath = Paths.get("lockedme_files");            │
└─────────────────────────┬───────────────────────────────────────┘
                          │
                          ▼
┌─────────────────────────────────────────────────────────────────┐
│                   CREATE DIRECTORY                             │
│  if (!Files.exists(directoryPath)) {                          │
│      Files.createDirectories(directoryPath);                  │
│  }                                                             │
└─────────────────────────┬───────────────────────────────────────┘
                          │
                          ▼
┌─────────────────────────────────────────────────────────────────┐
│                 LOAD EXISTING FILES                            │
│  Files.list(directoryPath)                                    │
│      .filter(Files::isRegularFile)                            │
│      .map(path -> path.getFileName().toString())              │
│      .forEach(virtualFileSystem::add);                        │
└─────────────────────────┬───────────────────────────────────────┘
                          │
                          ▼
                    ┌─────────┐
                    │ READY   │
                    │ FOR     │
                    │ USE     │
                    └─────────┘
```

## 🎯 Error Handling Flow

```
┌─────────────────────────────────────────────────────────────────┐
│                      ERROR OCCURS                              │
└─────────────────────────┬───────────────────────────────────────┘
                          │
                          ▼
                    ┌─────────┐
                    │ ERROR   │
                    │ TYPE?   │
                    └────┬────┘
                         │
         ┌───────────────┼─────────────────┐
         │               │                 │
         ▼               ▼                 ▼
┌─────────────────┐ ┌──────────────┐ ┌─────────────────┐
│ INPUT           │ │ FILE SYSTEM  │ │ VALIDATION      │
│ VALIDATION      │ │ ERROR        │ │ ERROR           │
│ ERROR           │ │ (IOException)│ │ (IllegalArg)    │
└────────┬────────┘ └──────┬───────┘ └────────┬────────┘
         │                 │                  │
         ▼                 ▼                  ▼
┌─────────────────┐ ┌──────────────┐ ┌─────────────────┐
│ DISPLAY ERROR   │ │ DISPLAY ERROR│ │ DISPLAY ERROR   │
│ MESSAGE WITH    │ │ MESSAGE AND  │ │ MESSAGE WITH    │
│ RETRY PROMPT    │ │ LOG DETAILS  │ │ CORRECTION HINT │
└────────┬────────┘ └──────┬───────┘ └────────┬────────┘
         │                 │                  │
         ▼                 ▼                  ▼
┌─────────────────┐ ┌──────────────┐ ┌─────────────────┐
│ RETRY OPERATION │ │ GRACEFUL     │ │ REQUEST VALID   │
│ WITH VALIDATED  │ │ DEGRADATION  │ │ INPUT FROM USER │
│ INPUT           │ │ OR RECOVERY  │ │                 │
└─────────────────┘ └──────────────┘ └─────────────────┘
```

## 📊 Data Flow Diagram

```
┌─────────────┐    ┌─────────────┐    ┌─────────────┐
│    USER     │───▶│  CONSOLE    │───▶│   INPUT     │
│   INPUT     │    │  INTERFACE  │    │ VALIDATOR   │
└─────────────┘    └─────────────┘    └──────┬──────┘
                                             │
                                             ▼
┌─────────────┐    ┌─────────────┐    ┌─────────────┐
│   DISPLAY   │◄───│ LOCKEDME    │◄───│ VALIDATED   │
│   RESULTS   │    │    APP      │    │   INPUT     │
└─────────────┘    └──────┬──────┘    └─────────────┘
                          │
                          ▼
┌─────────────┐    ┌─────────────┐    ┌─────────────┐
│ FILE SYSTEM │◄──▶│    FILE     │◄──▶│   TREESET   │
│ (Physical)  │    │  MANAGER    │    │(In-Memory)  │
└─────────────┘    └─────────────┘    └─────────────┘
```

## 🏗️ Architecture Diagram

```
┌─────────────────────────────────────────────────────────────────┐
│                     PRESENTATION LAYER                         │
│  ┌─────────────────┐  ┌─────────────────┐  ┌──────────────────┐ │
│  │  Welcome Screen │  │   Main Menu     │  │ Operation Menus  │ │
│  └─────────────────┘  └─────────────────┘  └──────────────────┘ │
└─────────────────────────────┬───────────────────────────────────┘
                              │
┌─────────────────────────────────────────────────────────────────┐
│                      SERVICE LAYER                             │
│  ┌─────────────────────────────────────────────────────────────┐ │
│  │              LockedMeApp (Main Service)                     │ │
│  │  • User interaction handling                                │ │
│  │  • Menu navigation                                          │ │
│  │  • Error handling and display                               │ │
│  └─────────────────────────────────────────────────────────────┘ │
└─────────────────────────────┬───────────────────────────────────┘
                              │
┌─────────────────────────────────────────────────────────────────┐
│                      BUSINESS LAYER                            │
│  ┌─────────────────┐              ┌─────────────────────────────┐ │
│  │  FileManager    │              │     InputValidator          │ │
│  │ • File operations│              │ • Input validation          │ │
│  │ • CRUD functions │              │ • Error checking            │ │
│  │ • Sorting/Search │              │ • Format validation         │ │
│  └─────────────────┘              └─────────────────────────────┘ │
└─────────────────────────────┬───────────────────────────────────┘
                              │
┌─────────────────────────────────────────────────────────────────┐
│                      DATA LAYER                                │
│  ┌─────────────────┐              ┌─────────────────────────────┐ │
│  │   TreeSet       │              │     File System            │ │
│  │ (In-Memory)     │◄────────────▶│   (Physical Files)          │ │
│  │ • Sorted storage│              │ • Persistent storage        │ │
│  │ • Fast operations│             │ • File I/O operations       │ │
│  └─────────────────┘              └─────────────────────────────┘ │
└─────────────────────────────────────────────────────────────────┘
```

## 🔄 State Transition Diagram

```
┌─────────────┐
│   START     │
└──────┬──────┘
       │
       ▼
┌─────────────┐
│ INITIALIZED │◄────────────────────┐
└──────┬──────┘                     │
       │                            │
       ▼                            │
┌─────────────┐    ┌─────────────┐   │
│ MAIN_MENU   │───▶│ DISPLAY_    │───┘
│             │    │ FILES       │
└──────┬──────┘    └─────────────┘
       │
       ▼
┌─────────────┐    ┌─────────────┐
│ FILE_OPS_   │───▶│ ADD_FILE    │───┐
│ MENU        │    └─────────────┘   │
└──────┬──────┘                     │
       │           ┌─────────────┐   │
       ├──────────▶│ DELETE_FILE │───┤
       │           └─────────────┘   │
       │                            │
       │           ┌─────────────┐   │
       └──────────▶│ SEARCH_FILE │───┤
                   └─────────────┘   │
                                    │
                   ┌─────────────┐   │
                   │   EXITING   │◄──┘
                   └──────┬──────┘
                          │
                          ▼
                   ┌─────────────┐
                   │ TERMINATED  │
                   └─────────────┘
```

---

**📝 Note**: These flowcharts represent the logical flow and decision processes in the LockedMe.com application. Each flow includes proper error handling, validation, and user feedback mechanisms.
