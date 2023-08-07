package club.supreme.message.service.bo;

import club.supreme.message.model.Receiver;
import club.supreme.message.model.ElComponentConfig;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class WorkflowConfigBO {
    private Long id;
    private String workflowCode;
    private String workflowName;
    private String workflowElData;
    private String workflowDesc;
    // 启动：发送配置
    private String sender;
    private List<Receiver> receivers;
    private Object payload;
    private Map<String, Object> elComponentTagConfigMap;
}