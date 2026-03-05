package mylaborder.di.xml;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * DI(Dependency Injection)이 올바르게 작동하는지 확인하는 SpringTest
 */
// XML 파일이 src/main/resources 폴더 바로 아래에 있으므로 classpath: 뒤에 파일명만 작성
public class OrderSpringTest {

    // ShoppingCart 클래스와 OrderService 클래스를 Injection 
    @Autowired
    private ShoppingCart shoppingCart;

    @Autowired
    private OrderService orderService;

    /**
     * ShoppingCart 스프링 Bean을 테스트 하는 메서드
     */
    @Test
    public void testShoppingCart() {
        // 1. shoppingCart 객체가 Null 이 아닌지 검증
        assertNotNull(shoppingCart, "ShoppingCart 빈이 주입되지 않았습니다.");

        // 2. shoppingCart.getProducts().size() 를 검증 (설정값: 2)
        assertEquals(2, shoppingCart.getProducts().size(), "상품의 개수가 일치하지 않습니다.");

        // 3. shoppingCart.getProducts().get(0).getName() 이 "노트북" 인지 검증
        assertEquals("노트북", shoppingCart.getProducts().get(0).getName());

        // 4. shoppingCart.getProducts().get(1).getName() 이 "스마트폰" 인지 검증
        assertEquals("스마트폰", shoppingCart.getProducts().get(1).getName());
    }

    /**
     * OrderService 스프링 Bean을 테스트 하는 메서드
     */
    @Test
    public void testOrderService() {
        // OrderService 빈이 주입되었는지 검증.
        assertNotNull(orderService, "OrderService 빈이 주입되지 않았습니다.");
        
        // OrderService 내부에 ShoppingCart가 올바르게 주입되었는지 확인
        assertNotNull(orderService.getShoppingCart(), "OrderService 내에 ShoppingCart가 주입되지 않았습니다.");
    }
}