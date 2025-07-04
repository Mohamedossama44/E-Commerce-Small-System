import java.util.List;

public class ShippingService {
    public static void createShipment (List<Shippable> items) {
        double totalWeight = 0;
        for (Shippable item : items) {
            double weightKg = item.getWeight();
            System.out.printf("%s        %.0fg\n", item.getName(), weightKg * 1000);
            totalWeight += weightKg;
        }
        System.out.printf("Total package weight %.1fkg\n\n", totalWeight);
    }
}