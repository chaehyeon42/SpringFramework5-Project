package mylab.user.di.annot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

//데이터 접근 계층 클래스 작성

@Repository // @Repository로 빈 자동 등록
public class UserRepository {
    
    // @Value를 사용하여 DB 설정 값 주입
    @Value("MySQL")
    private String dbType;

    public String getDbType() {
        return dbType;
    }

    public boolean saveUser(String userId, String name) {
        System.out.println(dbType + " DB에 사용자 저장: " + name + "(" + userId + ")");
        return true;
    }
}