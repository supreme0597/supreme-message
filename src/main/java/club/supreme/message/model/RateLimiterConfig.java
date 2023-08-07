package club.supreme.message.model;

import lombok.Data;

@Data
public class RateLimiterConfig {
    private String timespan;
    private Integer limit;
}