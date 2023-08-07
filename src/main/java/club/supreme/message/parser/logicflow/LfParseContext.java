package club.supreme.message.parser.logicflow;

import club.supreme.message.parser.ELNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * @author : zhangrongyan
 * @date : 2023/5/4 9:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LfParseContext {

    /**
     * 节点Id -> 节点的多个边
     * sourceId-> List<EdgeEntity>
     */
    Map<String, List<LfEdge>> sourceNodeToEdgesMap;
    Map<String, List<LfEdge>> targetNodeToEdgesMap;

    /**
     *  所有的节点
     */
    Map<String, LfNode> nodeMap;

    /**
     * 所有的when节点
     */
    Map<String, LfNode> whenNodeMap;


    /**
     * 最外层的when
     */
    Set<LfNode> outermostLayerWhen;



    //待转化的Map, 父when -> 子when节点List
    Map<String, Set<String>> whenWaitProcessNestingMap = new HashMap<>();

    //已转化好的whenCompleteElNodeMap
    //when 节点id -》 ELNode节点
    Map<String, List<ELNode>> whenCompleteElNodeMap = new HashMap<>();

    List<WhenGroupTrees> whenGroupTreesList = new ArrayList<>();
}
