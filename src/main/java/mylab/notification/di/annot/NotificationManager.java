package mylab.notification.di.annot;

//알림 관리자 클래스

public class NotificationManager {
    private NotificationService emailService;
    private NotificationService smsService;

    // 생성자를 통해 서비스 객체들을 주입
    public NotificationManager(NotificationService emailService, NotificationService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }

    public NotificationService getEmailService() { return emailService; }
    public NotificationService getSmsService() { return smsService; }

    public void sendNotificationByEmail(String message) {
        emailService.sendNotification(message);
    }

    public void sendNotificationBySms(String message) {
        smsService.sendNotification(message);
    }
}