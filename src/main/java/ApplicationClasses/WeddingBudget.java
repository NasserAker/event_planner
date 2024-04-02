package ApplicationClasses;

import java.util.ArrayList;
import java.util.List;

public class WeddingBudget {
    private double totalBudget;
    private double remainingBudget;
    private List<Expense> expenses;

    public WeddingBudget(double totalBudget) {
        this.totalBudget = totalBudget;
        this.remainingBudget = totalBudget;
        this.expenses = new ArrayList<>();
    }

    // Method to add an expense
    public void addExpense(String name, double amount) {
        expenses.add(new Expense(name, amount));
        remainingBudget -= amount; // Update remaining budget
    }

    // Method to view current budget status
    public void viewBudgetStatus() {
        System.out.println("Wedding Budget: $" + totalBudget);
        System.out.println("Remaining Budget: $" + remainingBudget);
    }

    // Method to view expense details
    public void viewExpenseDetails() {
        for (int i = 0; i < expenses.size(); i++) {
            System.out.println((i + 1) + ". " + expenses.get(i));
        }
    }

    // Getter for total budget
    public double getTotalBudget() {
        return totalBudget;
    }

    // Getter for remaining budget
    public double getRemainingBudget() {
        return remainingBudget;
    }

    // Internal class to represent an expense
    private class Expense {
        private String name;
        private double amount;

        public Expense(String name, double amount) {
            this.name = name;
            this.amount = amount;
        }

        // toString method to display expense details
        @Override
        public String toString() {
            return name + " - $" + amount;
        }
    }
}
