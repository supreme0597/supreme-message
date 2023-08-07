package club.supreme.message.parser.logicflow;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author : zhangrongyan
 * @date : 2023/3/3 16:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "LogicFLow配置")
public class LogicFlow {
    /**
     * nodes
     */
    @Schema(description = "节点信息列表")
    @NotNull(message = "工作流配置：节点信息不可为空！")
    List<LfNode> nodes;

    /**
     * edges
     */
    @Schema(description = "连线信息列表")
    @NotNull(message = "工作流配置：连线信息不可为空！")
    List<LfEdge> edges;


}
