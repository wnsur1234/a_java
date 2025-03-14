package com.grepp.library.f_stream.b_stream;

import com.grepp.library.f_stream.z_domain.Exam;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Run {

    public static void main(String[] args) {

        //testStream();
        testSort();
    }

    private static void testSort() {
        List<Exam> list = createList();
        list = list.stream()
            .sorted((a, b) -> a.score() - b.score()).toList();
        System.out.println(list);
    }

    private static void testStream() {
        // NOTE B01 Stream
        // 1. Stream 생성
        Stream<Integer> iStream = Stream
            .<Integer>builder()
            .add(10).add(13).add(100).add(29)
            .build();

        List<Integer> list = iStream
            .sorted((a, b) ->  -(a-b))   // 2. 중간연산 , 내림차순정렬
            .toList();  // 3. 결과 연산

        System.out.println(list);
    }

    private static List<Exam> createList() {
        List<Exam> list = new ArrayList<>();
        list.add(new Exam("국어", "하명도", 90));
        list.add(new Exam("수학", "하명도", 70));
        list.add(new Exam("영어", "하명도", 65));
        list.add(new Exam("과학", "하명도", 46));
        return list;
    }

}
