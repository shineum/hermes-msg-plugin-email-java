package hermesmsg.entity;

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
        this.from = emailMessageBuilder.from;
        this.to = emailMessageBuilder.to;
        this.cc = emailMessageBuilder.cc;
        this.bcc = emailMessageBuilder.bcc;
        this.subject = emailMessageBuilder.subject;
        this.body = emailMessageBuilder.body;
        this.isHtml = emailMessageBuilder.isHtml;
        this.attachments = emailMessageBuilder.attachments;
    }


//    public String getX() {
//        return null;
//    }

//    public EmailMessage(String to, String subject, String body) {
//        this.to = to;
//        this.subject = subject;
//        this.body = body;
//        this.isHtml = false;
//    }
//
//    public EmailMessage(String to, String subject, String body, boolean isHtml) {
//        this.to = to;
//        this.subject = subject;
//        this.body = body;
//        this.isHtml = isHtml;
//    }
//
//    public EmailMessage(String from, String to, String cc, String bcc, String subject, String body, boolean isHtml) {
//        this.from = from;
//        this.to = to;
//        this.cc = cc;
//        this.bcc = bcc;
//        this.subject = subject;
//        this.body = body;
//        this.isHtml = isHtml;
//    }
//
//    public EmailMessage addFileAttachment(File attachment) {
//        if (this.attachments == null) {
//            this.attachments = new ArrayList<>();
//        }
////        Optional.ofNullable(MessageConverter.fileToByteArrayAttachment(attachment)).map(this.attachments::add);
//        return this;
//    }
//
//    public EmailMessage addByteArrayAttachment(ByteArrayAttachment attachment) {
//        if (this.attachments == null) {
//            this.attachments = new ArrayList<>();
//        }
//        this.attachments.add(attachment);
//        return this;
//    }
//
//    public EmailMessage setFileAttachments(List<File> attachments) {
////        this.attachments = MessageConverter.fileListToByteArrayAttachmentList((attachments));
//        return this;
//    }
//
//    public EmailMessage setByteArrayAttachments(List<ByteArrayAttachment> attachments) {
//        this.attachments = attachments;
//        return this;
//    }
//
//    public String getFrom() {
//        return from;
//    }
//
//    public void setFrom(String from) {
//        this.from = from;
//    }
//
//    public String getTo() {
//        return to;
//    }
//
//    public void setTo(String to) {
//        this.to = to;
//    }
//
//    public String getCc() {
//        return cc;
//    }
//
//    public void setCc(String cc) {
//        this.cc = cc;
//    }
//
//    public String getBcc() {
//        return bcc;
//    }
//
//    public void setBcc(String bcc) {
//        this.bcc = bcc;
//    }
//
//    public String getSubject() {
//        return subject;
//    }
//
//    public void setSubject(String subject) {
//        this.subject = subject;
//    }
//
//    public String getBody() {
//        return body;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
//    }
//
//    public boolean isHtml() {
//        return isHtml;
//    }
//
//    public void setHtml(boolean html) {
//        isHtml = html;
//    }
//
//    public List<ByteArrayAttachment> getAttachments() {
//        return attachments;
//    }
//
//    private String concatenateRecipient(String prev, String newRecipient) {
//        if (prev == null) {
//            return newRecipient;
//        } else {
//            return prev + "," + newRecipient;
//        }
//    }
//
//    public void addRecipientTo(String to) {
//        this.to = concatenateRecipient(this.to, to);
//    }
//
//    public void addRecipientCc(String cc) {
//        this.cc = concatenateRecipient(this.cc, cc);
//    }
//
//    public void addRecipientBcc(String bcc) {
//        this.bcc = concatenateRecipient(this.bcc, bcc);
//    }
}
