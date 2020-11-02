package com.example.jmeter;

import org.apache.jorphan.collections.HashTree;
import org.junit.Test;

import java.io.IOException;

public class JmeterTestPlanIT {

        //String domainName = "google.com";
        String domainName = "config.lte.cx-shop-nonprod.us-east-1.aws.sysco.net";
        //String path = "/search?q=" + "${" + JmeterTestPlan.QUERY_PARAMETER_VAR_NAME + "}";
        String path = "/configs/users?userId=" + "${" + JmeterTestPlan.QUERY_PARAMETER_VAR_NAME + "}&namespaces=MSS";
        String path2 = "/configs/users/ACTIVE_ORDER_ID?userId=perfma048&namespace=MSS";
        String inputCSVFile = "src/it/resources/userid.csv";

        @Test
        public void sendQueriesToGoogle () throws IOException {

            System.out.println("hello world");

            JmeterTestPlan testPlanClient = new JmeterTestPlan();

            HashTree createdTree = testPlanClient.createTestPLan(
                    inputCSVFile,
                    domainName,
                    path,
                    "GET",
                    1);
            HashTree createdTree2 = testPlanClient.createTestPLan(
                    inputCSVFile,
                    domainName,
                    path2,
                    "GET",
                    1);

            testPlanClient.engineRunner(createdTree);

        }

}
