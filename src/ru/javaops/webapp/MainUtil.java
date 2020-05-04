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
        int result = 0;
        int[] arr = Arrays.stream(values).distinct().sorted().toArray();
        for (int item : arr) {
            result = result * 10 + item;
        }
        return result;
    }

    private static List<Integer> oddOrEven(List<Integer> integers) {
        int sum = integers.stream().mapToInt(Integer::intValue).sum();
        if (sum % 2 == 0)
            return integers.stream().filter(item -> item % 2 == 0).collect(Collectors.toList());
        else
            return integers.stream().filter(item -> item % 2 != 0).collect(Collectors.toList());
    }
}
