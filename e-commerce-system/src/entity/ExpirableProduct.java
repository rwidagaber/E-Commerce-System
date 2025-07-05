package entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;


@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExpirableProduct extends Product implements Expirable {

    private LocalDate expiryDate;


    @Override
    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }
}
