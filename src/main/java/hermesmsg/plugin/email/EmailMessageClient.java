package hermesmsg.plugin.email;

import hermesmsg.IMessageClient;
import hermesmsg.entity.MessageResult;
import hermesmsg.plugin.email.entity.EmailMessage;
import hermesmsg.plugin.email.entity.EmailMessageBuilder;

public abstract class EmailMessageClient implements IMessageClient {
    public MessageResult send(String msgStr) {
        return send(EmailMessageBuilder.fromMessageStr(msgStr));
    }

    public abstract MessageResult send(EmailMessage emailMessage);
}
