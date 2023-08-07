package club.supreme.message.service;

import club.supreme.message.event.CustomEvent;
import club.supreme.message.service.bo.MsgSendBO;
import club.supreme.message.service.bo.WorkflowConfigBO;
import com.yomahub.liteflow.core.FlowExecutor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageSendService {
    private final FlowExecutor flowExecutor;

    /**
     * 1、首先要明确一个概念：消息发送时，是基于配置来发送的。
     * 2、其次，如何获取这个配置？调用方肯定需要传入一个唯一标识：workflowCode
     *      需要根据这个唯一标识，去数据库查询对应的配置。
     *      这个配置包含执行流程，以及对应的配置信息
     * 3、最后，我们来分析，如何构建这个执行流程和配置的关系。
     *      执行流程可以是这样的：
     *        THEN(Deduplicator, RateLimiter, Delay, IF(x, ProviderHandler.tag(1), ProviderHandler.tag(2)), s1);
     *
     * @param msgSendBO        msg send log
     * @param workflowConfigBO workflow config
     */
    public void processAndSend(MsgSendBO msgSendBO, WorkflowConfigBO workflowConfigBO) {
        // Process and send the message based on the workflow configuration

        flowExecutor.execute2Resp(msgSendBO.getWorkFlowId(), workflowConfigBO, CustomEvent.class);
    }
}