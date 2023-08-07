package club.supreme.message.model;

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


/**
 * 消息模板类
 *
 * @author supreme
 * @date 2023/07/31
 */
@Data
@Table("msg_template")
@Schema(description = "消息模板类")
@EqualsAndHashCode(callSuper = true)
public class MsgTemplate extends Model<MsgTemplate> {
    /**
     * ID
     */
    @Id(keyType = KeyType.Auto)
    private Integer id;
    /**
     * 模板名称
     */
    @Schema(description = "模板名称")
    private String templateName;
    /**
     * 模板描述
     */
    @Schema(description = "模板描述")
    private String templateDesc;
    /**
     * 模板主题
     */
    @Schema(description = "模板主题")
    private String templateSubject;
    /**
     * 模板内容
     */
    @Schema(description = "模板内容")
    private String templateContent;
    /**
     * 脚本ID
     */
    @Schema(description = "脚本ID")
    private String scriptId;
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