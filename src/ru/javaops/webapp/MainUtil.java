package ru.javaops.webapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainUtil {
    public static void main(String[] args) {
//        System.out.println(Integer.valueOf(-1) == Integer.valueOf(-1));
//        System.out.println(Integer.valueOf(-1) == new Integer(-1));
//        int result = getInt();
//        System.out.println(result);

        System.out.println(minValue(new int[]{6, 3, 6, 2, 1, 8, 6, 7, 8, 5}));
        System.out.println(oddOrEven(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 1))));
    }

    private static Integer getInt() {
        return null;
    }

    private static int minValue(int[] values) {
        return Arrays.stream(values).distinct().sorted().reduce(0, (result, element) -> result * 10 + element);
        
    }

    private static List<Integer> oddOrEven(List<Integer> integers) {
        int sum = integers.stream().mapToInt(Integer::intValue).sum();
        return integers.stream().filter(item -> (sum % 2 == 0) == (item % 2 == 0)).collect(Collectors.toList());
    }
}
