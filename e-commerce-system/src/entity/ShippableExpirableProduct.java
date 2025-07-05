package entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;


@Getter @Setter
@SuperBuilder
@AllArgsConstructor @NoArgsConstructor

public class ShippableExpirableProduct extends Product implements Shippable, Expirable {

    private LocalDate expiryDate;
    private double weight;

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
