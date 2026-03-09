package mylablibrary.xml;

import static org.junit.Assert.*;
import mylab.library.entity.Library;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceTest {

    @Test
    public void testDependencyInjection() {
    	// UserServiceTest.java 내부
    	ApplicationContext ctx = new GenericXmlApplicationContext("mylab-user-di.xml");
        Library userService = ctx.getBean("userService", Library.class);

        // 1. UserService 주입 확인
        assertNotNull(userService);
        
        // 2. UserRepository Not Null 검증
        assertNotNull(userService.getUserRepository());
        
        // 3. getDbType() 값이 MySQL 인지 확인
        assertEquals("MySQL", userService.getUserRepository().getDbType());
        
        // 4. SecurityService Not Null 검증
        assertNotNull(userService.getSecurityService());
        
        // 5. registerUser() 성공 여부 검증
        assertTrue(userService.registerUser());
    }
}