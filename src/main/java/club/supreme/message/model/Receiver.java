package club.supreme.message.model;

import club.supreme.message.enums.ReceiverType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 接收对象
 *
 * @author supreme
 * @date 2023/07/31
 */
@Data
@Schema(description = "接收对象")
public class Receiver {
    /**
     * 接收对象ID
     */
    @Schema(description = "接收对象ID")
    private String receiverId;
    /**
     * 接收对象类型
     */
    @Schema(description = "接收对象类型")
    private ReceiverType receiverType;
}