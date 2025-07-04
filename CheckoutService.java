import java.util.ArrayList;
import java.util.List;

public class CheckoutService {
    private static final int SHIPPING_FEE = 30; 
    
    public static void processOrder(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Oops! Your cart is empty. Add some items first!");
            return;
        }
                
        int subtotal = 0;
        int shippingFee = 0;
        double totalWeight = 0;
        List<Shippable> itemsToShip = new ArrayList<>();
        
        for (CartItem item : cart.getItems()) {
            if (item.product.isExpired()) {
                throw new IllegalStateException("Sorry, the " + item.product.name + 
                    " has expired and cannot be sold!");
            }
            
            if (item.quantity > item.product.quantity) {
                throw new IllegalStateException("Sorry, we're out of stock for " + 
                    item.product.name + "!");
            }
            
            subtotal += item.product.price * item.quantity;
            totalWeight += item.weight; 
            
            if (item.product.isShippable()) {
                for (int i = 0; i < item.quantity; i++) {
                    itemsToShip.add((Shippable) item.product);
                }
            }
        }
        
        if (!itemsToShip.isEmpty()) {
            shippingFee = SHIPPING_FEE;
            ShippingService.createShipment(itemsToShip);
        }
        
        int totalAmount = subtotal + shippingFee;
        
        if (customer.balance < totalAmount) {
            System.out.println("Sorry " + customer.name + ", you need $" + 
                (totalAmount - customer.balance) + " more to complete this purchase.");
            return;
        }
        
        customer.balance -= totalAmount;
        
        printReceipt(customer, cart, subtotal, shippingFee, totalAmount, totalWeight);
    }
    
    private static void printReceipt(Customer customer, Cart cart, int subtotal, 
                                   int shippingFee, int totalAmount, double totalWeight) {
        
        System.out.print("--------------------------------");
        System.out.println("\nRECEIPT FOR " + customer.name );
        
        for (CartItem item : cart.getItems()) {
            double itemWeight = item.weight;
            System.out.printf("%dx %-15s $%d", 
                item.quantity, 
                item.product.name, 
                item.product.price * item.quantity);
            
            if (itemWeight > 0) {
                System.out.printf(" (%.2fkg)", itemWeight);
            }
            System.out.println();
        }

        System.out.println("--------------------------------");
        System.out.printf("Subtotal:        $%d\n", subtotal);
        if (shippingFee > 0) {
            System.out.printf("Shipping:        $%d\n", shippingFee);
        }
        System.out.printf("Total:           $%d\n", totalAmount);
        System.out.printf("Remaining Balance: $%d\n", customer.balance);
        if (totalWeight > 0) {
            System.out.printf("Total Weight:    %.2fkg\n", totalWeight);
        }    }
}