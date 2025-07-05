package entity;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Customer {
    private String name;
    double balance;

    public void reduceBalance(double totalPaid)
    {
        this.balance-=totalPaid;
    }
}
