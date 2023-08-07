package club.supreme.message.model;

import lombok.Data;

@Data
public class ElComponentConfig {
    private Long workFlowId;
    private Long elComponentTag;
    private Object config;
}