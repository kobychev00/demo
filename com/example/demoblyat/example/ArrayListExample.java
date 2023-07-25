package com.example.demoblyat.example;

import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {
        Integer[] numbersArray = {1, 2, 3};
        List<Integer> numbersList = new ArrayList<>(Arrays.asList(9, 2, 3, 5));
        Map<String, Integer> numbersMap = new HashMap<>(Map.of("four", 4, "five", 5));
        numbersMap.put("two", 2);
        Set<Integer> numbersSet = new HashSet<>(List.of(1, 2, 40, 12));



        /* Получение значения элемента по ключу */
        System.out.println(numbersArray[0]);
        System.out.println(numbersList.get(0));
        numbersMap.get("two");

        /* Запись значения в элемент*/
        numbersArray[1] = 10;
        numbersList.set(1, 10);
        numbersMap.put("one", 1);

        /* Получение размера */
        final int length = numbersArray.length;
        numbersList.size();
        numbersMap.size();
        numbersSet.size();


        System.out.println(numbersArray.length);
        System.out.println(numbersList.size());

        /* Получение элемента в конец коллекции */

        numbersList.add(56);
        numbersMap.put("three", 3);
        numbersSet.add(256);

        /* Получение строки с содержимым коллекции */

        Arrays.toString(numbersArray);
        numbersList.toString();
        numbersMap.toString();
        numbersSet.toString();

        /* Проверить наличие элемента в колекции */

        numbersList.contains(56);
        numbersMap.containsValue(3);
        numbersSet.contains(45);

        System.out.println(Arrays.toString(numbersArray));
        System.out.println(numbersList);
        System.out.println(numbersMap);
        System.out.println(numbersSet);
    }
}
