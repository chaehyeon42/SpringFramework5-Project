package mylab.notification.di.annot.config;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import mylab.notification.di.annot.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {NotificationConfig.class})
public class NotificationConfigTest {

    @Autowired
    private NotificationManager notificationManager;

    @Test
    public void testNotification() {
        assertNotNull(notificationManager);
        
        // 이메일 검증
        EmailNotificationService email = (EmailNotificationService) notificationManager.getEmailService();
        assertEquals("smtp.gmail.com", email.getSmtpServer());
        assertEquals(587, email.getPort());

        // SMS 검증
        SmsNotificationService sms = (SmsNotificationService) notificationManager.getSmsService();
        assertEquals("SKT", sms.getProvider());

        // 메서드 호출
        notificationManager.sendNotificationByEmail("JavaConfig Test Email");
        notificationManager.sendNotificationBySms("JavaConfig Test SMS");
    }
}