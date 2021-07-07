package com.example.test.tinet;

/**
 * @Author ShineQi
 * @Date 2020/10/12 16:16
 */
public class MapTest {
    public static void main(String[] args) {
        /*List<Map<String,String>> mapList = null;
        Map<String,String> map = new HashMap();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key2","value3");
        mapList.add(map);
        String o = mapList.get(0).get("key1");
        System.out.println(o);*/
        String key = "answer_count";
        String[] strings = key.split("_");
        StringBuilder show = new StringBuilder(strings[0]);
        int count = 0;
        if (strings.length > 1) {
            for (String string : strings) {
                if (count > 0) {
                    show.append(string.substring(0, 1).toUpperCase()).append(string.substring(1));
                }
                count++;
            }
        }

    }
}
