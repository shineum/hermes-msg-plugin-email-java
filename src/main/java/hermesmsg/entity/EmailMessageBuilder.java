package hermesmsg.entity;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.StringReader;
import java.util.*;

public class EmailMessageBuilder {

    static Logger logger = LoggerFactory.getLogger(EmailMessageBuilder.class);

    String from = null;
    String to = null;
    String cc = null;
    String bcc = null;
    String subject = null;
    String body = null;
    boolean isHtml = false;
    List<ByteArrayAttachment> attachments = new ArrayList<>();

    EmailMessageBuilder setFrom(String from) {
        this.from = from;
        return this;
    }

    EmailMessageBuilder setTO(String to) {
        this.to = to;
        return this;
    }

    EmailMessageBuilder setCC(String cc) {
        this.cc = cc;
        return this;
    }

    EmailMessageBuilder setBCC(String bcc) {
        this.bcc = bcc;
        return this;
    }

    EmailMessageBuilder setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    EmailMessageBuilder setBody(String body, boolean isHtml) {
        this.body = body;
        this.isHtml = isHtml;
        return this;
    }

    EmailMessageBuilder addAttachmentFile(File file, String contentType) {
        return addAttachment(new ByteArrayAttachment(file, contentType));
    }

    EmailMessageBuilder addAttachmentByteArray(String filename, byte[] filedata, String contentType) {
        return addAttachment(new ByteArrayAttachment(filename, filedata, contentType));
    }

    EmailMessageBuilder addAttachment(ByteArrayAttachment byteArrayAttachment) {
        attachments.add(byteArrayAttachment);
        return this;
    }

    EmailMessage build() {
        return new EmailMessage(this);
    }

    private String addRecipient(String prev, String newRecipient) {
        return Optional.ofNullable(prev)
                .map(recipient -> recipient + "," + newRecipient)
                .orElse(newRecipient);
    }

    EmailMessageBuilder addTO(String to) {
        this.to = addRecipient(this.to, to);
        return this;
    }

    EmailMessageBuilder addCC(String cc) {
        this.cc = addRecipient(this.cc, cc);
        return this;
    }

    EmailMessageBuilder addBCC(String bcc) {
        this.bcc = addRecipient(this.bcc, bcc);
        return this;
    }

    EmailMessageBuilder setWithMap(Map<String, String> dataMap) {
        this.from = dataMap.get(EmailMessage.EM_KEY_FROM);
        this.to = dataMap.get(EmailMessage.EM_KEY_TO);
        this.cc = dataMap.get(EmailMessage.EM_KEY_CC);
        this.bcc = dataMap.get(EmailMessage.EM_KEY_BCC);
        this.subject = dataMap.get(EmailMessage.EM_KEY_SUBJECT);
        this.body = dataMap.get(EmailMessage.EM_KEY_BODY);
        this.isHtml = "true".equals(dataMap.get(EmailMessage.EM_KEY_IS_HTML));
        return this;
    }

    EmailMessageBuilder setWithProperties(Properties props) {
        this.from = props.getProperty(EmailMessage.EM_KEY_FROM);
        this.to = props.getProperty(EmailMessage.EM_KEY_TO);
        this.cc = props.getProperty(EmailMessage.EM_KEY_CC);
        this.bcc = props.getProperty(EmailMessage.EM_KEY_BCC);
        this.subject = props.getProperty(EmailMessage.EM_KEY_SUBJECT);
        this.body = props.getProperty(EmailMessage.EM_KEY_BODY);
        this.isHtml = "true".equals(props.getProperty(EmailMessage.EM_KEY_IS_HTML));
        return this;
    }

    EmailMessageBuilder setWithPropertiesStr(String propStr) {
        try {
            Properties props = new Properties();
            props.load(new StringReader(propStr));
            setWithProperties(props);
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return this;
    }

    EmailMessageBuilder setWithJSONObject(JSONObject jo) {
        this.from = jo.has(EmailMessage.EM_KEY_FROM) ? jo.getString(EmailMessage.EM_KEY_FROM) : null;
        this.to = jo.has(EmailMessage.EM_KEY_TO) ? jo.getString(EmailMessage.EM_KEY_TO) : null;
        this.cc = jo.has(EmailMessage.EM_KEY_CC) ? jo.getString(EmailMessage.EM_KEY_CC) : null;
        this.bcc = jo.has(EmailMessage.EM_KEY_BCC) ? jo.getString(EmailMessage.EM_KEY_BCC) : null;
        this.subject = jo.has(EmailMessage.EM_KEY_SUBJECT) ? jo.getString(EmailMessage.EM_KEY_SUBJECT) : null;
        this.body = jo.has(EmailMessage.EM_KEY_BODY) ? jo.getString(EmailMessage.EM_KEY_BODY) : null;
        this.isHtml = jo.has(EmailMessage.EM_KEY_IS_HTML) && jo.getBoolean(EmailMessage.EM_KEY_IS_HTML);
        return this;
    }

    EmailMessageBuilder setWithJSONStr(String jsonStr) {
        setWithJSONObject(new JSONObject(jsonStr));
        return this;
    }
}
