package mylab.library.control;

import mylab.library.entity.Book;
import mylab.library.entity.Library;
import org.springframework.context.support.GenericXmlApplicationContext;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("mylab-user-di.xml");
        Library library = ctx.getBean("userService", Library.class);

        // 1. 도서 추가 및 추가 메시지 출력
        addSampleBooks(library);

        // 2. 도서관 상태 출력
        System.out.println("===== 중앙 도서관 =====");
        System.out.println("전체 도서 수: " + library.getAllBooks().size());
        System.out.println("대출 가능 도서 수: " + library.getAvailableBooksCount());
        System.out.println("대출 중인 도서 수: " + (library.getAllBooks().size() - library.getAvailableBooksCount()));

        // 3. 도서 검색 테스트 (제목으로 검색)
        System.out.println("\n===== 도서 검색 테스트 =====");
        System.out.println("제목으로 검색 결과:");
        Book searchBook = library.findBookByIsbn("978-89-01-14077-4"); // 자바의 정석
        if (searchBook != null) System.out.println(searchBook);

        // 4. 도서 대출 테스트
        System.out.println("\n===== 도서 대출 테스트 =====");
        if (searchBook != null && searchBook.checkOut()) {
            System.out.println("도서 대출 성공!");
            System.out.println("대출된 도서 정보:");
            System.out.println(searchBook);
        }

        // 대출 후 상태 출력
        printLibraryStatus(library);

        // 5. 도서 반납 테스트
        System.out.println("\n===== 도서 반납 테스트 =====");
        searchBook.returnBook();
        System.out.println("도서 반납 성공!");
        System.out.println("반납된 도서 정보:");
        System.out.println(searchBook);

        // 6. 대출 가능한 도서 목록 출력
        System.out.println("\n===== 대출 가능한 도서 목록 =====");
        for (Book b : library.getAllBooks()) {
            if (b.isAvailable()) {
                System.out.println(b);
                System.out.println("----------------------------------------------------------------------------------");
            }
        }

        ctx.close();
    }

    private static void printLibraryStatus(Library lib) {
        System.out.println("\n도서관 현재 상태:");
        System.out.println("전체 도서 수: " + lib.getAllBooks().size());
        System.out.println("대출 가능 도서 수: " + lib.getAvailableBooksCount());
        System.out.println("대출 중인 도서 수: " + (lib.getAllBooks().size() - lib.getAvailableBooksCount()));
    }

    private static void addSampleBooks(Library library) {
        library.addBook(new Book("자바 프로그래밍", "김자바", "978-89-01-12345-6", 2022));
        library.addBook(new Book("객체지향의 사실과 오해", "조영호", "978-89-01-67890-1", 2015));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new Book("자바의 정석", "남궁성", "978-89-01-14077-4", 2019));
}


}