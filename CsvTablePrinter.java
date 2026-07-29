package Task5;

public class CsvTablePrinter {
    public static void main(String[] args) {
        String[] csvRows = {
                "Name,Age,City",
                "Ali,25,Muscat",
                "Nawaf,30,Nizwa",
                "Omar,19,Salalah",
                "Reem,27,Sohar",
                "Hamed,Muscat"
        };

        String[] headers = csvRows[0].split(",");
        System.out.printf("%-15s %-10s %-15s%n", headers[0], headers[1], headers[2]);
        System.out.println("-".repeat(40));
        int displayedRows = 0;
        for (int i = 1; i < csvRows.length; i++) {
            String[] fields = csvRows[i].split(",");
            if (fields.length != headers.length) {
                System.out.println("Skipping malformed row: " + csvRows[i]);
                continue;
            }
            System.out.printf("%-15s %-10s %-15s%n", fields[0].trim(), fields[1].trim(), fields[2].trim());
            displayedRows++;
        }
        System.out.println("Rows Shown: " + displayedRows);
    }
}

