package hermesmsg.entity;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Optional;

public class EmailMessageJOSerializer {

    static Logger logger = LoggerFactory.getLogger(EmailMessageJOSerializer.class);

    public static JSONObject serialize(EmailMessage emailMessage) {
        try {
            JSONObject jo = new JSONObject();
            jo.put(EmailMessage.EM_KEY_FROM, emailMessage.from);
            jo.put(EmailMessage.EM_KEY_TO, emailMessage.to);
            jo.put(EmailMessage.EM_KEY_CC, emailMessage.cc);
            jo.put(EmailMessage.EM_KEY_BCC, emailMessage.bcc);
            jo.put(EmailMessage.EM_KEY_SUBJECT, emailMessage.subject);
            jo.put(EmailMessage.EM_KEY_BODY, emailMessage.body);
            jo.put(EmailMessage.EM_KEY_IS_HTML, emailMessage.isHtml);
            JSONArray ja = new JSONArray();
            Optional.ofNullable(emailMessage.attachments)
                    .orElse(Collections.emptyList())
                    .forEach(e -> {
                        ja.put(ByteArrayAttachmentJOSerializer.serialize(e));
                    });
            jo.put(EmailMessage.EM_KEY_ATTACHMENTS, ja);
            return jo;
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return null;
    }

    public static EmailMessage fromJSONObject(JSONObject jo) {
        try {
            EmailMessageBuilder emailMessageBuilder = new EmailMessageBuilder().setWithJSONObject(jo);
            if (jo.has(EmailMessage.EM_KEY_ATTACHMENTS)) {
                jo.getJSONArray(EmailMessage.EM_KEY_ATTACHMENTS)
                        .forEach(e -> {
                            emailMessageBuilder.addAttachment(ByteArrayAttachmentJOSerializer.fromJSONObject((JSONObject) e));
                        });
            }
            return emailMessageBuilder.build();
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return null;
    }
}
