public abstract class Product {
    public String name;
    public int price;
    public int quantity;
    
    public Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public abstract boolean isExpired();
    
    public abstract boolean isShippable();
    
    public void displayInfo() {
        System.out.println("Product: " + name + " | Price: $" + price + " | Stock: " + quantity);
    }
}