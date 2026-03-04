package mylaborder.di.xml;

import java.util.List;

public class ShoppingCart {
	private List<Product> products;
	
	// Setter 주입
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    public List<Product> getProducts() {
        return products;
    }
}
