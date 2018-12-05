package com.example.demo;

import com.example.demo.model.ContractPagedQueryModel;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @Author: 吴硕涵
 * @Date: 2018/11/12 10:14 AM
 * @Version 1.0
 */
public class DatePatternTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test()throws Exception {
        List<String> stringList = new ArrayList<>();
        boolean f= stringList.isEmpty();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        formatter.parse("2017-05-29  11:48:59");

        String timeRegex = "^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))\\s+([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";

        boolean b_2 = Pattern.matches(timeRegex, "2017-05-29 11:48:59");

        Map<String ,String> map = new HashMap<>();
        map.put("123","abc");
        map.put("234","bcd");
        ContractPagedQueryModel model = new ContractPagedQueryModel();
        model.setAppId("123456");
        logger.info("MSG{}",model);
    }

}