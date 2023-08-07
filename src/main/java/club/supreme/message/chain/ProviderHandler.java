package club.supreme.message.chain;

import club.supreme.message.resolver.CompositeReceiverResolver;
import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@LiteflowComponent("ProviderHandler")
public class ProviderHandler extends NodeComponent {
    private CompositeReceiverResolver compositeReceiverResolver;

    @Override
    public void process() throws Exception {
        log.info("[ProviderHandler] >>> {}", "test");
    }
}