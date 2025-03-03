package io.github.shineum.hermes_msg.plugin.email;

import io.github.shineum.hermes_msg.IMessageClient;
import io.github.shineum.hermes_msg.entity.MessageResult;
import io.github.shineum.hermes_msg.plugin.email.entity.EmailMessage;
import io.github.shineum.hermes_msg.plugin.email.entity.EmailMessageBuilder;

public abstract class EmailMessageClient implements IMessageClient {
    public MessageResult send(String msgStr) {
        return send(EmailMessageBuilder.fromMessageStr(msgStr));
    }

    public abstract MessageResult send(EmailMessage emailMessage);
}
