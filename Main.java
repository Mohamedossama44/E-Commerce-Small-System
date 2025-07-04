public class Main {
    public static void main(String[] args) {
        Product cheeseWedge = new ExpirableProduct("Cheddar Cheese", 85, 12, false, 0.25);
        Product oreos = new ExpirableProduct("Oreo Cookies", 120, 8, false, 0.5);
        Product laptop = new ShippableProduct("Gaming Laptop", 1500, 3, 2.5);
        Product giftCard = new NonShippableProduct("Amazon Gift Card", 50, 25);
        
        Customer Mohamed_Ossama = new Customer("Mohamed_Ossama", 10000);
        
        Cart MohamedOssamaCart = new Cart();
        MohamedOssamaCart.addItem(cheeseWedge, 4);
        MohamedOssamaCart.addItem(oreos, 1);
        MohamedOssamaCart.addItem(giftCard, 1);
        MohamedOssamaCart.addItem(laptop, 1);
        
        CheckoutService.processOrder(Mohamed_Ossama, MohamedOssamaCart);
    }
}