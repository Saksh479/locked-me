# LockedMe.com - File Management Application

[![Java](https://img.shields.io/badge/Java-17+-orange.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.6+-blue.svg)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

## 📋 Project Overview

LockedMe.com is a command-line file management application developed for **Company Lockers Pvt. Ltd.** as their first digital transformation project. This prototype application provides comprehensive file management capabilities with an intuitive user interface.

## 👨‍💻 Developer Information

- **Developer**: Your Name
- **Role**: Full Stack Developer
- **Company**: Company Lockers Pvt. Ltd.
- **Version**: 1.0
- **Development Period**: 3 Weeks (15 Working Days)

## 🎯 Application Features

### Core Functionalities

1. **📊 Display Files**: List all files in ascending order
2. **➕ Add Files**: Add new files to the directory
3. **➖ Delete Files**: Remove files from the directory (case-sensitive)
4. **🔍 Search Files**: Search for specific files (case-sensitive)
5. **🧭 Navigation**: User-friendly menu navigation
6. **🚪 Exit**: Graceful application termination

### Technical Features

- **Exception Handling**: Robust error handling for all operations
- **Input Validation**: Comprehensive input validation and sanitization
- **Collections Framework**: Efficient use of Java Collections (TreeSet, ArrayList)
- **Sorting Algorithms**: Optimized sorting techniques for file listing
- **Search Algorithms**: Fast file search implementation
- **File I/O Operations**: Safe file system operations

## 🏃‍♂️ Sprint Planning

### Sprint 1 (Week 1) - Core Infrastructure

- [x] Project setup and structure
- [x] Basic file operations (add, delete, search)
- [x] Core data structures implementation
- [x] Basic error handling

### Sprint 2 (Week 2) - User Interface & Advanced Features

- [x] Command-line interface development
- [x] Menu navigation system
- [x] Input validation and sanitization
- [x] Enhanced error handling and messaging

### Sprint 3 (Week 3) - Testing & Documentation

- [x] Comprehensive testing suite
- [x] Performance optimization
- [x] Documentation and code comments
- [x] GitHub repository setup

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- Git (for version control)

### Installation & Setup

1. **Clone the Repository**

   ```bash
   git clone https://github.com/yourusername/locked-me.git
   cd locked-me/lmapp
   ```

2. **Compile the Application**

   ```bash
   mvn compile
   ```

3. **Run the Application**

   ```bash
   mvn exec:java -Dexec.mainClass="com.main.Main"
   ```

   Or using Java directly:

   ```bash
   java -cp target/classes com.main.Main
   ```

4. **Run Tests**
   ```bash
   mvn test
   # Or run the test class directly:
   java -cp target/classes com.main.test.LockedMeTest
   ```

## 📱 User Interface Flow

```
┌─────────────────────────────────────────┐
│          Welcome Screen                 │
│  🔐 LockedMe.com v1.0                  │
│  📋 File Management System             │
│  🏢 Company Lockers Pvt. Ltd.         │
│  👨‍💻 Developed by: Your Name            │
└─────────────────────────────────────────┘
                    │
                    ▼
┌─────────────────────────────────────────┐
│              Main Menu                  │
│  1. 📊 Display files in ascending order│
│  2. ⚙️  File operations menu           │
│  3. 🚪 Exit application                │
└─────────────────────────────────────────┘
                    │
            ┌───────┴───────┐
            ▼               ▼
    ┌─────────────┐  ┌─────────────────┐
    │File Listing │  │File Operations  │
    │   (Sorted)  │  │      Menu       │
    └─────────────┘  └─────────────────┘
                            │
            ┌───────────────┼───────────────┐
            ▼               ▼               ▼
    ┌─────────────┐ ┌─────────────┐ ┌─────────────┐
    │  Add File   │ │Delete File  │ │Search File  │
    └─────────────┘ └─────────────┘ └─────────────┘
```

## 🔧 Core Concepts & Algorithms

### Data Structures Used

1. **TreeSet**: For maintaining sorted file collection with O(log n) operations
2. **ArrayList**: For returning sorted file lists
3. **HashMap**: For file statistics and metadata
4. **LinkedList**: For temporary operations (if needed)

### Algorithms Implemented

1. **Sorting Algorithm**:

   - Natural ordering using TreeSet
   - Collections.sort() for case-insensitive sorting
   - Time Complexity: O(n log n)

2. **Search Algorithm**:

   - Binary search in sorted collection
   - Stream-based filtering for pattern matching
   - Time Complexity: O(log n) for exact match, O(n) for pattern

3. **File Management Algorithm**:
   - Efficient add/remove operations
   - Duplicate detection using Set properties
   - Case-sensitive vs case-insensitive operations

### Design Patterns

- **Model-View-Controller (MVC)**: Separation of concerns
- **Strategy Pattern**: Different validation strategies
- **Template Method**: Common operation workflows

## 📁 Project Structure

```
lmapp/
├── pom.xml                           # Maven configuration
├── README.md                         # Project documentation
├── ALGORITHMS.md                     # Detailed algorithms documentation
├── FLOWCHART.md                      # Application flow diagrams
└── src/
    ├── main/
    │   └── java/
    │       └── com/
    │           └── main/
    │               ├── Main.java                    # Application entry point
    │               ├── service/
    │               │   └── LockedMeApp.java        # Main application service
    │               ├── model/
    │               │   └── FileManager.java        # File operations model
    │               └── utils/
    │                   └── InputValidator.java     # Input validation utilities
    └── test/
        └── java/
            └── com/
                └── main/
                    └── test/
                        └── LockedMeTest.java       # Comprehensive test suite
```

## 🧪 Testing

The application includes a comprehensive test suite covering:

- **Unit Tests**: Individual component testing
- **Integration Tests**: Component interaction testing
- **Performance Tests**: Bulk operation testing
- **Error Handling Tests**: Exception and edge case testing

### Running Tests

```bash
# Run all tests
mvn test

# Run specific test class
java -cp target/classes com.main.test.LockedMeTest

# Test with sample data
java -cp target/classes com.main.test.LockedMeTest
```

## 📊 Performance Metrics

- **File Addition**: O(log n) time complexity
- **File Deletion**: O(log n) time complexity
- **File Search**: O(log n) time complexity
- **File Listing**: O(n log n) time complexity
- **Memory Usage**: Optimized with efficient data structures

## 🔒 Error Handling

The application implements comprehensive error handling for:

- **Invalid File Names**: Validation with detailed error messages
- **File Not Found**: Proper FNF error handling
- **Invalid Menu Choices**: Input validation with retry mechanisms
- **IOException**: File system operation error handling
- **Null/Empty Inputs**: Robust null checking

## 🌟 Unique Selling Points (USPs)

1. **User-Friendly Interface**: Intuitive command-line interface with emojis and clear navigation
2. **Robust Error Handling**: Comprehensive error handling prevents application crashes
3. **Performance Optimized**: Efficient algorithms and data structures for fast operations
4. **Extensible Architecture**: Clean code structure allows easy feature additions
5. **Cross-Platform**: Java-based solution works on Windows, macOS, and Linux
6. **Input Validation**: Comprehensive input validation prevents data corruption
7. **Real-Time File Management**: Immediate file system synchronization

## 🔮 Future Enhancements

1. **GUI Interface**: Desktop application with JavaFX or Swing
2. **Database Integration**: Store file metadata in database
3. **User Authentication**: Multi-user support with login system
4. **File Categories**: Organize files by type or custom categories
5. **Backup & Restore**: Automated backup functionality
6. **Search Filters**: Advanced search with filters and patterns
7. **File Preview**: Quick file content preview
8. **Cloud Integration**: Sync with cloud storage services

## 📚 Dependencies

- **Java Standard Library**: Core Java features
- **Maven**: Build and dependency management
- **JUnit** (Future): Unit testing framework

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 📞 Contact

**Your Name** - Full Stack Developer  
Company Lockers Pvt. Ltd.  
Email: your.email@company.com  
GitHub: [@yourusername](https://github.com/yourusername)

## 🙏 Acknowledgments

- Company Lockers Pvt. Ltd. for the opportunity
- Java community for excellent documentation
- Maven community for build tool support

---

**© 2024 Company Lockers Pvt. Ltd. All rights reserved.**
