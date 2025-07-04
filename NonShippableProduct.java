public class NonShippableProduct extends Product {
    
    public NonShippableProduct(String name, int price, int quantity) {
        super(name, price, quantity);
    }
    
    @Override
    public boolean isExpired() {
        return false;
    }
    
    @Override
    public boolean isShippable() {
        return false;
    }
    
    public void deliverElectronically() {
        System.out.println( name + " has been delivered to your email instantly!");
    }
}