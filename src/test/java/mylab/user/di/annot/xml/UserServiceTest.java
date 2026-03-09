package mylab.user.di.annot.xml; // 패키지명 확인

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mylab.user.di.annot.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
// 변경된 XML 파일명을 경로에 반영합니다.
@ContextConfiguration(locations = "classpath:mylab-usercontext-di.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService; // 자동 주입

    @Test
    public void testUserService() {
        // 과제 조건에 따른 검증 로직
        assertNotNull("UserService가 null이 아니어야 합니다.", userService);
        System.out.println("c. UserService 주입 확인: " + (userService != null));
        
        assertNotNull("UserRepository가 Not Null 인지 검증", userService.getUserRepository());
        System.out.println("a. UserRepository 존재 확인: " + (userService.getUserRepository() != null));
        
        String dbType = userService.getUserRepository().getDbType();
        assertEquals("dbType이 MySQL인지 검증", "MySQL", userService.getUserRepository().getDbType());
        System.out.println("b. DB Type 비교 (Expected: MySQL, Actual: " + dbType + ")");
        
        assertNotNull("SecurityService가 Not Null 인지 검증", userService.getSecurityService());
        System.out.println("c. SecurityService 존재 확인: " + (userService.getSecurityService() != null));
        
        boolean result = userService.registerUser("lukie5", "홍길동", "pass123");
        assertTrue("registerUser() 결과가 True인지 검증", result);
        System.out.println("d. registerUser() 실행 결과: " + result);
        
        System.out.println("======= 모든 검증 항목 성공 =======");
    }
}