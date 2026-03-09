package mylab.user.di.annot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//서비스계층 - 비즈니스 로직 클래스 작성

@Service // @Service로 빈 자동 등록
public class UserService {

    // 필드 주입 방식의 @Autowired
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityService securityService;

    // Getter (테스트 코드에서 검증을 위해 필요)
    public UserRepository getUserRepository() {
        return userRepository;
    }

    public SecurityService getSecurityService() {
        return securityService;
    }

    public boolean registerUser(String userId, String name, String password) {
        // 1. SecurityService로 인증
        if (securityService.authenticate(userId, password)) {
            // 2. UserRepository에 저장
            return userRepository.saveUser(userId, name);
        }
        return false;
    }
}