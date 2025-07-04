# 🛍️E-Commerce System

A Java-based e-commerce system that simulates online shopping with cart management, checkout processing, and shipping services.

## 📋 Table of Contents

- [Features](#features)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Code Examples](#code-examples)
- [Architecture](#architecture)
- [Contributing](#contributing)

## ✨ Features

- **Product Management**: Support for different product types (Expirable, Shippable, Non-Shippable)
- **Shopping Cart**: Add items, manage quantities, and calculate totals
- **Customer Management**: Customer profiles with balance tracking
- **Checkout System**: Complete order processing with validation
- **Shipping Service**: Weight calculation and shipping notifications
- **User-Friendly Interface**: Friendly messages and emoji-rich output
- **Error Handling**: Comprehensive validation and error messages

## 🏗️ Project Structure

```
fawry/
├── Main.java              # Main entry point
├── Cart.java              # Shopping cart management
├── CartItem.java          # Individual cart items
├── CheckoutService.java   # Order processing logic
├── Customer.java          # Customer data and methods
├── Product.java           # Abstract product class
├── ExpirableProduct.java  # Products with expiration dates
├── ShippableProduct.java  # Physical products that can be shipped
├── NonShippableProduct.java # Digital/virtual products
├── Shippable.java         # Interface for shippable items
├── ShippingService.java   # Shipping and delivery management
└── README.md             # This file
```

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Command line interface (Terminal/Command Prompt)

### Installation

1. Clone or download the project files
2. Navigate to the project directory
3. Compile the Java files:
   ```bash
   javac *.java
   ```
4. Run the main program:
   ```bash
   java Main
   ```

## 💻 Usage

### Basic Shopping Flow

1. **Create Products**: Initialize different types of products
2. **Create Customer**: Set up customer with initial balance
3. **Add to Cart**: Add items to the shopping cart
4. **Checkout**: Process the order and complete payment

### Product Types

#### 🧀 Expirable Products
- Food items with expiration dates
- Can be shipped
- Weight-based shipping calculation

```java
Product cheese = new ExpirableProduct("Cheddar Cheese", 85, 12, false, 0.25);
```

#### 📦 Shippable Products
- Physical items that require shipping
- Electronics, books, etc.
- Weight-based shipping fees

```java
Product laptop = new ShippableProduct("Gaming Laptop", 1500, 3, 2.5);
```

#### 💳 Non-Shippable Products
- Digital items (gift cards, software)
- Instant delivery
- No shipping required

```java
Product giftCard = new NonShippableProduct("Amazon Gift Card", 50, 25);
```

## 🔧 Code Examples

### Creating and Processing an Order

```java
// Create products
Product cheese = new ExpirableProduct("Cheddar Cheese", 85, 12, false, 0.25);
Product laptop = new ShippableProduct("Gaming Laptop", 1500, 3, 2.5);

// Create customer
Customer customer = new Customer("John Doe", 2000);

// Create cart and add items
Cart cart = new Cart();
cart.addItem(cheese, 2);
cart.addItem(laptop, 1);

// Process order
CheckoutService.processOrder(customer, cart);
```

### Sample Output

```
Welcome to our store, John Doe! 🛍️
Your current balance: $2000
Added 2x Cheddar Cheese to cart!
Added 1x Gaming Laptop to cart!

=== Processing John Doe's order ===

📦 SHIPPING NOTIFICATION 📦
Your order is being prepared for shipment:
----------------------------------------
• Cheddar Cheese   (250g)
• Cheddar Cheese   (250g)
• Gaming Laptop    (2500g)
----------------------------------------
Total package weight: 3.0kg
Expected delivery: 3-5 business days
Tracking info will be sent to your email!

📄 RECEIPT FOR JOHN DOE 📄
================================
2x Cheddar Cheese  $170 (0.50kg)
1x Gaming Laptop   $1500 (2.50kg)
--------------------------------
Subtotal:        $1670
Shipping:        $30
Total:           $1700
Remaining Balance: $300
Total Weight:    3.00kg
================================
Thank you for shopping with us! 😊
```

## 🏛️ Architecture

### Design Patterns Used

1. **Inheritance**: Product hierarchy with specialized product types
2. **Interface Implementation**: Shippable interface for shipping logic
3. **Service Layer**: Separate services for checkout and shipping
4. **Encapsulation**: Private fields with public methods

### Class Relationships

```
Product (Abstract)
├── ExpirableProduct (implements Shippable)
├── ShippableProduct (implements Shippable)
└── NonShippableProduct

Customer
├── name: String
├── balance: int
└── methods for balance management

Cart
├── items: List<CartItem>
└── methods for cart management

CartItem
├── product: Product
├── quantity: int
└── weight: double (calculated)
```

## 🛠️ Key Features Explained

### Weight Calculation
- Automatic weight calculation based on product type
- Shippable products contribute to total package weight
- Non-shippable products have zero weight

### Error Handling
- Insufficient funds validation
- Stock availability checking
- Expired product detection
- Input validation for quantities

### Shipping Logic
- $30 flat shipping fee for physical items
- Weight-based packaging information
- Separate handling for digital vs physical products

## 🧪 Testing Scenarios

The system handles various scenarios:

1. **Successful Purchase**: Customer has sufficient funds
2. **Insufficient Funds**: Customer needs more money
3. **Out of Stock**: Product quantity exceeds available stock
4. **Expired Products**: Cannot purchase expired items
5. **Mixed Cart**: Combination of shippable and non-shippable items

## 🤝 Contributing

Feel free to contribute to this project by:

1. Adding new product types
2. Implementing discount systems
3. Adding payment methods
4. Improving the user interface
5. Adding more comprehensive error handling

## 📝 License

This project is created for educational purposes. Feel free to use and modify as needed.

---

**Made with ❤️ by Mohamed Ossama**

*Happy Shopping! 🛒*
