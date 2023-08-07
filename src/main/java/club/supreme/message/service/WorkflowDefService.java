package club.supreme.message.service;

import club.supreme.message.mapper.WorkflowDefinitionMapper;
import club.supreme.message.model.WorkflowDefinition;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class WorkflowDefService extends ServiceImpl<WorkflowDefinitionMapper, WorkflowDefinition> {
}
