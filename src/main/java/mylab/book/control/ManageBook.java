package mylab.book.control;

import mylab.book.entity.*;

//메인 실행 클래스 생성

public class ManageBook {
    public static void main(String[] args) {
        //출판물 배열 생성 및 초기화
        Publication[] publications = {
            new Magazine("마이크로소프트", "2007-10-01", 328, 9900, "매월"),
            new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월"),
            new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설"),
            new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설"),
            new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학"),
            new Novel("소년이온다", "2014-05-01", 216, 15000, "한강", "장편소설"),
            new Novel("작별하지않는다", "2021-09-09", 332, 15120, "한강", "장편소설")
        };

        // 출판 정보 출력
        System.out.println("=== 도서 정보 출력 ===");
        for (int i = 0; i < publications.length; i++) {
            System.out.println((i + 1) + ". " + publications[i].toString());
        }

        //특정 출판물 가격 변경 (인덱스 6: 작별하지않는다)
        System.out.println("\n=== 가격 변경 ===");
        int oldPrice = publications[6].getPrice();
        modifyPrice(publications[6]); // 할인 적용
        System.out.println(publications[6].getTitle() + " 변경 전 가격: " + oldPrice + "원");
        System.out.println(publications[6].getTitle() + " 변경 후 가격: " + publications[6].getPrice() + "원");
        System.out.println("차액: " + (oldPrice - publications[6].getPrice()) + "원");
        System.out.println();

        //통계 분석 실행
        StatisticsAnalyzer analyzer = new StatisticsAnalyzer();
        analyzer.printStatistics(publications);
    }

    //타입별 차별적 할인율 적용 메서드
    public static void modifyPrice(Publication publication) {
        int currentPrice = publication.getPrice();
        if (publication instanceof Magazine) {
            publication.setPrice((int)(currentPrice * 0.6)); // 40% 할인
        } else if (publication instanceof Novel) {
            publication.setPrice((int)(currentPrice * 0.8)); // 20% 할인
        } else if (publication instanceof ReferenceBook) {
            publication.setPrice((int)(currentPrice * 0.9)); // 10% 할인
        }
    }
}