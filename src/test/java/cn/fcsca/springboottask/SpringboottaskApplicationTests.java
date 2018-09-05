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
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringboottaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Resource
    TemplateEngine templateEngine;

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
        String imgpath = "D:\\Photos\\workcorner\\png\\fc\\234.png";
        String rscId = "fc001";
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setSubject("通知-今晚开会");
        mimeMessageHelper.setText("<b style='color:red'>今晚7:30开会！</b><br/>\n" +
                "<img src=\'cid:" + rscId + "\'/>",
                true);
        //邮件正文内嵌图片显示
        mimeMessageHelper.addInline(rscId, new File(imgpath));
        mimeMessageHelper.addAttachment("1.jpg",new File("D:\\Photos\\1.png"));
        mimeMessageHelper.setTo("fcscanf@126.com");
        mimeMessageHelper.setFrom("309219094@qq.com");
        mailSender.send(mimeMessage);
    }

    @Test
    public void useTemplateMail() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setSubject("The Official From Fcscanf");
        mimeMessageHelper.setTo("fcscanf@126.com");
        mimeMessageHelper.setFrom("309219094@qq.com");

        Context context = new Context();
        context.setVariable("Id","123");
        String emailContent = templateEngine.process("emailTemplate",context);
        mimeMessageHelper.setText(emailContent,true);
        mailSender.send(mimeMessage);
    }

    @Test
    public void emailUsuallyFile() throws MessagingException {
        //标志
        String imgpath = "D:\\Photos\\workcorner\\png\\fc\\234.png";
        String rscId = "fc001";
        //主题
        String subject = "The Official From Fcscanf";
        //正文
        String text = "<b style='color:red'>软件161材料</b><br/>\n" +
                "<img src=\'cid:" + rscId + "\'/>";

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(text, true);
        //邮件正文内嵌图片显示
        mimeMessageHelper.addInline(rscId, new File(imgpath));

        //附件文件
        mimeMessageHelper.addAttachment("信息学院考研统计.xlsx",new File("D:\\fcofficework\\Acf-My work\\临时工作文件夹\\班级材料\\信息学院考研统计.xlsx"));

        mimeMessageHelper.setTo("fcscanf@126.com");
        mimeMessageHelper.setFrom("309219094@qq.com");
        mailSender.send(mimeMessage);
    }
}
