import java.util.Scanner;

/**
* This is the Main class to test the Item class.
*
* @author Remy Skelton
* @version 1.0
* @since 2025-05-24
*/

public final class Main {

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
    */
    private Main() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Main method to run the program.
     *
     * @param args Unused
     */
    public static void main(final String[] args) {
        // Welcome message
        System.out.println("This program calculates the price"
            + " based on different factors (tax, discount, ext)"
            + "based on user input, enter q for name to quit");

        // Initialize scanner
        Scanner scanner = new Scanner(System.in);

        // Set name
        String name = "";

        // While loop to get input until q is entered for the name
        while (!name.equalsIgnoreCase("q")) {
            try {
                // Ask for name
                System.out.print("Enter item name (or 'q' to quit): ");
                name = scanner.nextLine();

                // Ask for price
                System.out.print("Enter price (e.g., 49.99): ");
                double price = Double.parseDouble(scanner.nextLine());

                // Ask for quantity
                System.out.print("Enter quantity being purchased: ");
                int quantity = Integer.parseInt(scanner.nextLine());

                // Ask for stock
                System.out.print("Enter stock available: ");
                int stock = Integer.parseInt(scanner.nextLine());

                // Ask for tax rate
                System.out.print("Enter tax rate (e.g., 0.13 for 13%): ");
                double taxRate = Double.parseDouble(scanner.nextLine());

                // Ask for discount
                System.out.print("Enter discount rate (e.g., 0.10 for 10%): ");
                double discountRate = Double.parseDouble(scanner.nextLine());

                // Ask if item is perishable
                System.out.print("Is the item perishable? (y/n): ");
                String perishable = scanner.nextLine();

                // If perishable, ask for shelf life
                if (perishable.equalsIgnoreCase("y")) {
                    System.out.print("Enter shelf life in days: ");
                    int shelfLifeInDays = Integer.parseInt(scanner.nextLine());

                    // Print item name
                    System.out.print("Perishable Item: " + name);

                    // Make perishable item
                    PerishableItem myPerishableItem = new
                        PerishableItem(name, price, quantity, stock,
                        taxRate, discountRate, shelfLifeInDays);

                    // Get total cost without tax
                    myPerishableItem.getTotalCost();
                    // Get tax and total with tax
                    myPerishableItem.calculateTax();
                    // Get discounted cost
                    myPerishableItem.getDiscountedCost();
                    // Get the status for the stock
                    myPerishableItem.getStockStatus();
                    // See if the item is expired
                    myPerishableItem.isExpired();

                } else if (perishable.equalsIgnoreCase("n")) {
                    // Print item name
                    System.out.print("Item: " + name);

                    // Make perishable item
                    Item myItem = new Item(name, price, quantity,
                        stock, taxRate, discountRate);

                    // Get total cost without tax
                    myItem.getTotalCost();
                    // Get tax and total with tax
                    myItem.calculateTax();
                    // Get discounted cost
                    myItem.getDiscountedCost();
                    // Get the status for the stock
                    myItem.getStockStatus();
                } else {
                    // Display that the input was invalid
                    System.out.println("Invalid Input,"
                        + " pls enter a valid input\n");
                    // Reset loop
                    continue;
                }

            } catch (NumberFormatException e) {
                // Display that the input was invalid
                System.out.println("Invalid Input, pls enter a valid input\n");
                // Reset loop
                continue;
            }
        }

        // Close scanner
        scanner.close();
    }
}
