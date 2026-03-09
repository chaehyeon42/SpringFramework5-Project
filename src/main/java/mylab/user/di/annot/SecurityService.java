package mylab.user.di.annot;

import org.springframework.stereotype.Service;

//서비스 계층 - 인증 클래스 작성

@Service // @Service로 빈 자동 등록
public class SecurityService {
    
    public boolean authenticate(String userId, String password) {
        System.out.println("사용자 인증 확인: " + userId);
        return true; 
    }

    public boolean authorize(String userId, String resource) {
        System.out.println(userId + "의 리소스 접근 권한 확인: " + resource);
        return true;
    }
}