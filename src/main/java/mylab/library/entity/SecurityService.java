package mylab.library.entity;

import org.springframework.stereotype.Service;

@Service // 스프링이 서비스 빈으로 인식하게 함
public class SecurityService {
    
    public boolean authenticate() {
        System.out.println("SecurityService: 사용자 인증을 수행합니다.");
        return true; 
    }
}