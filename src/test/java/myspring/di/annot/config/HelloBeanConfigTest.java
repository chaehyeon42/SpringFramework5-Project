package myspring.di.annot.config;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import myspring.di.annot.HelloBean;

/*java class를 이용해 생성*/
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = HelloBeanConfig.class,loader = AnnotationConfigContextLoader.class)
public class HelloBeanConfigTest {
	/* HelloBean Injection 받기 */
	@Autowired 
	HelloBean hello;
	
	@Test
	void hello() {
		assertEquals("Hello 어노테이션", hello.sayHello());
	}

}
