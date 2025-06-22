package com.utils;
import java.util.regex.Pattern;

public class InputValidator {
    private static final Pattern INVALID_CHARS_PATTERN = Pattern.compile("[<>:\"/\\\\|?*]");
    // Constants for file name validation
    private static final int MAX_FILENAME_LENGTH = 255;
    private static final int MIN_FILENAME_LENGTH = 3;
    public int validateMenuChoice(String input, int minChoice, int maxChoice)
            throws NumberFormatException, IllegalArgumentException {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Input cannot be empty");
        }
        int choice = Integer.parseInt(input.trim());
        if (choice < minChoice || choice > maxChoice) {
            throw new IllegalArgumentException(
                    String.format("Choice must be between %d and %d", minChoice, maxChoice));
        }
        return choice;
    }
    /**
     * - Not null/empty
     * - Length between 3 and 255
     * - No invalid characters
     * - Must have an extension
     */
    public boolean isValidFileName(String fileName) {
        if (fileName == null || fileName.trim().isEmpty()) {
            return false;
        }
        fileName = fileName.trim();
        if (fileName.length() < 3 || fileName.length() > 255) {
            return false;
        }
        if (fileName.matches(".*[<>:\"/\\\\|?*].*")) {
            return false;
        }
        return fileName.contains(".");
    }

    public boolean isNotEmpty(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public String getFileNameValidationError(String fileName) {
        if (fileName == null || fileName.trim().isEmpty()) {
            return "File name cannot be empty";
        }
        fileName = fileName.trim();
        if (fileName.length() < MIN_FILENAME_LENGTH) {
            return "File name must be at least " + MIN_FILENAME_LENGTH + " characters long";
        }
        if (fileName.length() > MAX_FILENAME_LENGTH) {
            return "File name cannot exceed " + MAX_FILENAME_LENGTH + " characters";
        }
        if (INVALID_CHARS_PATTERN.matcher(fileName).find()) {
            return "File name contains invalid characters: < > : \" / \\ | ? *";
        }
        if (!fileName.contains(".")) {
            return "File name must have an extension (e.g., .txt, .doc)";
        }
        return "File name format is invalid";
    }
}
