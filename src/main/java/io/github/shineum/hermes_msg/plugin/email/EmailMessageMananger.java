package io.github.shineum.hermes_msg.plugin.email;

import io.github.shineum.hermes_msg.MessageManager;
import io.github.shineum.hermes_msg.entity.MessageResult;
import io.github.shineum.hermes_msg.plugin.email.entity.EmailMessage;
import io.github.shineum.hermes_msg.plugin.email.entity.EmailMessageBuilder;

public class EmailMessageMananger extends MessageManager {
    public static MessageResult addMessage(String name, EmailMessage emailMessage) {
        return addMessage(name, EmailMessageBuilder.convertToMessageStr(emailMessage));
    }
}
