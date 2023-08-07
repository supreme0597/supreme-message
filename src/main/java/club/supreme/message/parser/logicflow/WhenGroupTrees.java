package club.supreme.message.parser.logicflow;

import club.supreme.message.parser.ELNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author : zhangrongyan
 * @date : 2023/3/8 14:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WhenGroupTrees {
    /**
     * when Group 节点
     */
    String whenGroupNodeId;
//
//    /**
//     * 非本when组，外部节点
//     */
//    String externalNodeId;

    /**
     * when中有多棵树
     */
    List<ELNode> elNodeList;

}
