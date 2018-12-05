package com.example.demo.fastJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.User;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 吴硕涵
 * @Date: 2018/11/24 10:20 AM
 * @Version 1.0
 */
public class TestJson {

    public String ListToJsonString() {
        List<String> stringList = new ArrayList<>();
        stringList.add("PROCESSED");
        stringList.add("FAILED");
        String result = JSON.toJSONString(stringList);

        return result;
    }

    public String strip() {
        String s1 = "[[UNPROCESSED]]";
        String strip = StringUtils.strip(s1, "[]");
        return s1;
    }

    public void StringToJson() {

        //将String字符串转换为JSONObject对象
        String json = "{\"id\":\"17051801\",\"name\":\"lucy\"}";

        JSONObject object = JSON.parseObject(json);
        String id = object.getString("id");
    }

    public void JsonToBean() {

        //将Json字符串转换为JavaBean对象
        String s = "{\"id\":\"17051801\",\"name\":\"lucy\"}";
        User user = JSON.parseObject(s, User.class);
    }

    public void ListToJsonArray() {
        //把JSON变List   最后面有把JSON变为实体类LIST的示例
        String phones = "[ \"Google\", \"Runoob\", \"Taobao\" ]";
        List<String> phoneList = JSONArray.parseArray(phones, String.class);
    }

    public void MapToJson() {
        //把MAP转为JSON型字符串   但MAP的KEY不允许重复
        Map<String, String> map = new HashMap<>();
        map.put("hello", "Tom");
        String jsonMap = JSON.toJSONString(map);
    }


    public void ListFromMapInJson() {

        //从Json字符串的Map中获取List对象
        String mapJsons = "{json:[{id:\"17051801\",\"name\":\"lucy\"},{id:\"17051802\",\"name\":\"peter\"},"
                + "{id:\"17051803\",\"name\":\"tom\"},{id:\"17051804\",\"name\":\"lily\"}]}";
        JSONObject object1 = JSON.parseObject(mapJsons);
        Object objArray = object1.get("json");

        //方式1:转换成JSONArray对象形式
        JSONArray array = JSON.parseArray(objArray.toString());

        for (int i = 0; i < array.size(); i++) {
            JSONObject obj = JSON.parseObject(array.get(i).toString());
        }


        //方式2:转换成List<JavaBean>形式
        List<User> list = JSON.parseArray(objArray.toString(), User.class);
        for (User userobject : list) {
        }
    }
}
