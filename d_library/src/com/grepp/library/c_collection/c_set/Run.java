package com.grepp.library.c_collection.c_set;

import com.grepp.library.c_collection.c_set.grepp._HashSet;
import com.grepp.library.c_collection.c_set.grepp._HashSet_p1;
import com.grepp.library.c_collection.c_set.grepp._HashSet_p2;
import com.grepp.library.c_collection.z_domain.School;
import com.grepp.library.c_collection.z_domain.SchoolFactory;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Run {

    public static void main(String[] args) {
        pracAdd();
        pracRemove();

        List<String> firstList = List.of(
          "김가희",
          "김예원",
          "김광훈",
          "안재호",
          "안세희"
        );
        
        List<String> secondList = List.of(
          "전정원",
          "정서윤",
          "채철민",
          "최대열",
          "안세희"
        );
        Set<String> firstSet = new HashSet<>(firstList);
        Set<String> secondSet = new HashSet<>(secondList);
        //pracSetOperation(firstSet, secondSet);
    }

    private static void pracSetOperation(Set<String> firstSet, Set<String> secondSet) {
        // NOTE C01 1. 합집합
        Set<String> setAll = new HashSet<>();
        setAll.addAll(firstSet);
        setAll.addAll(secondSet);
        System.out.println("===합집합===");
        System.out.println(setAll);

        // NOTE C02 2. 차집합
        System.out.println("===차집합===");
        setAll.removeAll(secondSet);
        System.out.println(setAll);

        // NOTE C03 3. 교집합
        System.out.println("===교집합===");
        firstSet.retainAll(secondSet);
        System.out.println(firstSet);

        // NOTE C04 4. 부분집합 여부
        System.out.println("===부분집합 여부===");
        System.out.println( secondSet.containsAll(firstSet));
    }


    private static void pracRemove() {
        List<School> list = SchoolFactory.crateSchools();
        _HashSet<School> set = new _HashSet<>();

        for (School school : list){
            set.add(school);
        }

        System.out.println(set);
        set.remove(new School("민사고", "대전", 3));
        System.out.println(set);
    }

    private static void pracAdd() {
        _HashSet<School> set = new _HashSet<>();
        List<School> list = SchoolFactory.crateSchools();

        for (School school : list){
            System.out.println(school);
            System.out.println(set.add(school));
        }

        System.out.println(set);
    }
}
