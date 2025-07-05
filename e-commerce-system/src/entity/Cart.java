package entity;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> items= new ArrayList<>();

    public void add(Item item)
    {
        if (item.getQuantity() <= 0) {
            throw new IllegalArgumentException("Invalid quantity");
        }
        items.add(item);
    }

    public List<Item> getItems()
        {return items;}

    public boolean isEmpty()
        {return items.isEmpty();}

}


