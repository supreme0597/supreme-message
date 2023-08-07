package club.supreme.message.render;

import club.supreme.message.model.MsgTemplate;

class AliSMSTemplateRenderer implements TemplateRenderer {
    private MsgTemplate msgTemplate;
    public void loadTemplate(MsgTemplate msgTemplate) {
        this.msgTemplate = msgTemplate;
    }
    public String render(Object payload) {
        // Render the template with the payload
        return null;
    }
}