package entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Product {
    private String name;
    private double price;
    private int quantity;

    public void decreaseQuantity(int amount) {
       quantity-=amount;
    }

}
