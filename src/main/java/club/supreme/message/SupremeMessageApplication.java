package club.supreme.message;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;

/**
 * 消息中心启动类
 *
 * @author supreme
 * @date 2023/07/28
 */
@Slf4j
@SpringBootApplication
// 使用@RemoteApplicationEventScan注解扫描远程事件。
// 如果自定义远程事件不使用该注解扫描，这些事件会被识别成UnknownRemoteApplicationEvent
@RemoteApplicationEventScan(basePackages = "club.supreme.message")
@MapperScan("club.supreme.message.**.mapper")
public class SupremeMessageApplication {
    /**
     * 主函数
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        SpringApplication.run(SupremeMessageApplication.class, args);
    }
}
