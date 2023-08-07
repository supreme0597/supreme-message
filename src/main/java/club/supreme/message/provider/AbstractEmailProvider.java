package club.supreme.message.provider;

import club.supreme.message.model.MsgSendLog;

public abstract class AbstractEmailProvider extends AbstractProvider {
    protected abstract void doSend(MsgSendLog msgSendLog);
}