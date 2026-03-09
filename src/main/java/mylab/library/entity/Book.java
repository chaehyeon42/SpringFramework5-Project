package mylab.library.entity;

public class Book {
	private String title;
    private String author;
    private String isbn;
    private int publishYear;
    private boolean isAvailable;

    // 기본 생성자 (초기 상태: 대출 가능)
    public Book() {
        this.isAvailable = true;
    }

    // 필드 초기화 생성자
    public Book(String title, String author, String isbn, int publishYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishYear = publishYear;
        this.isAvailable = true;
    }

    // Getter와 Setter
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isAvailable() { return isAvailable; }

    // 대출 처리 메서드
    public boolean checkOut() {
        if (this.isAvailable) {
            this.isAvailable = false;
            return true;
        }
        return false;
    }

    // 반납 처리 메서드
    public void returnBook() {
        this.isAvailable = true;
    }

    @Override
    public String toString() {
        return String.format("제목: %s, 저자: %s, ISBN: %s, 출판: %d, 상태: %s",
                title, author, isbn, publishYear, isAvailable ? "가능" : "대출 중");
    }
}
