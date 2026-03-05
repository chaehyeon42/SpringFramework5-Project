package mylaborder.di.xml;

public class OrderService {
	private ShoppingCart shoppingCart;

    // Setter 주입용
    public void setShopCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
