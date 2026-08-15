import java.time.LocalDate;

public class Expense {
    private String category;
    private double amount;
    private LocalDate date;
    public Expense (String category, double amount, LocalDate date) {
        this.category = category;
        this.amount = amount;
        this.date = date;
    }
    public String getCategory () {
        return category;
    }
    public void setCategory (String category) {
        this.category = category;
    }
    public double getAmount () {
        return amount;
    }
    public void setAmount ( Double amount ) {
        this.amount = amount;
    }
    public LocalDate getDate () {
        return date;
    }
    public void setDate (LocalDate date) {
        this.date = date;
    }
    @Override
public String toString() {
    return "Category: " + category +
           "\nAmount: " + amount +
           "\nDate: " + date;
}
}
