package club.supreme.message.model.dto;

import club.supreme.message.enums.ReleaseState;
import club.supreme.message.model.WorkflowDefinition;
import club.supreme.message.parser.logicflow.LogicFlow;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.mybatisflex.core.handler.JacksonTypeHandler;
import io.github.linpeilie.annotations.AutoMapper;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import jakarta.validation.groups.Default;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * workflow definition
 *
 * @author supreme
 * @date 2023/08/06
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Schema(description = "工作流定义DTO")
@AutoMapper(target = WorkflowDefinition.class)
public class WorkflowDefinitionDTO {
    /**
     * id
     */
    @Schema(description = "主键")
    @Digits(integer = 11, fraction = 0)
    @Null(message = "新增不可传入主键！", groups = WorkflowDefinition.Insert.class)
    @NotNull(message = "请传入主键！", groups = WorkflowDefinition.Update.class)
    private Integer id;

    /**
     * workflow code
     */
    @Size(max = 32)
    @Schema(description = "工作流定义唯一标识")
    @NotBlank(message = "请输入工作流定义唯一标识！", groups = WorkflowDefinition.Insert.class)
    private String workflowCode;

    /**
     * workflow name
     */
    @Size(max = 128)
    @Schema(description = "工作流定义名称")
    @NotBlank(message = "请输入工作流定义名称！", groups = WorkflowDefinition.Insert.class)
    private String workflowName;

    /**
     * workflow desc
     */
    @Size(max = 1024)
    @Schema(description = "工作流定义描述")
    private String workflowDesc;

    /**
     * 工作流图形配置
     */
    @Valid
    @NotNull(message = "请输入工作流图形配置", groups = WorkflowDefinition.Insert.class)
    @Schema(description = "工作流图形配置")
    private LogicFlow logicFlow;

    /**
     * 乐观锁
     */
    @Schema(description = "乐观锁")
    @NotNull(message = "请输入乐观锁版本号", groups = WorkflowDefinition.Update.class)
    private Integer revision;
}