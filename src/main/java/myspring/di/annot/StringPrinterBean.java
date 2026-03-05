package myspring.di.annot;

import org.springframework.stereotype.Component;

//@Component(Class 이름") 
@Component("StringPrinter")
public class StringPrinterBean implements IPrinter {
	private StringBuffer buffer = new StringBuffer();
	
	public StringPrinterBean() {
		System.out.println(this.getClass().getName() + " 기본생성자 호출됨!");
	}

	public void print(String message) {
		this.buffer.append(message);
	}

	public String toString() {
		return this.buffer.toString();
	}
}