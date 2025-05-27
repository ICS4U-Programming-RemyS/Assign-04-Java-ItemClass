/**
 * This is the Main class to test the Item class.
*
* @author Remy Skelton
* @version 1.0
* @since 2025-05-24
*/

public final class Main {

    /**
     * Private constructor to prevent instantiation.
     */
    private Main() {
        // Empty to prevent instantiation
    }

    /**
     * Main method to run the program.
     *
     * @param args Unused
     */
    public static void main(String[] args) {

        // Create an Item
        Item myItem1 = new Item("Keyboard", 49.99, 2);

        // Print item 1
        System.out.println("Item 1: " + myItem1.getName());

        // Call the methods
        myItem1.getTotalCost();
        // 13% tax
        myItem1.calculateTax(0.13);
        // 10% discount
        myItem1.getDiscountedCost(0.10, 0.13);
        myItem1.getStockStatus();

        // Create another Item
        Item myItem2 = new Item("Monitor", 189.99, 59);

        // Print item 2
        System.out.println("\nItem 2: " + myItem2.getName());

        // Call the methods
        myItem2.getTotalCost();
        // 15% tax
        myItem2.calculateTax(0.15);
        // 5% discount
        myItem2.getDiscountedCost(0.05, 0.15);
        myItem2.getStockStatus();
    }
}
