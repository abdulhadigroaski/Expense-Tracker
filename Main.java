import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();
        manager.loadFromFile();
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd MMM YYYY");
        DateTimeFormatter time = DateTimeFormatter.ofPattern("hh:mm a");
        while (true) {
            System.out.println("\n====== Expense Manager ======\n");
            System.out.println("====== Date: "+ LocalDate.now().format(date)+" ======" );
            System.out.println("====== Time: " + LocalTime.now().format(time)+" ======\n");
            System.out.println("1. Add expense");
            System.out.println("2. Search expense");
            System.out.println("3. Display expenses");
            System.out.println("4. Delete an expense");
            System.out.println("5. Statistics");
            System.out.println("6. Exit");
            System.out.println("====== Enter your choice ====== ");
            int choice;
            try {
                choice = input.nextInt();
                input.nextLine(); 
            }
            catch (InputMismatchException e) {
                System.out.println("Enter a valid number.");
                input.nextLine();
                continue;
            }
            switch (choice) {
                case 1:
                    manager.addExpense(input);
                    break;
                case 2:
                    manager.searchExpense(input);
                    break;
                case 3:
                    manager.displayExpenses(input);
                    break;
                case 4:
                    manager.deleteExpense(input);
                    break;
                case 5:
                    manager.Statistics(input);
                    break;
                case 6:
                    manager.saveToFile();
                    System.out.println("Saved sucessfully");
                    input.close();
                    return;
                default:
                    System.out.println("Invalid Choice.");
            }

        }
    }
}
