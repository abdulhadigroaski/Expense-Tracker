import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExpenseManager {
    private ArrayList <Expense> expenses;
    public ExpenseManager () {
        expenses = new ArrayList<>();
    }
    public static void enterToContinue(Scanner input) {
        System.out.println("Press enter to return to main menu. ");
        input.nextLine();
        input.nextLine();
    }
    public void addExpense (Scanner input) {
        System.out.println("Enter the category: ");
        String category = input.nextLine();
        System.out.println("Enter the amount: ");
        double amount;
        try {
            amount = input.nextDouble();
            input.nextLine();  }
        catch (InputMismatchException e ) {
            System.out.print("Invalid amount");
            input.nextLine();
            return;
        }    
        LocalDate today = LocalDate.now();
        Expense expense = new Expense(category, amount, today);
        expenses.add(expense);
        System.out.print("Expense has been added successfully.");
        enterToContinue(input);
    }
    public void displayExpenses (Scanner input) {
        if (expenses.isEmpty())  {
            System.out.println("No expenses found.");
             enterToContinue(input);
            return;
        }
        for ( Expense e : expenses) {
            System.out.println(e);
            System.out.println("------------------------------------------");
        }
        enterToContinue(input);
    }
    public void searchExpense (Scanner input) {
        System.out.println("Enter the category to search");
        String search = input.nextLine();
        for (Expense e : expenses) {
            if (e.getCategory().equalsIgnoreCase(search)) {
                System.out.println(e);
                enterToContinue(input);
                return;
            }
        }
        System.out.println("No expense by this name is found.");
        enterToContinue(input);
    }
    public void deleteExpense (Scanner input) {
        System.out.println("Enter category to delete: ");
        String c = input.nextLine();
        boolean found = false;
        for (int i=0; i<expenses.size(); i++){
            if (expenses.get(i).getCategory().equalsIgnoreCase(c)) {
                expenses.remove(i);
                found = true;
                i--;
            }
        }
        if (found) {
            System.out.println("All expenses of the category  have been removed");
        }
        else {
            System.out.println("No expense of this name is found");
        }
        enterToContinue(input);
    }
    public void Statistics (Scanner input) {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found");
            return; 
        }
        HashMap <String,Double > summary = new HashMap<>();
        double total =0;
        for ( Expense e : expenses ) {
            total += e.getAmount();
            String category = e.getCategory();
            if (summary.containsKey(category)) {
                summary.put(category,summary.get(category)+ e.getAmount());
            }
            else {
                summary.put(category, e.getAmount());
            }
        }
        System.out.println("\n ======= Statistics =======\n");
        System.out.println("Total number of records: "+ expenses.size());
        System.out.println("Total expenditure: "+ total);
        System.out.println("Category Summary");
        for (String c : summary.keySet()) {
            System.out.println( c + ":" + summary.get(c));
        }
        enterToContinue(input);
    }
    public void saveToFile () {
        String filePath = "C:\\Users\\IQ COMPUTER\\OneDrive\\Desktop\\expense.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for ( Expense e : expenses) {
                writer.write(
                    e.getCategory() + "," +e.getAmount() +"," + e.getDate()
                );
                writer.newLine();
            }
        }
        catch (IOException I) {
            System.out.println("Error saving file.");
        }
   }
    public void loadFromFile () {
         String filePath = "C:\\Users\\IQ COMPUTER\\OneDrive\\Desktop\\expense.txt";
         try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = "";
            while ((line = reader.readLine())!= null ) {
                try {
                  String [] parts = line.split(",");
                  String c = parts[0];
                  double amount = Double.parseDouble(parts[1]);
                  LocalDate date = LocalDate.parse(parts[2]);
                  Expense e = new Expense(c, amount, date);
                  expenses.add(e);
                }
                catch (NumberFormatException e ) {
                    System.out.println("Invalid amount skipping line: "+ line);
                }
                catch (DateTimeParseException e ) {
                    System.out.println("Invalid date found. Skipping the line: "+ line);
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Incomplete expense. Skipping line: "+ line);
                }
            }
         }
         catch (FileNotFoundException e) {
            System.out.println("No previous expense found.");
         }
         catch (IOException e ){
            System.out.println("Error loading file");
         }
    }
}
