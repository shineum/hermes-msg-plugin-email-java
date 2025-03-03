package hermesmsg.plugin.email.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class EmailMessage {

    static Logger logger = LoggerFactory.getLogger(EmailMessage.class);

    public static final String HTML = "html";
    public static final String TEXT = "text";
    public static final String EM_KEY_FROM = "from";
    public static final String EM_KEY_TO = "to";
    public static final String EM_KEY_CC = "cc";
    public static final String EM_KEY_BCC = "bcc";
    public static final String EM_KEY_SUBJECT = "subject";
    public static final String EM_KEY_BODY = "body";
    public static final String EM_KEY_IS_HTML = "isHtml";
    public static final String EM_KEY_ATTACHMENTS = "attachments";

    String from;
    String to;
    String cc;
    String bcc;
    String subject;
    String body;
    boolean isHtml;
    List<ByteArrayAttachment> attachments;

    public EmailMessage(EmailMessageBuilder emailMessageBuilder) {
        this.from = emailMessageBuilder.getFrom();
        this.to = emailMessageBuilder.getTo();
        this.cc = emailMessageBuilder.getCc();
        this.bcc = emailMessageBuilder.getBcc();
        this.subject = emailMessageBuilder.getSubject();
        this.body = emailMessageBuilder.getBody();
        this.isHtml = emailMessageBuilder.isHtml();
        this.attachments = emailMessageBuilder.getAttachments();
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getCc() {
        return cc;
    }

    public String getBcc() {
        return bcc;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public boolean isHtml() {
        return isHtml;
    }

    public List<ByteArrayAttachment> getAttachments() {
        return attachments;
    }
}
