/**
 * This class represents an Item with price, quantity, and stock.
 * It includes methods to calculate total cost, tax, discount, and stock status.
 *
 * @author Remy
 * @version 1.0
 * @since 2025-05-24
 */
public class Item {
    /**.
     * Name attribute for the item.
     */
    private String name = "";
    /**.
     * Price attribute for the item.
     */
    private double price = 0;
    /**.
     * Quantity attribute for the item.
     */
    private int quantity = 0;
    /**.
     * Stock attribute for the item.
     */
    private int stock = 0;

    /**
     * Constructor to initialize an Item.
     *
     * @param name Name of the item
     * @param price Price per unit
     * @param quantity Quantity being purchased
     */
    public Item(final String name, final double price, final int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        // Default stock value
        this.stock = 10;
    }

    /**
     * Calculates and prints the total cost before tax and discount.
     */
    public void getTotalCost() {
        // Calculate total cost before tax and discount
        double total = price * quantity;
        // Print the total cost
        System.out.println("Total cost (before tax/discount): $" + total);
    }

    /**
     * Calculates and prints the tax based on the given rate.
     *
     * @param taxRate The tax rate (e.g., 0.13 for 13%)
     */
    public void calculateTax(final double taxRate) {
        // Calculate tax based on price, quantity, and tax rate
        double tax = price * quantity * taxRate;
        // Calculate total cost including tax
        double totalWithTax = (price * quantity) + tax;
        // Print the tax and total cost including tax
        System.out.println("Tax: $" + tax);
        System.out.println("Total cost (including tax): $" + totalWithTax);
    }

    /**
     * Calculates and prints the total cost after applying a discount.
     *
     * @param discountRate The discount rate (e.g., 0.10 for 10%)
     * @param taxRate The tax rate (e.g., 0.13 for 13%)
     */
    public void getDiscountedCost(final double discountRate, final double taxRate) {
        // Calculate total cost before discount
        double total = price * quantity;
        // Calculate the discount
        double discount = total * discountRate;
        // Calculate the discounted total
        double discountedTotal = total - discount;
        // Calculate the final total including tax
        double finalTotal = discountedTotal + (discountedTotal * taxRate);
        // Print the discount and final total
        System.out.println("Discount: $" + discount);
        System.out.println("Total cost after discount (including tax): $"
            + finalTotal);
    }

    /**
     * Gets the name of the item.
     *
     * @return The name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * Displays the stock status based on
     * the purchase quantity and current stock.
     */
    public void getStockStatus() {
        // Check quantity is less than or equal to the stock
        if (quantity <= stock) {
            System.out.println("Stock status: In stock");
        } else {
            // If quantity is greater than stock
            System.out.println("Stock status: Out of stock");
        }
    }
}
