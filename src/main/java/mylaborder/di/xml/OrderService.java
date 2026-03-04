package mylaborder.di.xml;

public class OrderService {
	private ShoppingCart shoppingCart;

    // Setter 주입용
    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }
}
