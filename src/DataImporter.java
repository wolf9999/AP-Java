/*
*@wolf9999 [Janani]
*@version 1.0
*@since 2025
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataImporter {

    private static final String[] COLUMN_NAMES = {
        "total_bill", "tip", "sex", "smoker", "day", "time", "size"
    };
    
    private static final String[] COLUMN_DESCRIPTIONS = {
        "Total Bill Amount ($)",
        "Tip Amount ($)", 
        "Customer Gender",
        "Smoker Status",
        "Day of Week",
        "Meal Time",
        "Party Size"
    };
    
    private static final String DATA_FILE = "data/tips.csv";
    
    public static int countCommas(String line) {
        if (line == null || line.isEmpty()) {
            return 0;
        }
        
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ',') {
                count++;
            }
        }
        return count;
    }
    
   
    public static String getColumnValue(String line, int columnIndex) {
        if (line == null || line.isEmpty()) {
            return "";
        }
        
        if (columnIndex < 0) {
            return "";
        }
        
        int currentColumn = 0;
        int startIndex = 0;

        for (int i = 0; i <= line.length(); i++) {
            if (i == line.length() || line.charAt(i) == ',') {
                if (currentColumn == columnIndex) {
                    String value = line.substring(startIndex, i);
                    return value.trim();
                }
                currentColumn++;
                startIndex = i + 1;
            }
        }
        
        return "";
    }
    

    public static int chooseDataPoint() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("        RESTAURANT TIPS DATA ANALYSIS MENU");
        System.out.println("=".repeat(60));
        System.out.println();
        
        System.out.println("Choose a numerical column to analyze:");
        System.out.println("1. " + COLUMN_DESCRIPTIONS[0] + " (" + COLUMN_NAMES[0] + ")");
        System.out.println("2. " + COLUMN_DESCRIPTIONS[1] + " (" + COLUMN_NAMES[1] + ")");
        System.out.println("3. " + COLUMN_DESCRIPTIONS[6] + " (" + COLUMN_NAMES[6] + ")");
        System.out.println("0. Exit Program");
        
        System.out.println("\n" + "=".repeat(60));
        System.out.print("Enter your choice (0-3): ");
        
        try {
            int choice = scanner.nextInt();

            if (choice >= 0 && choice <= 3) {
                return choice;
            } else {
                System.out.println("Invalid choice. Please select a number between 0 and 3.");
                return -1;
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); 
            return -1;
        }
    }
  
    public static void analyzeData() throws FileNotFoundException {

        int choice = chooseDataPoint();
        
        if (choice == 0) {
            System.out.println("Exiting program. Goodbye!");
            return;
        }
        
        if (choice == -1) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }

        int columnIndex;
        String columnName;
        if (choice == 1) {
            columnIndex = 0; 
            columnName = COLUMN_NAMES[0];
        } else if (choice == 2) {
            columnIndex = 1; 
            columnName = COLUMN_NAMES[1];
        } else if (choice == 3) {
            columnIndex = 6; 
            columnName = COLUMN_NAMES[6];
        } else {
            System.out.println("Invalid choice.");
            return;
        }
        
        File file = new File(DATA_FILE);
        Scanner fileScanner = new Scanner(file);

        if (fileScanner.hasNextLine()) {
            fileScanner.nextLine();
        }
        
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        double sum = 0.0;
        int count = 0;
        
        System.out.println("\nAnalyzing column: " + columnName);
        System.out.println("Processing data...\n");
        

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            
   
            if (line.trim().isEmpty()) {
                continue;
            }
            
            if (countCommas(line) != COLUMN_NAMES.length - 1) {
                System.out.println("Warning: Skipping malformed line: " + line);
                continue;
            }
            
            String valueString = getColumnValue(line, columnIndex);
            
            try {
                double value = Double.parseDouble(valueString);
                

                if (value < min) {
                    min = value;
                }
                if (value > max) {
                    max = value;
                }
                sum += value;
                count++;
                
            } catch (NumberFormatException e) {
                System.out.println("Warning: Non-numerical value found: " + valueString);
            }
        }
        
        fileScanner.close();
        
        if (count > 0) {
            double average = sum / count;
            
            System.out.println("=".repeat(50));
            System.out.println("STATISTICAL ANALYSIS RESULTS");
            System.out.println("=".repeat(50));
            System.out.println("Column Analyzed: " + columnName);
            System.out.println("Total Records Processed: " + count);
            System.out.println();
            System.out.printf("Minimum Value: %.2f%n", min);
            System.out.printf("Maximum Value: %.2f%n", max);
            System.out.printf("Average Value: %.2f%n", average);
            System.out.printf("Range: %.2f%n", (max - min));
            System.out.println("=".repeat(50));
        } else {
            System.out.println("No valid numerical data found in the selected column.");
        }
    }
    
   
    public static void testMethods() {
        System.out.println("TESTING DATAIMPORTER METHODS");
        System.out.println("=".repeat(40));
        
        String testLine = "16.99,1.01,Female,No,Sun,Dinner,2";
        
        System.out.println("1. Testing countCommas method:");
        System.out.println("   Test Line: " + testLine);
        System.out.println("   Number of commas: " + countCommas(testLine));
        System.out.println("   Expected: " + (COLUMN_NAMES.length - 1));
        System.out.println("   Result: " + (countCommas(testLine) == COLUMN_NAMES.length - 1 ? "PASS" : "FAIL"));
        System.out.println();
        
        System.out.println("2. Testing getColumnValue method:");
        for (int i = 0; i < COLUMN_NAMES.length; i++) {
            String value = getColumnValue(testLine, i);
            System.out.println("   Column " + i + " (" + COLUMN_NAMES[i] + "): " + value);
        }
        System.out.println();
        
        System.out.println("3. Testing edge cases:");
        System.out.println("   Empty string commas: " + countCommas(""));
        System.out.println("   Null string commas: " + countCommas(null));
        System.out.println("   Invalid column index: '" + getColumnValue(testLine, 10) + "'");
        System.out.println("   Negative column index: '" + getColumnValue(testLine, -1) + "'");
        System.out.println();
        
        System.out.println("4. Testing chooseDataPoint method:");
        System.out.println("   (Interactive menu will appear)");
    }
    
    
    public static void main(String[] args) {
        System.out.println("RESTAURANT TIPS DATA ANALYZER");
        System.out.println("AP Computer Science A - Data Analysis Project");
        System.out.println();
        
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Test Methods");
            System.out.println("2. Analyze Data");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            
            try {
                int choice = scanner.nextInt();
                
                switch (choice) {
                    case 1:
                        testMethods();
                        break;
                    case 2:
                        try {
                            analyzeData();
                        } catch (FileNotFoundException e) {
                            System.out.println("Error: Data file '" + DATA_FILE + "' not found.");
                            System.out.println("Please ensure the file exists in the correct location.");
                        }
                        break;
                    case 3:
                        System.out.println("Thank you for using the Restaurant Tips Data Analyzer!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }
}