package mylab.book.control;

import mylab.book.entity.*;
import java.util.*;

//장바구니 관리 클래스 생성

public class ShoppingCart {
    // Publication 객체들을 담을 리스트 (다형성 활용)
    private List<Publication> items = new ArrayList<>(); 

    //아이템 추가 메서드
    public void addItem(Publication item) {
        items.add(item);
        System.out.println(item.getTitle() + "(이)가 장바구니에 추가되었습니다.");
    }

    //아이템 삭제 메서드 (제목으로 검색)
    public boolean removeItem(String title) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getTitle().equals(title)) {
                Publication removed = items.remove(i);
                System.out.println(removed.getTitle() + "(이)가 장바구니에서 제거되었습니다.");
                return true;
            }
        }
        System.out.println("해당 도서를 찾을 수 없습니다.");
        return false;
    }

    //총 가격 계산
    public int calculateTotalPrice() {
        int total = 0;
        for (Publication p : items) {
            total += p.getPrice();
        }
        return total;
    }

    //할인 적용 가격 계산 (instanceof 활용)
    public int calculateDiscountedPrice() {
        double total = 0;
        for (Publication p : items) {
            if (p instanceof Magazine) {
                total += p.getPrice() * 0.9;  // 잡지 10% 할인
            } else if (p instanceof Novel) {
                total += p.getPrice() * 0.85; // 소설 15% 할인
            } else if (p instanceof ReferenceBook) {
                total += p.getPrice() * 0.8;  // 참고서 20% 할인
            } else {
                total += p.getPrice();
            }
        }
        return (int) total;
    }

    //장바구니 내용 출력
    public void displayCart() {
        System.out.println("==== 장바구니 내용 ====");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).getTitle() + " - " + items.get(i).getPrice() + "원");
        }
        System.out.println("총 가격: " + calculateTotalPrice() + "원");
        System.out.println("할인 적용 가격: " + calculateDiscountedPrice() + "원");
    }

    //장바구니 통계 출력 (실습 요구사항)
    public void printStatistics() {
        int magCount = 0;
        int novelCount = 0;
        int refCount = 0;

        for (Publication p : items) {
            if (p instanceof Magazine) magCount++;
            else if (p instanceof Novel) novelCount++;
            else if (p instanceof ReferenceBook) refCount++;
        }

        System.out.println("==== 장바구니 통계 ====");
        System.out.println("잡지: " + magCount + "권");
        System.out.println("소설: " + novelCount + "권");
        System.out.println("참고서: " + refCount + "권");
        System.out.println("총 출판물: " + items.size() + "권");
    }

    //메인 메서드 (직접 실행용)
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Sample Run 데이터 추가
        cart.addItem(new Magazine("마이크로소프트", "2007-10-01", 328, 9900, "매월"));
        cart.addItem(new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월"));
        cart.addItem(new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설"));
        cart.addItem(new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설"));
        cart.addItem(new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학"));

        System.out.println(); // 가독성을 위한 줄바꿈
        cart.displayCart();     // 장바구니 목록 출력
        cart.printStatistics(); // 통계 출력
        
        System.out.println();
        cart.removeItem("빠삐용"); // 삭제 테스트
        cart.displayCart();      // 삭제 후 다시 출력
    }
}