package mylab.book.entity;

//참고서 class 생성

public class ReferenceBook extends Publication {
    private String field; // 전문 분야

    public ReferenceBook(String title, String publishDate, int page, int price, String field) {
        super(title, publishDate, page, price);
        this.field = field;
    }

    @Override
    public String toString() {
        return String.format("%s [참고서] 분야:%s, %d쪽, %d원, 출판일:%s", 
                super.toString(), field, getPage(), getPrice(), getPublishDate());
    }
}