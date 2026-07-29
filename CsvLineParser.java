package Task5;

import java.util.Scanner;
public class CsvLineParser {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter CSV record: ");
        String record = input.nextLine();
        String[] fields = record.split(",");
        if (fields.length != 3) {
            System.out.println("Invalid record.");
            input.close();
            return;
        }
        String name = fields[0].trim();
        String ageText = fields[1].trim();
        String city = fields[2].trim();
        int age;
        try {
            age = Integer.parseInt(ageText);
        } catch (NumberFormatException error) {
            System.out.println("Invalid record.");
            input.close();
            return;
        }
        String ageGroup;
        if (age < 18) {
            ageGroup = "Minor";
        } else if (age <= 64) {
            ageGroup = "Adult";
        } else {
            ageGroup = "Senior";
        }
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("City: " + city);
        System.out.println("Age Group: " + ageGroup);
        input.close();
    }
}