package entity;


import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter @Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor

public class ShippableProduct extends Product implements Shippable {

    private double weight;




    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
