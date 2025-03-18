package expensetrackingsystem;

import java.util.*;

class expense {
    String name, date, category;
    double amount;
    expense(String name, String date, String category, double amount) {
        this.name = name;
        this.date = date;
        this.category = category;
        this.amount = amount;
    }
}

public class expenseTracking {
    static List<expense> expenses = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String [] args) {
    	while (true) {
    		System.out.println("\n1. add expense  2. view expenses  3. total expenses  4. filter by category  5. exit");
    		switch(scanner.nextInt()) {
    		case 1 -> addExpense();
            case 2 -> viewExpenses();
            case 3 -> calculateTotal();
            case 4 -> filterByCategory();
            case 5 -> { System.out.println("Exiting"); return; }
            default -> System.out.println("Not a valid choice");
    			}
    		}
    	}
	
static void addExpense() {
	scanner.nextLine();
	System.out.print("name: ");
	String name = scanner.nextLine();
	System.out.print("Date (Year, Month and Day in format YYYY-MM-DD): ");
	String date = scanner.nextLine();
	System.out.print("Category of expense: ");
	String category = scanner.nextLine();
	System.out.print("Amount of money: ");
	double amount = scanner.nextDouble();
	expenses.add(new expense(name, date, category, amount));
	System.out.println("The expense has been added to the system");
}	
static void viewExpenses() {
	if (expenses.isEmpty()) { System.out.println("There is no expenses"); return; }
	expenses.forEach(e -> System.out.printf("%s, %s, %s, $%.2f\n", e.name, e.date, e.category, e.amount));
}
static void calculateTotal() {
	System.out.printf("Total money: $%.2f\n", expenses.stream().mapToDouble(e -> e.amount).sum());
}
static void filterByCategory() {
	scanner.nextLine();
	System.out.print("Category: ");
	String category = scanner.nextLine();
	 expenses.stream().filter(e -> e.category.equalsIgnoreCase(category))
     .forEach(e -> System.out.printf("%s, %s, $%.2f\n", e.name, e.date, e.amount));
}
}	
