package club.supreme.message.parser.logicflow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @author : zhangrongyan
 * @date : 2023/3/3 16:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LfNode {
    private String id;
    private String type;
    private Integer x;
    private Integer y;
    private Map<String,Object> properties;
    private TextEntity text;
    private List<String> children;

    @Data
    public static class TextEntity {
        private Integer x;
        private Integer y;
        private String value;
    }
}