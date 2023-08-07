package club.supreme.message.provider;

import club.supreme.message.model.MsgSendLog;
import club.supreme.message.model.MsgTemplate;

public interface Provider {
    void loadTemplate(MsgTemplate msgTemplate);
    void prepareAndSend(MsgSendLog msgSendLog, MsgTemplate msgTemplate);
}