package club.supreme.message.model.dto;

import club.supreme.message.model.Receiver;
import club.supreme.message.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

/**
 * 消息发送请求DTO
 *
 * @author supreme
 * @date 2023/07/31
 */
@Data
@Schema(description = "消息发送请求DTO")
public class MessageSendDTO {
    /**
     * 工作流ID
     */
    @Schema(description = "工作流ID")
    @NotBlank(message = "工作流ID不能为空")
    private String workFlowId;
    /**
     * 发送者
     */
    @Schema(description = "发送者")
    private String sender;
    /**
     * 接收者列表
     */
    @Schema(description = "接收者列表")
    private List<Receiver> receivers;
    /**
     * 主题
     */
    @Schema(description = "主题")
    private String subject;
    /**
     * 负载
     */
    @Schema(description = "负载")
    private Object payload;
}
