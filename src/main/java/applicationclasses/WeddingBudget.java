package applicationclasses;

import java.util.ArrayList;
import java.util.List;

import static applicationclasses.ServiceProvider.logger;

public class WeddingBudget {
    private double totalBudget;
    private double remainingBudget;
    private List<Expense> expenses;

    public WeddingBudget(double totalBudget) {
        this.totalBudget = totalBudget;
        this.remainingBudget = totalBudget;
        this.expenses = new ArrayList<>();
    }


    public void addExpense(String name, double amount) {
        expenses.add(new Expense(name, amount));
        remainingBudget -= amount;
    }


    public void viewBudgetStatus() {
        logger.info("Wedding Budget: $" + totalBudget);
       logger.info("Remaining Budget: $" + remainingBudget);
    }


    public void viewExpenseDetails() {
        for (int i = 0; i < expenses.size(); i++) {
            logger.info((i + 1) + ". " + expenses.get(i));
        }
    }


    public double getTotalBudget() {
        return totalBudget;
    }


    public double getRemainingBudget() {
        return remainingBudget;
    }


    private class Expense {
        private String name;
        private double amount;

        public Expense(String name, double amount) {
            this.name = name;
            this.amount = amount;
        }


        @Override
        public String toString() {
            return name + " - $" + amount;
        }
    }
}
