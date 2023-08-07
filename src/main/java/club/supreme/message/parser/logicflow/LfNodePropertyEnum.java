package club.supreme.message.parser.logicflow;

import lombok.Getter;

/**
 * LogicFlow的Node 自定义配置的属性key
 *
 * @author : zhangrongyan
 * @date : 2023/3/6 17:33
 */
@Getter
public enum LfNodePropertyEnum {
    nodeId,
    nodeTag,
    nodeData,
    /**
     * 对应ELNode.ELName
     * @see ELNode.ELNameEnum
     */
    nodeType,
    conditionNodeId,
    nodeAliasId,
    ;

}
