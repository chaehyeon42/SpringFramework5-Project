package myspring.di.xml;

//static import
import static org.junit.jupiter.api.Assertions.* ; //Assertions라는 클래스에 포함한 모든 메서드를 import
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanJunitTest {
	ApplicationContext context;
	
	//아래 Test전 실행
	@BeforeEach
	void init() {
		//container 객체 생성
		context = new GenericXmlApplicationContext("classpath:hello-bean.xml");
	}
	
	@Test
	void helloBean() {
						//(Hello) : 형변환
		Hello helloById = (Hello)context.getBean("hello");
		Hello helloByType = context.getBean("hello", Hello.class);
		
		//해당 SpringBean(HelloSpringBean)이 싱글톤(객체)인지를 확인
		//방법1
		System.out.println(helloById == helloByType); // True가 나오면 레퍼런스가 같다는 의미로 한번만 생성해서 공유하는 방식이라는 뜻.(싱글톤 이라는 의미)
		
		//방법2. 주소를 비교해주는 Static 메서드
		assertSame(helloById, helloByType);
		
		//sayHello 메서드 호출 후 값 검증 
		//assertEquals : 값 비교후 검증해주는 메서드
		assertEquals("Hello 스프링", helloByType.sayHello());
	}
}