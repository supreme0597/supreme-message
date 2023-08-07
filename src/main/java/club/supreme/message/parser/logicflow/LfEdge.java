package club.supreme.message.parser.logicflow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @author : zhangrongyan
 * @date : 2023/3/3 16:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LfEdge {
    private String id;
    private String type;
    private String sourceNodeId;
    private String targetNodeId;
    private LfPoint startPoint;
    private LfPoint endPoint;
    private List<LfPoint> pointsList;
    private Map<String,Object> properties;
    private TextEntity text;
    private String sourceAnchorId;
    private String targetAnchorId;

    @Data
    public static class TextEntity {
        private String value;
        private Integer x;
        private Integer y;
    }
}