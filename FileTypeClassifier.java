package Task5;

import java.util.ArrayList;
public class FileTypeClassifier {
    public static void main(String[] args) {
        ArrayList<String> fileNames = new ArrayList<>();
        fileNames.add("report.pdf");
        fileNames.add("photo.png");
        fileNames.add("program.java");
        fileNames.add("notes.txt");
        fileNames.add("website.js");
        fileNames.add("picture.jpg");
        fileNames.add("data.csv");
        fileNames.add("readme");
        int documentCount = 0;
        int imageCount = 0;
        int codeCount = 0;
        int otherCount = 0;
        for (String fileName : fileNames) {
            int dotPosition = fileName.lastIndexOf('.');
            String extension = "";
            String fileType;
            if (dotPosition > 0 && dotPosition < fileName.length() - 1) {
                extension = fileName.substring(dotPosition + 1).toLowerCase();
            }
            if (extension.equals("txt") || extension.equals("pdf") || extension.equals("docx")) {
                fileType = "Document";
                documentCount++;
            } else if (extension.equals("jpg") || extension.equals("png")) {
                fileType = "Image";
                imageCount++;
            } else if (extension.equals("java") || extension.equals("py") || extension.equals("js")) {
                fileType = "Code";
                codeCount++;
            } else {
                fileType = "Other";
                otherCount++;
            }
            System.out.println(fileName + " - " + fileType);
        }
        IO.println("Total Files: " + fileNames.size());
        IO.println("Documents: " + documentCount);
        IO.println("Images: " + imageCount);
        IO.println("Code Files: " + codeCount);
        IO.println("Other Files: " + otherCount);
    }
}
