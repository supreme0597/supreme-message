package club.supreme.message.web;

import club.supreme.message.model.dto.MessageSendDTO;
import club.supreme.message.parser.ELNode;
import club.supreme.message.parser.ELParser;
import club.supreme.message.parser.ExpressLanguageParseException;
import club.supreme.message.parser.logicflow.LfNode;
import club.supreme.message.parser.logicflow.LogicFlow;
import club.supreme.message.parser.logicflow.LogicFlowParser;
import club.supreme.message.service.EventReceiver;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * bus controller
 *
 * @author supreme
 * @date 2023/07/28
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class BusController {
    /**
     * event receiver
     */
    private final EventReceiver eventReceiver;

    /**
     * event
     *
     * @param messageSendDTO messageSendDTO
     * @param destination    destination
     * @return {@link String}
     */
    @PostMapping("/event")
    public String event(@RequestBody MessageSendDTO messageSendDTO,
                        // destination表示事件目的地，空表示所有应用都会接收
                        @RequestParam(required = false) String destination) {
        eventReceiver.publish(messageSendDTO, destination);
        return "ok";
    }



    @Operation(summary = "logicFlow转化el表达式", description = "输入logicFlow 结构")
    @PostMapping("/generateLogicFlowEL")
    public String generateLogicFlowEL(@RequestBody LogicFlow logicFlow) {
        String sqlTemplate = null;
        try {
            List<Map<String, Object>> mapList = logicFlow.getNodes().stream().map(LfNode::getProperties).collect(Collectors.toList());

            log.info("[properties]: {}", mapList);
            ELParser elParser = new LogicFlowParser(logicFlow);
            ELNode elNode = elParser.extractElNode();
            sqlTemplate = elNode.generateEl();
        } catch (ExpressLanguageParseException e) {
            e.printStackTrace();
        }
        return sqlTemplate;
    }

    // devti://story/github/1
    // devti://story/github/5
    // devti://story/github/7
    // devti://story/github/7777777
}