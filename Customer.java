public class Customer {
    public String name;
    public int balance;
    
    public Customer(String name, int balance) {
        this.name = name;
        this.balance = balance;
        System.out.println("Welcome to our store, " + name );
        System.out.println("Your current balance: $" + balance);
    }
    
    public void addMoney(int amount) {
        balance += amount;
    }
    
    public boolean canAfford(int amount) {
        return balance >= amount;
    }
}