package rare.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonTest {
    public static void main(String[] args) {
        String str = "{\"name\": \"rare\", \"age\":\"27\", \"city\":\"GangDong\"}";
        //jsonObjectToMap(str);
        //mapToStrJson();
        mapToJsonObj();
    }

    private static void strToJson(String str)
    {

        JSONObject jsonObject = JSON.parseObject(str);
        System.out.println("json对象是：" + jsonObject);
        Object object = jsonObject.get("name");

        System.out.println("name值是："+object);
    }


    private static void jsonObjectToStr(String string){
        // json 字符串转 json对象
        JSONObject jsonObject = JSON.parseObject(string);

        // json 对象 转为 json 字符串
        String jsonStr = jsonObject.toJSONString();

        System.out.println(jsonStr);
    }

    private static void jsonObjectToMap(String string) {
        JSONObject jsonObject = JSON.parseObject(string);

        // 类型强制转换
        Map<String, Object> map = (Map<String, Object>)jsonObject;

        System.out.println("map 对象是" + map);

        System.out.println(map.get("name"));
    }


    private static void mapToStrJson(){
        HashMap<String, String> hashMap = new HashMap<>(4);
        hashMap.put("name", "rare");
        hashMap.put("age", "24");
        hashMap.put("city", " guangdong");

        String jsonString = JSON.toJSONString(hashMap);

        System.out.println(jsonString);
    }


    private static void mapToJsonObj(){
        HashMap<String, Object> hashMap = new HashMap<>(4);
        hashMap.put("name", "rare");
        hashMap.put("age", "24");
        hashMap.put("city", "guangdong");

        JSONObject jsonObject = new JSONObject(hashMap);
        System.out.println(jsonObject);
    }
}
