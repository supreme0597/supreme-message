package club.supreme.message.provider;

import club.supreme.message.formatter.UserFormatter;
import club.supreme.message.model.MsgSendLog;
import club.supreme.message.model.MsgTemplate;
import club.supreme.message.render.TemplateRenderer;

public abstract class AbstractProvider implements Provider {
    private UserFormatter userFormatter;
    private TemplateRenderer templateRenderer;
    public void loadTemplate(MsgTemplate msgTemplate) {
        templateRenderer.loadTemplate(msgTemplate);
    }

    @Override
    public void prepareAndSend(MsgSendLog msgSendLog, MsgTemplate msgTemplate) {
        loadTemplate(msgTemplate);
        preparePayload(msgSendLog);
        prepareReceiverIdList(msgSendLog);
        doSend(msgSendLog);
    }
    private void prepareReceiverIdList(MsgSendLog msgSendLog) {
        // msgSendLog.setReceiverIdList(userFormatter.format(msgSendLog.getReceiverList()));
    }
    private void preparePayload(MsgSendLog msgSendLog) {
        // msgSendLog.setMsgBody(templateRenderer.render(msgSendLog.getPayload()));
    }
    protected abstract void doSend(MsgSendLog msgSendLog);
}