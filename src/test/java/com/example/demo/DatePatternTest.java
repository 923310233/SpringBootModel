package com.example.demo;

import com.example.demo.model.ContractPagedQueryModel;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import sun.awt.image.ImageWatched;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;
import java.util.zip.DeflaterOutputStream;

/**
 * @Author: 吴硕涵
 * @Date: 2018/11/12 10:14 AM
 * @Version 1.0
 */
public class DatePatternTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test() throws Exception {
        List<String> stringList = new ArrayList<>();
        boolean f = stringList.isEmpty();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        formatter.parse("2017-05-29  11:48:59");

        String timeRegex = "^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))\\s+([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";

        boolean b_2 = Pattern.matches(timeRegex, "2017-05-29 11:48:59");

        Map<String, String> map = new HashMap<>();
        map.put("123", "abc");
        map.put("234", "bcd");
        ContractPagedQueryModel model = new ContractPagedQueryModel();
        model.setAppId("123456");
        logger.info("MSG{}", model);
    }

    @Test
    public void Test2() {

        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_WEEK, -1);
//        c.add(Calendar.MONTH, -1);
        Date m = c.getTime();
        System.out.println(m.getTime());

    }

    @Test
    public void Test3() {
        String a = "2018-11";
        String b = "2018-10";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        try {
            if (simpleDateFormat.parse(a).getTime() < simpleDateFormat.parse(b).getTime()) {
                System.out.println(1);
            } else {
                System.out.println(1);
            }

        } catch (Exception e) {

        }
    }


    @Test
    public void test4() {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            String str1 = "2012-03";
            String str2 = "2012-01";
            Calendar bef = Calendar.getInstance();
            Calendar aft = Calendar.getInstance();
            bef.setTime(sdf.parse(str1));
            aft.setTime(sdf.parse(str2));
            int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
            int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
            System.out.println(Math.abs(month + result));
        } catch (Exception e) {

        }
    }

    @Test
    public void test5() {
        LinkedHashMap<String, Double> map = new LinkedHashMap<>();
        map.put("2018-11", 1.0);
        map.put("2018-10", 1.0);
        map.put("2018-09", 1.0);
        map.put("2018-08", 1.0);
        try {
            Map.Entry<String, Double> tailByReflection = getTailByReflection(map);
            System.out.println(1);
        } catch (Exception e) {

        }
    }

    public <String, Double> Map.Entry<String, Double> getTailByReflection(LinkedHashMap<String, Double> map)
            throws NoSuchFieldException, IllegalAccessException {
        Field tail = map.getClass().getDeclaredField("tail");
        tail.setAccessible(true);
        return (Map.Entry<String, Double>) tail.get(map);
    }


    //md5
    @Test
    public void md5() {

        try {
            String s = "12345";
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(s.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            s = new BigInteger(1, md.digest()).toString(16);
            return;
        } catch (Exception e) {
        }

    }

    @Test
    public void dateTest(){
        String s = "2018-12-25 15:29:28";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date day= simpleDateFormat.parse(s);
            System.out.println(day.getTime());

        }catch (ParseException e){

        }
    }

    @Test
    public void elseTest() {

        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();

        int a = 3;
        int b = 0;
        if (a == 3) {
            b = 1;
        } else if (a == 4) {
            b = 2;
        } else if (a == 5) {
            b = 3;
        } else if (a == 6) {
            b = 4;
        } else if (a == 7) {
            b = 5;
        } else {
            b = 10;
        }
        return;
    }
}