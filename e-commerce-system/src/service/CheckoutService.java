package service;

import entity.*;
import enums.ErrorCode;
import exception.AppExceptionHandler;


import java.util.ArrayList;
import java.util.List;

public class CheckoutService {

    public void checkout(Customer customer, Cart cart) {

        double subtotal=0.0;
        double shippingFee=0.0;
        double paidAmount=0.0;


        List<Shippable> ship=new ArrayList<>();
        List<Integer> shipquantity=new ArrayList<>();

        if(cart.isEmpty())
            throw new AppExceptionHandler(ErrorCode.CART_IS_EMPTY.getMessage(), ErrorCode.CART_IS_EMPTY);



        for (Item item : cart.getItems()) {
            Product product = item.getProduct();

            if (item.getProduct().getQuantity() == 0)
                throw new AppExceptionHandler(ErrorCode.PRODUCT_IS_OUT_OF_STOCK.getMessage(), ErrorCode.PRODUCT_IS_OUT_OF_STOCK);

            if (product.getQuantity() < item.getQuantity()) {
                throw new AppExceptionHandler(ErrorCode.INSUFFICIENT_QUANTITY.getMessage(), ErrorCode.INSUFFICIENT_QUANTITY);
            }

            if (product instanceof Expirable && ((Expirable) product).isExpired()) {
                throw new AppExceptionHandler(ErrorCode.PRODUCT_EXPIRED.getMessage(), ErrorCode.PRODUCT_EXPIRED);
            }

            subtotal += product.getPrice() * item.getQuantity();
            if (product instanceof Shippable) {
                ship.add((Shippable) product);
                shipquantity.add(item.getQuantity());
                shippingFee = subtotal * 0.085;
            }

        }



        paidAmount = subtotal + shippingFee;
        if (paidAmount > customer.getBalance())
            throw new AppExceptionHandler(ErrorCode.INSUFFICIENT_BALANCE.getMessage(), ErrorCode.INSUFFICIENT_BALANCE);


        for (Item item : cart.getItems()) {
            item.getProduct().decreaseQuantity(item.getQuantity());
        }

        customer.reduceBalance(paidAmount);
        ShippingService.addShip(ship, shipquantity);
        System.out.println();
        System.out.println("** Checkout receipt **");
        for (Item item : cart.getItems()) {
            System.out.printf("%dx %s %.0f\n", item.getQuantity(), item.getProduct().getName(), item.getProduct().getPrice()*(item.getQuantity()));
        }

        System.out.println("----------------------");
        System.out.printf("Subtotal %.0f\n", subtotal);
        System.out.printf("Shipping %.0f\n", shippingFee);
        System.out.printf("Amount %.0f\n",paidAmount);

    }
}
