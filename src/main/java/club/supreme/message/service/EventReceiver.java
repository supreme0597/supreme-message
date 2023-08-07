package club.supreme.message.service;

import club.supreme.message.event.CustomEvent;
import club.supreme.message.model.dto.MessageSendDTO;
import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import com.yomahub.liteflow.slot.DefaultContext;
import com.yomahub.liteflow.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.bus.ServiceMatcher;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 接收CustomEvent事件
 *
 * @author supreme
 * @date 2023/07/28
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class EventReceiver {
    /**
     * publisher
     */
    private final ApplicationEventPublisher publisher;

    /**
     * flow executor
     */
    private final FlowExecutor flowExecutor;

    /**
     * bus service matcher
     */
    private final ServiceMatcher busServiceMatcher;

    /**
     * receive2
     *
     * @param event event
     */
    @Async
    @EventListener
    public void receive2(CustomEvent event) {
        log.info("receive2：{}", event.getMessageSendDTO());
    }

    /**
     * receive
     *
     * @param event event
     */
    @Async
    @EventListener
    public void receive(CustomEvent event) {
        log.info("receive：{}", event.getMessageSendDTO());
        LiteflowResponse response = flowExecutor.execute2Resp("chain1", event.getMessageSendDTO());
        DefaultContext context = response.getFirstContextBean();
        log.info("[user] >>> {}", JsonUtil.toJsonString(context.getData("student")));
        if (response.isSuccess()) {
            log.info("执行成功");
        } else {
            log.info("执行失败");
        }
    }


    /**
     * publish
     *
     * @param messageSendDTO        messageSendDTO
     * @param destination destination
     */
    public void publish(MessageSendDTO messageSendDTO, String destination) {
        String originService = busServiceMatcher.getBusId();
        CustomEvent event = new CustomEvent(this, originService, destination, messageSendDTO);
        this.publisher.publishEvent(event);
    }
}