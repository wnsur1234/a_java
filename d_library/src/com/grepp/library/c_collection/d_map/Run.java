package com.grepp.library.c_collection.d_map;

import com.grepp.library.c_collection.d_map.grepp._Entry;
import com.grepp.library.c_collection.d_map.grepp._HashMap;
import com.grepp.library.c_collection.z_domain.School;
import com.grepp.library.c_collection.z_domain.SchoolFactory;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Run {

    public static void main(String[] args) {
        pracPut();
        pracGet();
        pracLinkeHashMap();
    }

    private static void pracLinkeHashMap() {
        List<School> schools = SchoolFactory.crateSchools();

        // NOTE D01 LinkedHashMap
        // HashMap : 해시 함수를 사용해 entry 저장, 순서보장이 되지 않는다.
        Map<String, School> hashMap = new HashMap<>();
        // NOTE D02 LinkedHashMap
        // HashMap 의 Entry를 LinkedList 로 연결해 순서를 보장
        Map<String, School> linkedHashMap = new LinkedHashMap<>();

        for (School school : schools){
            hashMap.put(school.getName(), school);
        }

        for (School school : schools){
            linkedHashMap.put(school.getName(), school);
        }

        System.out.println(linkedHashMap);
        System.out.println(hashMap);
    }

    private static void pracGet() {
        System.out.println("===get===");
        _HashMap<String, School> map = createSchools();
        System.out.println(map.get("서울대"));
        System.out.println(map.get("연세대"));
        System.out.println(map.get("그랩"));

        for (_Entry<String, School> entry : map.entrySet()){
            System.out.println("key : " + entry.getKey());
            System.out.println("value : " + entry.getValue());
        }

        System.out.println("==============================");

//        for(String key : map.keySet()){
//            System.out.println("key : " + key);
//            System.out.println("value : " + map.get(key));
//        }

        System.out.println("==============================");

//        List<School> list = new ArrayList<>(map.values());
//        for(School school : list){
//            System.out.println(school);
//        }
    }

    private static _HashMap<String, School> createSchools() {
        _HashMap<String, School> map = new _HashMap<>();
        List<School> schools = SchoolFactory.crateSchools();
        for(School school : schools){
            map.put(school.getName(), school);
        }
        return map;
    }

    private static void pracPut() {
        List<School> schools = SchoolFactory.crateSchools();
        _HashMap<String, School> map = new _HashMap<>();

        map.put("서울대", schools.getFirst());
        map.put("연세대", schools.get(1));
        map.put("grepp", schools.get(2));
        map.put("grepp", new School("우리반","집", 4));
        System.out.println(map.get("grepp"));
    }
}
