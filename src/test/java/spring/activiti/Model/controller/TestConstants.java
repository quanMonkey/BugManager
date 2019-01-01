package spring.activiti.Model.controller;

import org.junit.Test;
import static org.junit.Assert.*;
import spring.activiti.Constants;

import java.util.Arrays;
import java.util.List;

/**
 * Created by liuquan on 2018/5/13.
 */
public class TestConstants {

    @Test
    public void modelDeployStatus(){

        Constants.ModelDeployStatus status = Enum.valueOf(Constants.ModelDeployStatus.class, "DEPLOYED");
        assertEquals(Constants.ModelDeployStatus.DEPLOYED.getStatus(), status.getStatus());

        Constants.ModelDeployStatus[] modelDeployStatuses = Constants.ModelDeployStatus.values();
        List<Constants.ModelDeployStatus> modelDeployStatusList = Arrays.asList(modelDeployStatuses);
        for(Constants.ModelDeployStatus m : modelDeployStatusList){
            System.out.println(m.getStatus() +" | "+ m.getDescription());
        }
    }
}
