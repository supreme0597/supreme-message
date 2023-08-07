package club.supreme.message.enums;

import com.mybatisflex.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * 接收者类型
 *
 * @author supreme
 * @date 2023/07/31
 */
@AllArgsConstructor
@Getter
public enum ReceiverType {
    USER(10, "用户"),
    ROLE(20, "角色"),
    TEAM(30, "团队"),
    I_RIGHT_GROUP(40, "域群组");

    @EnumValue
    private final int value;
    private final String label;
}