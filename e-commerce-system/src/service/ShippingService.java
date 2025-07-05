package service;

import entity.Shippable;

import java.util.List;

public class ShippingService  {
    public static void addShip(List<Shippable> toShip, List<Integer> shipQuantities) {

        double totalWeight = 0.0;


        System.out.println("** Shipment notice **");

        for (int shipment = 0; shipment < toShip.size(); shipment++) {
            Shippable product = toShip.get(shipment);
            int quantity = shipQuantities.get(shipment);

            double weight = product.getWeight() * quantity;
            totalWeight += weight;
            System.out.printf("%dx %s %.0fg\n", quantity, product.getName(), weight);
        }

        System.out.println("Total package weight " + (totalWeight >= 1000 ? (totalWeight / 1000) + " kg" : totalWeight + " g"));

    }
}
