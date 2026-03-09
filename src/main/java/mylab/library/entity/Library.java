package mylab.library.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class Library {
    private List<Book> books = new ArrayList<>();

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityService securityService;

    // --- 기존 기능 유지 ---
    public UserRepository getUserRepository() { return userRepository; }
    public SecurityService getSecurityService() { return securityService; }

    public boolean registerUser() {
        if(securityService.authenticate()) {
            userRepository.save();
            return true;
        }
        return false;
    }

    public void addBook(Book book) { books.add(book); }
    public List<Book> getAllBooks() { return books; }

    // --- 에러(빨간 줄)를 없애기 위해 반드시 추가해야 하는 메서드들 ---

    // 1. 대출 가능한 도서 수 계산 (LibraryManagementSystem 60라인 에러 해결)
    public int getAvailableBooksCount() {
        int count = 0;
        for (Book book : books) {
            if (book.isAvailable()) {
                count++;
            }
        }
        return count;
    }

    // 2. ISBN으로 도서 검색 (LibraryManagementSystem 24라인 에러 해결)
    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }
}