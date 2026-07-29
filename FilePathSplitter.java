package Task5;

import java.util.Scanner;
public class FilePathSplitter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter full file path: ");
        String originalPath = input.nextLine().trim();
        if (originalPath.isEmpty()) {
            System.out.println("Invalid path.");
            input.close();
            return;
        }
        boolean hasBackslash = originalPath.contains("\\");
        String updatedPath = originalPath.replace('\\', '/');
        int slashPosition = updatedPath.lastIndexOf('/');
        String folder;
        String fileName;
        if (slashPosition >= 0) {
            folder = updatedPath.substring(0, slashPosition);
            fileName = updatedPath.substring(slashPosition + 1);
        } else {
            folder = "none";
            fileName = updatedPath;
        }
        int dotPosition = fileName.lastIndexOf('.');
        String extension;
        if (dotPosition > 0 && dotPosition < fileName.length() - 1) {
            extension = fileName.substring(dotPosition + 1).toLowerCase();
        } else {
            extension = "none";
        }
        String pathStyle;
        if (hasBackslash) {
            pathStyle = "Windows Path";
        } else {
            pathStyle = "Unix Path";
        }
        IO.println("Path: " + originalPath);
        IO.println("Folder: " + folder);
        IO.println("File Name: " + fileName);
        IO.println("Extension: " + extension);
        IO.println("Path Style: " + pathStyle);
        input.close();
    }
}
