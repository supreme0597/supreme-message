package club.supreme.message.model;

import club.supreme.message.enums.MsgSendStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.mybatisflex.core.activerecord.Model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

/**
 * message send log
 *
 * @author supreme
 * @date 2023/07/31
 */
@Data
@Table("message_send_log")
@Schema(description = "消息发送日志")
@EqualsAndHashCode(callSuper = true)
public class MsgSendLog extends Model<MsgSendLog> {
    /**
     * ID
     */
    @Id(keyType = KeyType.Auto)
    private Integer id;
    /**
     * 工作流编码
     */
    @Schema(description = "工作流编码")
    private String workflowCode;
    /**
     * 发送者ID
     */
    @Schema(description = "发送者ID")
    private String senderId;
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

    /**
     * 发送状态, 默认状态为待发送
     */
    @Schema(description = "发送状态")
    private MsgSendStatus sendStatus = MsgSendStatus.PENDING;
    /**
     * 创建时刻
     */
    @Schema(description = "创建时刻")
    @Column(onInsertValue = "now()")
    private LocalDateTime createdAt;
    /**
     * 创建者
     */
    @Schema(description = "创建者")
    @Column(onInsertValue = "")
    private String createdBy;
    /**
     * 更新时刻
     */
    @Schema(description = "更新时刻")
    @Column(onInsertValue = "now()", onUpdateValue = "now()")
    protected LocalDateTime updatedAt;
    /**
     * 更新者
     */
    @Schema(description = "更新者")
    @Column(onInsertValue = "", onUpdateValue = "")
    protected String updatedBy;
    /**
     * 逻辑删除标识
     */
    @Schema(description = "逻辑删除标识")
    @JsonIgnore
    @Column(isLogicDelete = true)
    private Integer delFlag;
    /**
     * 乐观锁
     */
    @Schema(description = "乐观锁")
    @JsonIgnore
    @Column(version = true)
    private Integer revision;
}