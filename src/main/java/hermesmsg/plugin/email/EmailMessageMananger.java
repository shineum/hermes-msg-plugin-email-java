package hermesmsg.plugin.email;

import hermesmsg.MessageManager;
import hermesmsg.entity.MessageResult;
import hermesmsg.plugin.email.entity.EmailMessage;
import hermesmsg.plugin.email.entity.EmailMessageBuilder;

public class EmailMessageMananger extends MessageManager {
    public static MessageResult addMessage(String name, EmailMessage emailMessage) {
        return addMessage(name, EmailMessageBuilder.convertToMessageStr(emailMessage));
    }
}
