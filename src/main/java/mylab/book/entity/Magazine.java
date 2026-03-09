package mylab.book.entity;

//잡지 class 생성
public class Magazine extends Publication {
    private String publishPeriod; // 발행주기 (예: "매월")

    public Magazine(String title, String publishDate, int page, int price, String publishPeriod) {
        super(title, publishDate, page, price); // 부모 생성자 호출
        this.publishPeriod = publishPeriod;
    }

    @Override
    public String toString() {
        // Sample Run 형식에 맞춘 정보 출력
        return String.format("%s [잡지] 발행주기:%s, %d쪽, %d원, 출판일:%s", 
                super.toString(), publishPeriod, getPage(), getPrice(), getPublishDate());
    }
}