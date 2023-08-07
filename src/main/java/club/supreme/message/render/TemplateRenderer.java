package club.supreme.message.render;

import club.supreme.message.model.MsgTemplate;

public interface TemplateRenderer {
    void loadTemplate(MsgTemplate msgTemplate);
    String render(Object payload);
}