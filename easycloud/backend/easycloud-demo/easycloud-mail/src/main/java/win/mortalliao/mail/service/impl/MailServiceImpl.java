package win.mortalliao.mail.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;
import win.mortalliao.mail.config.EmailConfig;
import win.mortalliao.mail.service.MailService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author liaoyujian
 */
@Slf4j
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private EmailConfig emailConfig;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;

    @Async("mail") //@Async所修饰的函数不要定义为static类型，这样异步调用不会生效
    @Override
    public void sendSimpleMail(String sendTo, String title, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailConfig.getEmailFrom());
        message.setTo(sendTo);
        message.setSubject(title);
        message.setText(content);
        mailSender.send(message);
    }

    @Async("mail")
    @Override
    public void sendAttachmentsMail(String sendTo, String titel, String content, List<File> attachments) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(emailConfig.getEmailFrom());
            helper.setTo(sendTo);
            helper.setSubject(titel);
            helper.setText(content);

            for (File file : attachments) {
                helper.addAttachment(file.getName(), file);
            }
        } catch (MessagingException e) {
            log.warn("Email could not be sent to user '{}': {}", sendTo, e.getMessage());
            throw new RuntimeException(e);
        }
        mailSender.send(mimeMessage);
    }

    @Async("mail")
    @Override
    public void sendTemplateMail(String sendTo, String title, String templateName, Map<String, Object> content, List<File> attachments) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(emailConfig.getEmailFrom());
            helper.setTo(sendTo);
            helper.setSubject(title);

            Locale locale = Locale.forLanguageTag("zh-cn");
            Context context = new Context(locale);
            content.forEach(context::setVariable);
            String text =templateEngine.process(templateName, context);
            helper.setText(text, true);

            for (File file : attachments) {
                helper.addAttachment(file.getName(), file);
            }
        } catch (MessagingException e) {
            log.warn("Email could not be sent to user '{}': {}", sendTo, e.getMessage());
            throw new RuntimeException(e);
        }
        mailSender.send(mimeMessage);
    }

}
