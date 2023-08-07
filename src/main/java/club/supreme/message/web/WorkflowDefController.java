package club.supreme.message.web;

import club.supreme.message.model.WorkflowDefinition;
import club.supreme.message.model.dto.WorkflowDefinitionDTO;
import club.supreme.message.model.table.WorkflowDefinitionTableDef;
import club.supreme.message.parser.ELNode;
import club.supreme.message.parser.ELParser;
import club.supreme.message.parser.ExpressLanguageParseException;
import club.supreme.message.parser.logicflow.LogicFlowParser;
import club.supreme.message.service.WorkflowDefService;
import com.mybatisflex.core.query.QueryWrapper;
import io.github.linpeilie.Converter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * workflow def controller
 *
 * @author supreme
 * @date 2023/08/06
 */
@Tag(name = "工作流定义", description = "工作流定义")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/workflowDefinition")
public class WorkflowDefController {
    /**
     * converter
     */
    private final Converter converter;
    /**
     * workflow def service
     */
    private final WorkflowDefService workflowDefService;

    /**
     * save
     * generate logic flow el
     *
     * @param workflowDefinitionDTO workflow definition dto
     * @return {@link WorkflowDefinition}
     * @throws ExpressLanguageParseException express language parse exception
     */
    @Operation(summary = "新建", description = "输入工作流基本信息和logicFlow结构")
    @PostMapping()
    public WorkflowDefinition save(@Validated(WorkflowDefinition.Insert.class) @RequestBody WorkflowDefinitionDTO workflowDefinitionDTO)
            throws ExpressLanguageParseException {
        WorkflowDefinition workflowDefinition = converter.convert(workflowDefinitionDTO, WorkflowDefinition.class);

        ELParser elParser = new LogicFlowParser(workflowDefinition.getLogicFlow());
        ELNode elNode = elParser.extractElNode();
        String elData = elNode.generateEl();

        workflowDefinition.setWorkflowElData(elData);
        workflowDefService.save(workflowDefinition);
        return workflowDefinition;
    }

    /**
     * update
     *
     * @param workflowDefinitionDTO workflow definition dto
     * @return {@link WorkflowDefinition}
     * @throws ExpressLanguageParseException express language parse exception
     */
    @Operation(summary = "更新", description = "输入工作流基本信息和logicFlow结构")
    @PutMapping()
    public ResponseEntity<String> update(@Validated(WorkflowDefinition.Update.class) @RequestBody WorkflowDefinitionDTO workflowDefinitionDTO)
            throws ExpressLanguageParseException {
        WorkflowDefinition workflowDefinition = converter.convert(workflowDefinitionDTO, WorkflowDefinition.class);

        if (!ObjectUtils.isEmpty(workflowDefinition.getLogicFlow())) {
            ELParser elParser = new LogicFlowParser(workflowDefinition.getLogicFlow());
            ELNode elNode = elParser.extractElNode();
            String elData = elNode.generateEl();

            workflowDefinition.setWorkflowElData(elData);
        }

        return ResponseEntity.ofNullable(workflowDefService.updateById(workflowDefinition, Boolean.TRUE) ? "更新成功" : "更新失败！您操作的数据可能已过期，请刷新最新数据后再更新数据！");
    }

    /**
     * get
     *
     * @param id id
     * @return {@link WorkflowDefinition}
     */
    @Operation(summary = "详情", description = "输入主键 查询详情")
    @GetMapping("{id}")
    public WorkflowDefinition get(@PathVariable("id") Integer id) {
        return workflowDefService.getById(id);
    }

    /**
     * getByCode
     *
     * @param code code
     * @return {@link WorkflowDefinition}
     */
    @Operation(summary = "详情-By code", description = "输入编码 查询详情")
    @GetMapping("getByCode/{code}")
    public ResponseEntity<WorkflowDefinition> getByCode(@PathVariable("code") String code) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.where(WorkflowDefinitionTableDef.WORKFLOW_DEFINITION.WORKFLOW_CODE.eq(code));
        return ResponseEntity.of(workflowDefService.getOneOpt(queryWrapper));
    }
}
