package rare.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试json 转换
 * @author wxyou
 */
public class ListToJsonArray {
    public static void main(String[] args) {
        System.out.println(list2JsonArray());

        JSONArray jsonArray = list2JsonArray();
        HashMap<String, Object> hashMap = new HashMap<>(4);
        hashMap.put("status", 200);
        hashMap.put("msg", "");
        hashMap.put("data", jsonArray);

        System.out.println(hashMap);


        String mapJson = JSON.toJSONString(hashMap);
        System.out.println(mapJson);

        System.out.println("-------------------------------------------");

        HashMap<String, Object> hashMap1 = new HashMap<>(4);
        List<Map<String, String>> list = listTest();
        hashMap1.put("status", 200);
        hashMap1.put("msg", "");
        hashMap1.put("data", list);

        String mapJson1 = JSON.toJSONString(hashMap1);

        System.out.println(mapJson1);



    }

    private static JSONArray list2JsonArray(){
        List<Map<String, Object>> list = new ArrayList<>();
        HashMap<String, Object> hashMap = new HashMap<>(4);
        HashMap<String, Object> hashMap1 = new HashMap<>(4);
        hashMap.put("name", "rare");
        hashMap.put("age", 28);
        hashMap.put("city","zhuhai");

        hashMap1.put("name","rare1");
        hashMap1.put("age", "27");
        hashMap1.put("city","shanghai");

        list.add(hashMap);
        list.add(hashMap1);

        // 转为json字符串
        String str = JSON.toJSONString(list);

        // json 字符串转为 jsonArray
        JSONArray jsonArray = JSONArray.parseArray(str);

        return jsonArray;
    }


    private static List<Map<String, String>> listTest()
    {
        HashMap<String, String> hashMap = new HashMap<>(16);
        HashMap<String, String> hashMap1 = new HashMap<>(5);
        hashMap.put("name", "rare");
        hashMap.put("age", "28");
        hashMap.put("city","zhuhai");

        hashMap1.put("name", "rare1");
        hashMap1.put("age", "20");
        hashMap1.put("city", "shanghai");

        List<Map<String, String>> list = new ArrayList<>();
        list.add(hashMap);
        list.add(hashMap1);

        return list;
    }
}
