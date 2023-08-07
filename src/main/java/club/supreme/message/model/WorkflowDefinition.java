package club.supreme.message.model;

import club.supreme.message.enums.ReleaseState;
import club.supreme.message.parser.logicflow.LogicFlow;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.mybatisflex.core.handler.JacksonTypeHandler;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.groups.Default;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.ibatis.annotations.Insert;

import java.time.LocalDateTime;

/**
 * workflow definition
 *
 * @author supreme
 * @date 2023/08/06
 */
@Data
@Table("t_msg_workflow_definition")
public class WorkflowDefinition {
    @Id(keyType = KeyType.Auto)
    private int id;

    private String workflowCode;
    private String workflowName;

    /**
     * liteflow的表达式，前端不需要看到。
     */
    @JsonIgnore
    private String workflowElData;
    private String workflowDesc;

    /**
     * 应用名称，liteflow专用的字段，前端不需要看到
     */
    @JsonIgnore
    private String applicationName;

    /**
     * 前端传入的报文
     */
    @Column(typeHandler = JacksonTypeHandler.class)
    private LogicFlow logicFlow;

    /**
     * 发布状态, 默认状态为下线
     */
    @Schema(description = "发布状态")
    private ReleaseState releaseState = ReleaseState.OFFLINE;
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
    private int delFlag;
    /**
     * 乐观锁
     */
    @Schema(description = "乐观锁")
    @Column(version = true)
    private int revision;

    public interface Insert extends Default {

    }

    public interface Update extends Default {

    }
}