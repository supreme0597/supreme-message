package club.supreme.message.enums;

import com.mybatisflex.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * release state
 *
 * @author supreme
 * @date 2023/08/06
 */
@AllArgsConstructor
@Getter
public enum ReleaseState {
    /**
     * 0 offline
     * 1 online
     */
    OFFLINE(0, "offline"),
    ONLINE(1, "online");

    @EnumValue
    private final int value;
    private final String label;
}
