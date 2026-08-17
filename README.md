# Expense Tracker

A console-based Java application for managing personal expenses. The application allows users to add, view, delete, and analyze expenses while storing data persistently using file handling.
## Features

- Add expenses with details such as description, category, amount, and date
- Display recorded expenses
- Delete expenses
- Calculate total expenses
- Count expenses
- See the entire Statistics of your expenses using `HashMap`
- Save expenses to a file
- Load expenses from a file when the application starts
- Exception handling for invalid input and file-related errors
## Technologies & Concepts

- Java
- Object-Oriented Programming (OOP)
- `ArrayList`
- `HashMap`
- File Handling
- Exception Handling
- Java Date and Time API
- Git & GitHub
## How It Works

When the application starts, previously saved expenses are loaded from a file into an `ArrayList`.

The user can then perform different operations through the main menu, such as adding, displaying, deleting, and analyzing expenses.

Changes are kept in memory while the program is running. When the application exits, the current expenses are written back to the file so that the data is available the next time the program starts.


A `HashMap` is used to organize expenses by category and calculate category-wise totals.
-Remember that if you close the console without pressing the key for exit the data entered during the current session  is lost.
## How to Run

1. Clone the repository.
2. Open the project in a Java-compatible IDE such as VS Code.
3. Compile and run the main Java class.
4. Follow the options displayed in the console menu.
## What I Learned

This project was built to apply Java concepts learned through coursework and self-study.

Through this project, I practiced:

- Designing classes and objects
- Working with `ArrayList` and `HashMap`
- Creating methods and passing arguments
- File input and output
- Exception handling
- Working with dates and times
- Organizing a multi-class Java application
- Using Git and GitHub for version control
## Future Improvements

Possible future improvements include adding a graphical user interface, database integration, and additional reporting features.