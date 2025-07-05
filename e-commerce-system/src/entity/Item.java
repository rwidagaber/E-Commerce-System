package entity;


import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Item {
    private Product product;
    private int quantity;
}
