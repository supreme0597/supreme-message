package club.supreme.message.enums;

import com.mybatisflex.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * message send status
 *
 * @author supreme
 * @date 2023/07/31
 */
@AllArgsConstructor
@Getter
public enum MsgSendStatus {
    PENDING(10, "待发送"),
    SENT(20,"已发送"),
    DELIVERED(30,"已送达"),
    FAILED(40,"发送失败"),
    READ(50,"已阅读");

    @EnumValue
    private final int value;
    private final String label;
}