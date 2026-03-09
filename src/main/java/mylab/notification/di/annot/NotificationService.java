package mylab.notification.di.annot;

//알림 서비스 인터페이스 클래스

public interface NotificationService {
    // 메시지를 전송하는 기능을 수행
    void sendNotification(String message);
}