# 🧨 Minesweeper CLI Game (Java - Maven)

This is a command-line implementation of the classic **Minesweeper** game, written in Java using **clean code**, **SOLID principles**, and **TDD practices**. The project is built with Maven and supports modularity, logging, and input validation.

---

## 📋 Features

- Grid-based mine placement with adjustable size and difficulty
- Recursive cell reveal for empty areas
- Victory detection when all non-mine cells are uncovered
- Safe input handling (e.g., A1, B3 etc.)
- Cleanly separated classes (SRP, OOP design)
- Logging using Java built-in logger

---

## 🛠 Requirements

- Java 8 or higher
- Maven 3.x

---

## 🚀 How to Run

### 1. Clone or Download

```bash
git clone <your-github-repo-url>
cd minesweeper-cli
```

### 2. Build the project

```bash
mvn clean install
```

### 3. Run the application

```bash
mvn exec:java
```

---

## 🧪 Run Tests

```bash
mvn test
```

---

## 🗂️ Project Structure

```
src
├── main
│   └── java
│       ├── main                # Entry point
│       ├── model               # Domain: Cell, Minefield
│       ├── service             # DisplayService, InputParser
│       └── util                # GameStatusChecker
└── test
    └── java
        └── ...                 # Unit tests
```

---

## ✅ Design Principles Applied

- **Single Responsibility**: Each class does one job
- **Open/Closed**: Easy to extend logic (e.g., reveal modes, UI)
- **TDD**: Core classes covered with JUnit tests
- **Production-Ready**: Logs, input validation, restart support

---

## 📃 License

This project is licensed under MIT - feel free to fork and customize.

---

## ✨ Author

Built with  clean code interviews and CLI fun!
