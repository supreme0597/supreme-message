package club.supreme.message.provider;

import club.supreme.message.model.MsgSendLog;

public abstract class AbstractSMSProvider extends AbstractProvider {
    protected abstract void doSend(MsgSendLog msgSendLog);
}