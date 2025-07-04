public class ShippableProduct extends Product implements Shippable {
    private double weight;
    
    public ShippableProduct(String name, int price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }
    
    @Override
    public boolean isExpired() {
        return false; 
    }
    
    @Override
    public boolean isShippable() {
        return true; 
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public double getWeight() {
        return weight;
    }
    
    public boolean isHeavyItem() {
        return weight > 5.0;
    }
}