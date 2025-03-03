package io.github.shineum.hermes_msg.plugin.email.entity;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Base64;

public class ByteArrayAttachmentJOSerializer {

    static Logger logger = LoggerFactory.getLogger(ByteArrayAttachmentJOSerializer.class);

    public static JSONObject serialize(ByteArrayAttachment byteArrayAttachment) {
        try {
            JSONObject jo = new JSONObject();
            jo.put(ByteArrayAttachment.BAA_KEY_FILENAME, byteArrayAttachment.getFilename());
            jo.put(ByteArrayAttachment.BAA_KEY_DATA, byteArrayAttachment.getBase64Data());
            jo.put(ByteArrayAttachment.BAA_KEY_CONTENT_TYPE, byteArrayAttachment.getContentType());
            return jo;
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return null;
    }

    public static ByteArrayAttachment fromJSONObject(JSONObject jo) {
        try {
            return new ByteArrayAttachment(
                    jo.getString(ByteArrayAttachment.BAA_KEY_FILENAME),
                    Base64.getDecoder().decode(jo.getString(ByteArrayAttachment.BAA_KEY_DATA)),
                    jo.getString(ByteArrayAttachment.BAA_KEY_CONTENT_TYPE));
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return null;
    }
}
