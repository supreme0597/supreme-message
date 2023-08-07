package club.supreme.message.event;

import club.supreme.message.model.dto.MessageSendDTO;
import lombok.Getter;
import org.springframework.cloud.bus.event.RemoteApplicationEvent;

// 自定义远程事件
public class CustomEvent extends RemoteApplicationEvent {

    @Getter
    private MessageSendDTO messageSendDTO;

    public CustomEvent() {
    }

    public CustomEvent(Object source, String originService, String destinationService, MessageSendDTO messageSendDTO) {
        super(source, originService, destinationService);
        this.messageSendDTO = messageSendDTO;
    }
}