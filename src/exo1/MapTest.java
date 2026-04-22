package exo1;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        cacl();

    }
    public static void cacl(){
        //新建一个集合来储存80个学生的选择
        List<String> xuanze = new ArrayList<>();
        String[] jingdian ={"天安门","大同古城","广州塔","珠海大剧院"};
        Random r = new Random();
        for (int i = 1; i <=80; i++) {
            int index = r.nextInt(jingdian.length);
            xuanze.add(jingdian[index]);
        }
        System.out.println(xuanze);

        //统计每个人景点选择的人数
        //最终的统计结果是键值对形式，可以用Map来存储
        Map<String,Integer> map = new HashMap<>();
        for (String s : xuanze) {
            if (map.containsKey(s)){
                map.put(s,map.get(s)+1);
            }else {
                map.put(s,1);
            }
        }
        map.forEach((k,v)-> System.out.println(k+"被选了"+v+"次"));
    }

}
