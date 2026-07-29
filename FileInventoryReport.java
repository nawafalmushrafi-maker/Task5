package Task5;

public class FileInventoryReport {
    public static void main(String[] args) {
        String[] fileRecords = {
                "report.pdf,250",
                "photo.png,340",
                "music.mp3,5000",
                "app.java,8",
                "notes.txt,20",
                "archive.zip,750",
                "invalidRecord"
        };
        double totalSize = 0;
        int documentCount = 0;
        int imageCount = 0;
        int audioCount = 0;
        int codeCount = 0;
        int otherCount = 0;
        int totalFiles = 0;
        String largestFile = "";
        double largestSize = 0;
        for (String record : fileRecords) {
            String[] fields = record.split(",");
            if (fields.length != 2) {
                System.out.println("Skipping invalid record: " + record);
                continue;
            }
            String fileName = fields[0].trim();
            double fileSize;
            try {
                fileSize = Double.parseDouble(fields[1].trim());
            } catch (NumberFormatException error) {
                System.out.println("Skipping invalid record: " + record);
                continue;
            }
            int dotPosition = fileName.lastIndexOf('.');
            String extension;
            if (dotPosition > 0 && dotPosition < fileName.length() - 1) {
                extension = fileName.substring(dotPosition + 1).toLowerCase();
            } else {
                extension = "none";
            }
            String fileType;
            if (extension.equals("txt") || extension.equals("pdf") || extension.equals("docx") || extension.equals("xlsx")) {
                fileType = "Document";
                documentCount++;
            } else if (extension.equals("jpg") || extension.equals("png") || extension.equals("gif")) {
                fileType = "Image";
                imageCount++;
            } else if (extension.equals("mp3") || extension.equals("wav")) {
                fileType = "Audio";
                audioCount++;
            } else if (extension.equals("java") || extension.equals("py") || extension.equals("js")) {
                fileType = "Code";
                codeCount++;
            } else {
                fileType = "Other";
                otherCount++;
            }
            totalFiles++;
            totalSize += fileSize;
            if (fileSize > largestSize) {
                largestSize = fileSize;
                largestFile = fileName;
            }
            System.out.println("Name: " + fileName + " | Extension: " + extension + " | Type: " + fileType + " | Size: " + fileSize + " KB");
        }
        System.out.println("Total Files: " + totalFiles);
        System.out.println("Total Size: " + totalSize + " KB");
        System.out.println("Documents: " + documentCount);
        System.out.println("Images: " + imageCount);
        System.out.println("Audio Files: " + audioCount);
        System.out.println("Code Files: " + codeCount);
        System.out.println("Other Files: " + otherCount);
        System.out.println("Largest File: " + largestFile);
        System.out.println("Largest File Size: " + largestSize + " KB");
    }
}

