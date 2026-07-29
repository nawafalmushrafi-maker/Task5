package Task5;

import java.util.Scanner;
public class FileNameAnalyzer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        IO.println("Enter file name: ");
        String fileName = input.nextLine().trim();
        int dotPosition = fileName.lastIndexOf('.');
        if (fileName.isEmpty() || dotPosition <= 0 || dotPosition == fileName.length() - 1) {
            IO.println("Invalid file name.");
            input.close();
            return;
        }
        String baseName = fileName.substring(0, dotPosition);
        String extension = fileName.substring(dotPosition + 1).toLowerCase();
        String fileType;
        if (extension.equals("txt") || extension.equals("pdf") || extension.equals("docx")) {
            fileType = "Document";
        } else if (extension.equals("jpg") || extension.equals("png") || extension.equals("gif")) {
            fileType = "Image";
        } else if (extension.equals("mp3") || extension.equals("wav")) {
            fileType = "Audio";
        } else {
            fileType = "Other";
        }
        IO.println("File Name: " + fileName);
        IO.println("Base Name: " + baseName);
        IO.println("Extension: " + extension);
        IO.println("Classification: " + fileType);
        input.close();
    }
}

