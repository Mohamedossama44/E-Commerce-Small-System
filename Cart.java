import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();
    
    public void addItem(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Hey, you can't add zero or negative items!");
        }
        
        if (quantity > product.quantity) {
            throw new IllegalArgumentException("Sorry, we only have " + product.quantity + 
                " of " + product.name + " in stock!");
        }
        
        items.add(new CartItem(product, quantity));
    }
    
    public boolean isEmpty() {
        return items.isEmpty();
    }
    
    public List<CartItem> getItems() {
        return items;
    }
}