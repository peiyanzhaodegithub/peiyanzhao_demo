package com.example.demo.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamTest {


    public static void main(String[] args) {
        //迭代
        Stream<Integer> iterate = Stream.iterate(0, (x) -> x + 2);
//0 2 4 6 8
        iterate.limit(10).forEach(System.out::println);

//生成
        Stream<Double> generate = Stream.generate(() -> Math.random());
//84 28 71
        generate.limit(3).forEach(System.out::println);
        List<String> list = Arrays.asList("bb", "aa", "cc", "dd", "d", "c", "da");
        Optional<String> first = list.stream()
                .findAny();
        System.out.println(first.get());

    }


}
