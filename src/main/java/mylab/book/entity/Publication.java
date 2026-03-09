package mylab.book.entity;

//부모클래스 생성

public class Publication {
    private String title;       // 출판물 제목
    private String publishDate; // 출판일 (yyyy-MM-dd)
    private int page;           // 페이지 수
    private int price;          // 가격

    public Publication() {} // 기본 생성자

    public Publication(String title, String publishDate, int page, int price) {
        this.title = title;
        this.publishDate = publishDate;
        this.page = page;
        this.price = price;
    }

    // Getter & Setter
    public String getTitle() { return title; }
    public String getPublishDate() { return publishDate; }
    public int getPage() { return page; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    @Override
    public String toString() {
        return title; // 요구사항: title만 반환
    }
}