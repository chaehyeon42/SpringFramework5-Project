package mylab.notification.di.annot;

//알림 서비스(Sms)구현 클래스

public class SmsNotificationService implements NotificationService {
    private String provider;

    // 생성자를 통해 SMS 제공업체 정보를 주입 받습니다.
    public SmsNotificationService(String provider) {
        this.provider = provider;
    }

    public String getProvider() { return provider; }

    @Override
    public void sendNotification(String message) {
        // 메시지와 함께 제공업체 정보를 출력합니다.
        System.out.println("[SMS] 제공업체(" + provider + ") 발송: " + message);
    }
}