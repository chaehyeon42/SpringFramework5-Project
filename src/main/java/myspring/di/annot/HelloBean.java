package myspring.di.annot;

import java.util.List;

import javax.annotation.Resource;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//SetterInjection
@Component
public class HelloBean {
	//hello_bean.xml 의 Name이라는 변수에 어노테이션이라는 값이 지정됨
	@Value("어노테이션") 
	//변수
	String name;
	
	 //자동으로 엮어주는 역할, IPrinter라는 타입을 찾아서 Injection
	//@Autowired 
	//@Qualifier("StringPrinter") //지정자 역할 , StringPrinterBean의 StringPrinter라고 지정	
	//@Resource  IPrinter타입인 Bean을 찾음. 
	//@Resource = @Qualifier = @StringPrinter 다 같은 역할
	@Resource(name = "StringPrinter")  
	IPrinter printer;
	
	List<String> names;
	
	//기본 생성자
	public HelloBean() {
		System.out.println(this.getClass().getName() + " 기본생성자 호출됨!");
	}
	

	public HelloBean(String name, IPrinter printer) {
		System.out.println(this.getClass().getName() + " 오버로딩 생성자 호출됨!");
		this.name = name;
		this.printer = printer;
	}

	public List<String> getNames() {
		return this.names;
	}

	public void setNames(List<String> list) {
		this.names = list;
	}

	public String sayHello() {
		return "Hello " + name;
	}
	
	//print 메서드 호출 하고 sayHello받아서 반환
	public void print() {
		this.printer.print(sayHello());
	}

}