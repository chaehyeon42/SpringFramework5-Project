package mylab.notification.di.annot;

//알림 서비스(Email) 구현 클래스

public class EmailNotificationService implements NotificationService {
    private String smtpServer;
    private int port;

    // 생성자를 통해 SMTP 서버 주소와 포트 번호를 주입 받습니다.
    public EmailNotificationService(String smtpServer, int port) {
        this.smtpServer = smtpServer;
        this.port = port;
    }

    public String getSmtpServer() { return smtpServer; }
    public int getPort() { return port; }

    @Override
    public void sendNotification(String message) {
        // 메시지와 함께 SMTP 서버 정보를 출력합니다.
        System.out.println("[Email] 서버(" + smtpServer + ":" + port + ") 발송: " + message);
    }
}