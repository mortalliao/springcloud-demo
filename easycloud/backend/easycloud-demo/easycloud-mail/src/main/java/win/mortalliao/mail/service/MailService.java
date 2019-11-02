package win.mortalliao.mail.service;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author liaoyujian
 */
public interface MailService {

    /**
     * 发送简单邮件
     *
     * @param sendTo  收件人地址
     * @param title   邮件标题
     * @param content 邮件内容
     */
    public void sendSimpleMail(String sendTo, String title, String content);

    /**
     * 发送简单邮件
     *
     * @param sendTo      收件人地址
     * @param title       邮件标题
     * @param content     邮件内容
     * @param attachments 附件列表
     */
    public void sendAttachmentsMail(String sendTo, String title, String content, List<File> attachments);

    /**
     * 发送模板邮件
     *
     * @param sendTo 收件人地址
     * @param title 邮件标题
     * @param templateName 模板名称
     * @param content 邮件内容
     * @param attachments 附件列表
     */
    public void sendTemplateMail(String sendTo, String title, String templateName, Map<String, Object> content, List<File> attachments);

}
