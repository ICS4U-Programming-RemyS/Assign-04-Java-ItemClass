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
    /**.
     * TaxRate attribute for the item.
     */
    private double taxRate = 0;
    /**.
     * DiscountRate attribute for the item.
     */
    private double discountRate = 0;

    /**
     * Constructor to initialize an Item.
     *
     * @param name Name of the item
     * @param price Price per unit
     * @param quantity Quantity being purchased
     * @param stock Amount of certain item in store
     * @param taxRate Tax percentage on item
     * @param discountRate Discount percentage on item
     */
    public Item(final String name, final double price, final int quantity,
                final int stock, final double taxRate,
                final double discountRate) {
        // Set the name of the item
        this.name = name;

        // Set the price per unit
        this.price = price;

        // Set the quantity being purchased
        this.quantity = quantity;

        // Set the available stock
        this.stock = stock;

        // Set the tax rate to be applied on the total price
        this.taxRate = taxRate;

        // Set the discount rate to be applied on the total price
        this.discountRate = discountRate;
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
     */
    public void calculateTax() {
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
     */
    public void getDiscountedCost() {
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
     * Displays the stock status based on
     * the purchase quantity and current stock.
     */
    public void getStockStatus() {
        // Check quantity is less than or equal to the stock
        if (quantity <= stock) {
            System.out.println("Stock status: Sufficient Stock");
        } else {
            // If quantity is greater than stock
            System.out.println("Stock status: Insufficient Stock");
        }
    }

}

// Create child class of item class
// Used https://www.w3schools.com/java/ref_keyword_extends.asp
class PerishableItem extends Item {

    /**.
     * shelfLifeInDays attribute for the item.
     */
    private int shelfLifeInDays = 0;

    /**
     * Constructor for the PerishableItem class.
     *
     * @param name Name of the item
     * @param price Price per unit
     * @param quantity Quantity being purchased
     * @param stock Available stock
     * @param taxRate Tax rate to apply
     * @param discountRate Discount rate to apply
     * @param shelfLifeInDays Number of days before expiring
     */
    public PerishableItem(final String name, final double price,
                final int quantity,
                final int stock, final double taxRate,
                final double discountRate, final int shelfLifeInDays) {
        // Call the constructor of the parent class
        // to initialize common item attributes
        super(name, price, quantity, stock, taxRate, discountRate);

        // Initialize the shelf life specific to the perishable item
        this.shelfLifeInDays = shelfLifeInDays;
    }

    public void isExpired() {
        // Check if the shelfLifeInDays is less than 0
        if (shelfLifeInDays < 0) {
            // Display that the perishable item is expired
            System.out.println("The item is expired\n");
        } else {
            // Display that the perishable item is not expired
            System.out.println("The item is not expired\n");
        }
    }
}
