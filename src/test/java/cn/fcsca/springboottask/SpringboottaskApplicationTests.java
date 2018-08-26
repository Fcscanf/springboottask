package cn.fcsca.springboottask;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringboottaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    public void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("通知-今晚开会");   //邮件主题
        message.setText("今晚7:30开会！");     //邮件内容
        message.setTo("fcscanf@126.com");    //收件人
        message.setFrom("309219094@qq.com"); //发件人
        mailSender.send(message);
    }

    @Test
    public void emailFile() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setSubject("通知-今晚开会");
        mimeMessageHelper.setText("<b style='color:red'>今晚7:30开会！</b>",true);
        mimeMessageHelper.addAttachment("1.jpg",new File("D:\\Photos\\1.png"));
        mimeMessageHelper.setTo("fcscanf@126.com");
        mimeMessageHelper.setFrom("309219094@qq.com");
        mailSender.send(mimeMessage);
    }
}
