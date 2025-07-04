public class ExpirableProduct extends Product implements Shippable {
    private boolean isExpired;
    private double weight;
    
    public ExpirableProduct(String name, int price, int quantity, boolean isExpired, double weight) {
        super(name, price, quantity);
        this.isExpired = isExpired;
        this.weight = weight;
    }
    
    @Override
    public boolean isExpired() {
        return isExpired;
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
    
    public void markAsExpired() {
        this.isExpired = true;
        System.out.println("Oh no! " + name + " has expired and cannot be sold.");
    }
}