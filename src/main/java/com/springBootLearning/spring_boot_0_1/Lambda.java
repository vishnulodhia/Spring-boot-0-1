package com.springBootLearning.spring_boot_0_1;

import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.stream.Stream;

public class Lambda {

    public static void main(String[] args) {

        Walkable obj = (steps) -> {
            System.out.println("waling fast "+steps);
            return 2*steps;
        };
        obj.walk(5);


        List<String> fruit = List.of("Apple","Banana","Kiwi");
        Stream<String> stream = fruit.stream();

        stream.forEach(fruits->
                System.out.println(fruits));

//        stream.forEach(fruits->
//                System.out.println(fruits)); it is not agin iterate becasue it use only one time,it is closed

        stream
                .sorted()
                .map(fruits->fruits.length())
                .forEach(fruits-> System.out.println(fruits)); // it will first sort and than it map to it's length and after that it print mapped value means it' s length


    }
}



//As this no becasue it is functional interface (interface with one signature method)
interface Walkable {
    int walk(int steps);
}

