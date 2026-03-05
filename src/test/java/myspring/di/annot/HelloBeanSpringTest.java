package myspring.di.annot;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
//@ContextConfiguration : 스프링빈 (Bean) 설정파일의위치를 지정할때사용되는 어노테이션
@ContextConfiguration(locations = "classpath:hello-annot.xml")
public class HelloBeanSpringTest {
	//변수선언
	//HelloBean 타입은 하나 밖에 없어서 Qualifier가 필요 없음.
	@Autowired
	HelloBean hello;	
	
	@Test
	void helloBeanSetter() {
		assertEquals("Hello 어노테이션", hello.sayHello());
	}
}
