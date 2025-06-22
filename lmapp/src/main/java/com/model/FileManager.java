package com.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class FileManager {
    private final String DEFAULT_DIRECTORY = "lockedme_files";
    private final Path directoryPath;
    private Set<String> virtualFileSystem;

    public FileManager() {
        this.directoryPath = Paths.get(DEFAULT_DIRECTORY);
        this.virtualFileSystem = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        loadExistingFiles();
    }

    private void loadExistingFiles() {
        try {
            if (Files.exists(directoryPath) && Files.isDirectory(directoryPath)) {
                Files.list(directoryPath)
                        .filter(Files::isRegularFile)
                        .map(path -> path.getFileName().toString())
                        .forEach(virtualFileSystem::add);
            }
        } catch (IOException e) {
            System.err.println("Error loading existing files: " + e.getMessage());
        }
    }

    public boolean addFile(String fileName) throws IOException {
        if (fileName == null || fileName.trim().isEmpty()) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }
        fileName = fileName.trim();
        if (virtualFileSystem.contains(fileName)) {
            return false;
        }
        Path filePath = directoryPath.resolve(fileName);
        try {
            Files.createFile(filePath);
            virtualFileSystem.add(fileName);
            return true;
        } catch (IOException e) {
            throw new IOException("Failed to create file: " + fileName, e);
        }
    }

    public boolean deleteFile(String fileName) throws IOException {
        if (fileName == null || fileName.trim().isEmpty()) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }
        final String trimmedFileName = fileName.trim();
        boolean found = virtualFileSystem.stream()
                .anyMatch(file -> file.equals(trimmedFileName));
        if (!found) {
            return false;
        }
        Path filePath = directoryPath.resolve(trimmedFileName);
        try {
            if (Files.exists(filePath)) {
                Files.delete(filePath);
            }
            virtualFileSystem.removeIf(file -> file.equals(trimmedFileName));
            return true;
        } catch (IOException e) {
            throw new IOException("Failed to delete file: " + trimmedFileName, e);
        }
    }

    public boolean searchFile(String fileName) {
        if (fileName == null || fileName.trim().isEmpty()) {
            return false;
        }
        final String trimmedFileName = fileName.trim();
        return virtualFileSystem.stream()
                .anyMatch(file -> file.equals(trimmedFileName));
    }

    public List<String> getAllFilesSorted() {
        List<String> sortedFiles = new ArrayList<>(virtualFileSystem);
        Collections.sort(sortedFiles, String.CASE_INSENSITIVE_ORDER);
        return sortedFiles;
    }

    public int getFileCount() {
        return virtualFileSystem.size();
    }

    public boolean isEmpty() {
        return virtualFileSystem.isEmpty();
    }

    public String getDirectoryPath() {
        return directoryPath.toAbsolutePath().toString();
    }

    public void refresh() {
        virtualFileSystem.clear();
        loadExistingFiles();
    }

    public List<String> searchFilesByPattern(String pattern) {
        if (pattern == null || pattern.trim().isEmpty()) {
            return new ArrayList<>();
        }
        String regex = pattern.replace("*", ".*").replace("?", ".");
        return virtualFileSystem.stream()
                .filter(fileName -> fileName.matches(regex))
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .collect(Collectors.toList());
    }

    public Map<String, Object> getFileStatistics() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("totalFiles", virtualFileSystem.size());
        stats.put("directoryPath", getDirectoryPath());
        if (!virtualFileSystem.isEmpty()) {
            stats.put("firstFile", Collections.min(virtualFileSystem, String.CASE_INSENSITIVE_ORDER));
            stats.put("lastFile", Collections.max(virtualFileSystem, String.CASE_INSENSITIVE_ORDER));
        }
        return stats;
    }
}
