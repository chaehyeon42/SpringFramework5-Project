package mylab.book.control;

import mylab.book.entity.*;
import java.util.*;
import java.text.DecimalFormat;

//통계 분석  클래스 생성

public class StatisticsAnalyzer {
    //타입별 평균 가격 계산
    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Integer> sumMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();

        for (Publication p : publications) {
            String type = getPublicationType(p);
            sumMap.put(type, sumMap.getOrDefault(type, 0) + p.getPrice());
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> avgMap = new HashMap<>();
        for (String type : sumMap.keySet()) {
            avgMap.put(type, (double) sumMap.get(type) / countMap.get(type));
        }
        return avgMap;
    }

    //출판물 유형 분포 계산
    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> countMap = new HashMap<>();
        for (Publication p : publications) {
            String type = getPublicationType(p);
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> distMap = new HashMap<>();
        for (String type : countMap.keySet()) {
            distMap.put(type, ((double) countMap.get(type) / publications.length) * 100);
        }
        return distMap;
    }

    //특정 연도 출판 비율
    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int count = 0;
        for (Publication p : publications) {
            if (p.getPublishDate().startsWith(year)) count++;
        }
        return ((double) count / publications.length) * 100;
    }

    // 타입 확인 헬퍼 메서드
    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) return "소설";
        if (pub instanceof Magazine) return "잡지";
        if (pub instanceof ReferenceBook) return "참고서";
        return "기타";
    }

    // 통계 정보 출력
    public void printStatistics(Publication[] publications) {
        DecimalFormat df = new DecimalFormat("#,###.##");
        System.out.println("=== 출판물 통계 분석 ===");
        
        System.out.println("1. 타입별 평균 가격:");
        Map<String, Double> avgPrices = calculateAveragePriceByType(publications);
        avgPrices.forEach((k, v) -> System.out.println(" - " + k + ": " + df.format(v) + "원"));

        System.out.println("\n2. 출판물 유형 분포:");
        Map<String, Double> dist = calculatePublicationDistribution(publications);
        dist.forEach((k, v) -> System.out.println(" - " + k + ": " + df.format(v) + "%"));

        double ratio2007 = calculatePublicationRatioByYear(publications, "2007");
        System.out.println("\n3. 2007년에 출판된 출판물 비율: " + df.format(ratio2007) + "%");
    }
}