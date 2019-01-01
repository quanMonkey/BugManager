package spring.activiti.Model.controller;

/**
 * Created by liuquan on 2018/4/19.
 */

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.activiti.engine.history.HistoricProcessInstance;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import spring.activiti.Model.pojo.ApprovalEntity;
import spring.activiti.Model.service.ProcessServiceImpl;

import javax.print.attribute.standard.Media;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml","classpath:activiti-custom-context.xml","classpath:activiti-mvc.xml"})
@WebAppConfiguration
public class TestModelController {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void createModel() throws Exception {
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post("/ModelController/createModel.json");
        mockHttpServletRequestBuilder.contentType(MediaType.APPLICATION_FORM_URLENCODED);
        mockHttpServletRequestBuilder.param("modelName", "贷款申请")
                .param("modelKey", "money")
                .param("modelDescription","这是一个关于贷款申请的流程");
        ResultActions resultActions = mockMvc.perform(mockHttpServletRequestBuilder);
        resultActions.andExpect(status().isOk());
        resultActions.andDo(print());
        String responseStr = resultActions.andReturn().getResponse().getContentAsString();
        System.out.println(responseStr);
    }

    @Test
    public void list() throws Exception {
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post("/ModelController/list.json");
        mockHttpServletRequestBuilder.contentType(MediaType.APPLICATION_FORM_URLENCODED);
        mockHttpServletRequestBuilder.param("modelName", "贷款申请")
                .param("modelKey", "money");
        ResultActions resultActions = mockMvc.perform(mockHttpServletRequestBuilder);
        resultActions.andExpect(status().isOk());
        resultActions.andDo(print());
        String responseStr = resultActions.andReturn().getResponse().getContentAsString();
        System.out.println(responseStr);
    }

    @Test
    public void taskList() throws Exception {
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post("/TaskController/taskList.json");
        mockHttpServletRequestBuilder.contentType(MediaType.APPLICATION_FORM_URLENCODED);
        ResultActions resultActions = mockMvc.perform(mockHttpServletRequestBuilder);
        resultActions.andExpect(status().isOk());
        resultActions.andDo(print());
        String responseStr = resultActions.andReturn().getResponse().getContentAsString();
        System.out.println(responseStr);
    }

    @Test
    public void startProcessInstance() throws Exception {
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post("/ProcessController/startProcessInstance.json");
        mockHttpServletRequestBuilder.contentType(MediaType.APPLICATION_FORM_URLENCODED);
        mockHttpServletRequestBuilder.param("processDefinitionKey", "monkey")
                                     .param("businessId", "1");
        ResultActions resultActions = mockMvc.perform(mockHttpServletRequestBuilder);
        resultActions.andExpect(status().isOk());
    }

    @Test
    public void deleteProcessInstance() throws Exception {
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post("/ProcessController/deleteProcessInstance.json");
        mockHttpServletRequestBuilder.contentType(MediaType.APPLICATION_FORM_URLENCODED);
        mockHttpServletRequestBuilder.param("processInstanceId", "d43d002c-7795-11e8-8158-9acc0b2e77c5");
        ResultActions resultActions = mockMvc.perform(mockHttpServletRequestBuilder);
        resultActions.andExpect(status().isOk());
    }

    @Test
    public void completeTask() throws Exception {
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post("/TaskController/completeTask.json");
        mockHttpServletRequestBuilder.contentType(MediaType.APPLICATION_FORM_URLENCODED);
        mockHttpServletRequestBuilder.param("assignee", "4");
//        mockHttpServletRequestBuilder.param("pass", "true");
        ResultActions resultActions = mockMvc.perform(mockHttpServletRequestBuilder);
        resultActions.andExpect(status().isOk());
    }

    @Test
    public void completeTaskByTaskId() throws Exception {
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post("/TaskController/completeTaskByTaskId.json");
        mockHttpServletRequestBuilder.contentType(MediaType.APPLICATION_FORM_URLENCODED);
        mockHttpServletRequestBuilder.param("taskId", "694e1e67-77c5-11e8-bdc9-9acc0b2e77c5");
        mockHttpServletRequestBuilder.param("approvalStatus", "2");
        mockHttpServletRequestBuilder.param("remark", "贷款审批");
        ResultActions resultActions = mockMvc.perform(mockHttpServletRequestBuilder);
        resultActions.andExpect(status().isOk());
    }


    @Test
    public void claimTask() throws Exception {
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post("/TaskController/claimTask.json");
        mockHttpServletRequestBuilder.contentType(MediaType.APPLICATION_FORM_URLENCODED);
        mockHttpServletRequestBuilder.param("taskId", "343d5ee3-77c5-11e8-ad44-9acc0b2e77c5")
                .param("userId", "5");
        ResultActions resultActions = mockMvc.perform(mockHttpServletRequestBuilder);
        resultActions.andExpect(status().isOk());

        resultActions.andDo(print());
        String responseStr = resultActions.andReturn().getResponse().getContentAsString();
        System.out.println(responseStr);
    }

    @Test
    public void queryApprovalInfo() throws Exception {
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post("/HistoryTaskController/approvalInfo.json");
        mockHttpServletRequestBuilder.contentType(MediaType.APPLICATION_FORM_URLENCODED);
        mockHttpServletRequestBuilder.param("taskId", "694e1e67-77c5-11e8-bdc9-9acc0b2e77c5");
        ResultActions resultActions = mockMvc.perform(mockHttpServletRequestBuilder);
        resultActions.andExpect(status().isOk());

        resultActions.andDo(print());
        String responseStr = resultActions.andReturn().getResponse().getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        List<ApprovalEntity> approvalEntityList = mapper.readValue(responseStr, new TypeReference<List<ApprovalEntity>>(){});

        for(ApprovalEntity approvalEntity : approvalEntityList){
            System.out.println(approvalEntity);
        }
    }


    @Autowired
    private ProcessServiceImpl processServiceImpl;

    @Test
    public void deleteHisProcessInstance() throws Exception {
        List<HistoricProcessInstance> processInstanceList = processServiceImpl.getHisProcessInstance();
        for(HistoricProcessInstance p : processInstanceList) {
            processServiceImpl.deleteHisProcessInstance(p.getId(), "");
        }
    }
}
