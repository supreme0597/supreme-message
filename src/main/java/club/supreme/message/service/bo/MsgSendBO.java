package club.supreme.message.service.bo;

import club.supreme.message.model.Receiver;
import club.supreme.message.model.User;
import lombok.Data;

import java.util.List;

/**
 * 消息发送请求DTO
 *
 * @author supreme
 * @date 2023/07/31
 */
@Data
public class MsgSendBO {
    /**
     * 工作流ID
     */
    private String workFlowId;
    /**
     * 发送者
     */
    private String sender;
    /**
     * 接收者列表
     */
    private List<Receiver> receivers;
    /**
     * 主题
     */
    private String subject;
    /**
     * 负载
     */
    private Object payload;
    /**
     * 接收者列表
     */
    private List<User> receiverList;
    /**
     * 接收者ID列表
     */
    private List<String> receiverIdList;
    /**
     * 消息体
     */
    private Object msgBody;
}
