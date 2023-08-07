package club.supreme.message.chain;

import club.supreme.message.model.DeduplicatorConfig;
import club.supreme.message.model.ElComponentConfig;
import club.supreme.message.service.bo.WorkflowConfigBO;
import cn.hutool.core.util.ObjectUtil;
import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.slot.DefaultContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@LiteflowComponent("Deduplicator")
public class Deduplicator extends NodeComponent {
    @Override
    public void process() throws Exception {
        log.info("[Deduplicator] >>> {}", "test");
        // 获取配置
        String tag = this.getTag();
        WorkflowConfigBO workflowConfigBO = this.getRequestData();
        if (workflowConfigBO.getElComponentTagConfigMap().containsKey(tag)) {
            DeduplicatorConfig deduplicatorConfig =
                    (DeduplicatorConfig) workflowConfigBO.getElComponentTagConfigMap().get(tag);
            log.info("[DeduplicatorConfig] >>> {}", deduplicatorConfig);

            // 未获取到配置，不执行
            if (ObjectUtil.isNull(deduplicatorConfig)) {
                return;
            }
            Object firstContextBean = this.getFirstContextBean();
            // firstContextBean.set
        }
    }
}