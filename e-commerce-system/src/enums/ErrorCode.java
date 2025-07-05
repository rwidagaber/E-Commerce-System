// enums/ErrorCode.java
package enums;

import lombok.Getter;

@Getter
public enum ErrorCode {
    CART_IS_EMPTY("No product in cart"),
    INSUFFICIENT_QUANTITY("Not enough quantity in stock"),
    PRODUCT_EXPIRED("Product is expired"),
    INSUFFICIENT_BALANCE("Don't have enough balance"),
    PRODUCT_IS_OUT_OF_STOCK("Product is out of stock"),
    PRODUCT_NOT_FOUND("Product not found"),
    INVALID_QUANTITY("Invalid quantity"),;

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }
}
