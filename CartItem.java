public class CartItem {
    public Product product;
    public int quantity;
    public double weight;
    
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        if (product instanceof Shippable) {
            this.weight = ((Shippable) product).getWeight() * quantity;
        } else {
            this.weight = 0.0;
        }
    }
    public int getTotalPrice() {
        return product.price * quantity;
    }
    
    public void displayItem() {
        System.out.println(quantity + "x " + product.name + " - $" + getTotalPrice());
    }
}