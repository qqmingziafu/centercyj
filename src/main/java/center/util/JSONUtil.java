package center.util;


import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 * @Class:JSONUtil
 * @Type:class
 * @Author:cyj
 * @Date: 2020-04-20 21:23
 * @Description: simpile-json再封装
 */
public class JSONUtil {

    private Logger log = Logger.getLogger(JSONUtil.class);

    public String defString(JSONObject jsonObject, Object key, String defValue){
        String value = get(jsonObject, key, String.class);
        return null == value ? defValue : value;
    }

    public JSONObject defJSONObject(JSONObject jsonObject, Object key, JSONObject defValue){
        JSONObject value = get(jsonObject, key, JSONObject.class);
        return null == value ? defValue : value;
    }

    public JSONArray defJSONArray(JSONObject jsonObject, Object key, JSONArray defValue){
        JSONArray value = get(jsonObject, key, JSONArray.class);
        return null == value ? defValue : value;
    }

    public <T> T get(JSONObject jsonObject, Object key, Class<T> tClass) {
        if (!jsonObject.containsKey(key)) {
            return null;
        }
        Object value = jsonObject.get(key);
        return transition(value, tClass);
    }

    public Object parse(Object object) {
        return JSONValue.parse(object.toString());
    }

    private <T> T transition(Object value, Class<T> tClass) {
        try {
            if (tClass.isAssignableFrom(JSONObject.class) || tClass.isAssignableFrom(JSONArray.class)) {
                return (T) parse(value);
            }
            return (T) value;
        } catch (ClassCastException cce) {
            log.error("can't transition", cce);
            return null;
        }

    }

    /*@Test
    public void test1() {
        JSONObject jsonObject = new JSONObject();
        JSONObject object = new JSONObject();
        JSONArray array = new JSONArray();
        Integer integer = 1;
        Short aShort = 2;
        Long aLong = 999L;
        Float aFloat = 999.9f;
        Double aDouble = 999.99d;
        String aString = "str";
        jsonObject.put("object", object);
        jsonObject.put("array", array);
        jsonObject.put("int", integer);
        jsonObject.put("short", aShort);
        jsonObject.put("long", aLong);
        jsonObject.put("float", aFloat);
        jsonObject.put("double", aDouble);
        jsonObject.put("string", aString);

        System.out.println(get(jsonObject, "object", JSONObject.class));
        System.out.println(get(jsonObject, "array", JSONArray.class));
        System.out.println(get(jsonObject, "int", Integer.class));
        System.out.println(get(jsonObject, "short", Short.class));
        System.out.println(get(jsonObject, "long", Long.class));
        System.out.println(get(jsonObject, "float", Float.class));
        System.out.println(get(jsonObject, "double", Double.class));
        System.out.println(get(jsonObject, "string", Integer.class));
        *//*System.out.println((Integer)((Object) aDouble));*//*
    }*/


}
