package myspring.di.xml;

//해당 메세지를 console에 뿌려줌
public class ConsolePrinter implements Printer {
	public void print(String message) {
		System.out.println(message);
	}
}
