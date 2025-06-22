package com.service;

import com.model.FileManager;
import com.utils.InputValidator;

import java.util.Scanner;

public class LockedMeApp {

    private FileManager fileManager;
    private Scanner scanner;
    private InputValidator validator;
    private boolean isRunning;

    // Application constants
    private static final String APP_NAME = "LockedMe.com";
    private static final String VERSION = "v1.0";
    private static final String COMPANY_NAME = "Company Lockers Pvt. Ltd.";
    private static final String DEVELOPER_NAME = "Saksham Sengar";
    public LockedMeApp() {
        this.fileManager = new FileManager();
        this.scanner = new Scanner(System.in);
        this.validator = new InputValidator();
        this.isRunning = true;
    }

    public void start() {
        displayWelcomeScreen();
        while (isRunning) {
            try {
                displayMainMenu();
                int choice = getUserChoice();
                handleMainMenuChoice(choice);
            } catch (Exception e) {
                System.out.println(" An error occurred: " + e.getMessage());
                System.out.println("Please try again.\n");
            }
        }
        closeApplication();
    }

    private void displayWelcomeScreen() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println(" Welcome to " + APP_NAME + " " + VERSION);
        System.out.println("=".repeat(60));
        System.out.println("File Management System");
        System.out.println("Developed by:" + " " + DEVELOPER_NAME);
        System.out.println("Company: " + COMPANY_NAME);
        System.out.println("" + java.time.LocalDate.now());
        System.out.println("=".repeat(60));
        System.out.println("Application Features:");
        System.out.println("    List files in ascending order");
        System.out.println("    Add files to directory");
        System.out.println("    Delete files from directory");
        System.out.println("    Search for specific files");
        System.out.println("    User-friendly navigation");
        System.out.println("=".repeat(60));
        System.out.println("Press Enter to continue...");
        scanner.nextLine();
    }

    private void displayMainMenu() {
        System.out.println("\n" + "─".repeat(40));
        System.out.println(APP_NAME + " - Main Menu");
        System.out.println("─".repeat(40));
        System.out.println("1. Display files in ascending order");
        System.out.println("2. File operations menu");
        System.out.println("3. Exit application");
        System.out.println("─".repeat(40));
        System.out.print("Please select an option (1-3): ");
    }

    private int getUserChoice() {
        try {
            String input = scanner.nextLine().trim();
            return validator.validateMenuChoice(input, 1, 3);
        } catch (NumberFormatException e) {
            System.out.println(" Invalid input! Please enter a number between 1-3.");
            return getUserChoice();
        } catch (IllegalArgumentException e) {
            System.out.println( e.getMessage());
            return getUserChoice();
        }
    }

    private void handleMainMenuChoice(int choice) {
        switch (choice) {
            case 1:
                displayFilesInAscendingOrder();
                break;
            case 2:
                handleFileOperationsMenu();
                break;
            case 3:
                isRunning = false;
                break;
            default:
                System.out.println("Invalid choice! Please select 1-3.");
        }
    }

    private void displayFilesInAscendingOrder() {
        System.out.println("\n" + "─".repeat(50));
        System.out.println("Files in Directory (Ascending Order)");
        System.out.println("─".repeat(50));

        try {
            var files = fileManager.getAllFilesSorted();
            if (files.isEmpty()) {
                System.out.println("Directory is empty - no files found.");
            } else {
                System.out.println("Found " + files.size() + " file(s):");
                for (int i = 0; i < files.size(); i++) {
                    System.out.printf("%3d. %s%n", (i + 1), files.get(i));
                }
            }
        } catch (Exception e) {
            System.out.println("Error retrieving files: " + e.getMessage());
        }

        System.out.println("─".repeat(50));
        System.out.println("Press Enter to return to main menu...");
        scanner.nextLine();
    }

    private void handleFileOperationsMenu() {
        boolean inSubMenu = true;
        while (inSubMenu) {
            try {
                displayFileOperationsMenu();
                int choice = getFileOperationChoice();
                inSubMenu = handleFileOperationChoice(choice);
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                System.out.println("Please try again.\n");
            }
        }
    }

    private void displayFileOperationsMenu() {
        System.out.println("\n" + "─".repeat(40));
        System.out.println("File Operations Menu");
        System.out.println("─".repeat(40));
        System.out.println("1. Add a file");
        System.out.println("2. Delete a file");
        System.out.println("3. Search for a file");
        System.out.println("4. Return to main menu");
        System.out.println("─".repeat(40));
        System.out.print("Please select an option (1-4): ");
    }

    private int getFileOperationChoice() {
        try {
            String input = scanner.nextLine().trim();
            return validator.validateMenuChoice(input, 1, 4);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a number between 1-4.");
            return getFileOperationChoice();
        } catch (IllegalArgumentException e) {
            System.out.println( e.getMessage());
            return getFileOperationChoice();
        }
    }

    private boolean handleFileOperationChoice(int choice) {
        switch (choice) {
            case 1:
                addFile();
                return true;
            case 2:
                deleteFile();
                return true;
            case 3:
                searchFile();
                return true;
            case 4:
                return false; // Return to main menu
            default:
                System.out.println("Invalid choice! Please select 1-4.");
                return true;
        }
    }

    private void addFile() {
        System.out.println("\n" + "─".repeat(40));
        System.out.println("Add New File");
        System.out.println("─".repeat(40));
        System.out.print("Enter file name to add: ");

        String fileName = scanner.nextLine().trim();

        if (validator.isValidFileName(fileName)) {
            try {
                boolean added = fileManager.addFile(fileName);
                if (added) {
                    System.out.println("File '" + fileName + "' added successfully!");
                } else {
                    System.out.println("File '" + fileName + "' already exists in the directory.");
                }
            } catch (Exception e) {
                System.out.println("Error adding file: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid file name! Please enter a valid file name.");
        }

        System.out.println("Press Enter to continue...");
        scanner.nextLine();
    }

    private void deleteFile() {
        System.out.println("\n" + "─".repeat(40));
        System.out.println("Delete File");
        System.out.println("─".repeat(40));
        System.out.print("Enter file name to delete (case-sensitive): ");

        String fileName = scanner.nextLine().trim();

        if (validator.isValidFileName(fileName)) {
            try {
                boolean deleted = fileManager.deleteFile(fileName);
                if (deleted) {
                    System.out.println("File '" + fileName + "' deleted successfully!");
                } else {
                    System.out.println("File Not Found (FNF): '" + fileName + "' does not exist in the directory.");
                }
            } catch (Exception e) {
                System.out.println("Error deleting file: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid file name! Please enter a valid file name.");
        }

        System.out.println("Press Enter to continue...");
        scanner.nextLine();
    }

    private void searchFile() {
        System.out.println("\n" + "─".repeat(40));
        System.out.println("Search File");
        System.out.println("─".repeat(40));
        System.out.print("Enter file name to search (case-sensitive): ");

        String fileName = scanner.nextLine().trim();

        if (validator.isValidFileName(fileName)) {
            try {
                boolean found = fileManager.searchFile(fileName);
                if (found) {
                    System.out.println("File Found: '" + fileName + "' exists in the directory.");
                } else {
                    System.out.println("File Not Found: '" + fileName + "' does not exist in the directory.");
                }
            } catch (Exception e) {
                System.out.println("Error searching file: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid file name! Please enter a valid file name.");
        }

        System.out.println("Press Enter to continue...");
        scanner.nextLine();
    }

    private void closeApplication() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Closing " + APP_NAME + "...");
        System.out.println("Thank you for using our file management system!");
        System.out.println("Goodbye!");
        System.out.println("=".repeat(50));
        scanner.close();
    }
}
