package com.grepp.library.c_collection.d_map;

import com.grepp.library.c_collection.z_domain.School;
import com.grepp.library.c_collection.z_domain.SchoolFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Run {

    public static void main(String[] args) {
        List<School> schools = SchoolFactory.crateSchools();
        pracPut();
    }

    private static void pracPut() {
        List<School> schools = SchoolFactory.crateSchools();
        Map<String, School> map = new HashMap<>();

        map.put("서울대", schools.getFirst());
        map.put("연세대", schools.get(1));
        map.put("grepp", schools.get(2));
        map.put("grepp", new School("우리반","집", 4));
        System.out.println(map);
    }
}
