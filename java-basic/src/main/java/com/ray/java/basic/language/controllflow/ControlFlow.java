package com.ray.java.basic.language.controllflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControlFlow {

    private int[] intArray = {1, 2, 3, 4, 5};
    private List<String> stringArrayList = new ArrayList<String>();
    private Map<String, String> stringMap = new HashMap<String, String>();

    public ControlFlow() {
        stringArrayList.add("China");
        stringArrayList.add("Japan");
        stringArrayList.add("England");
        stringMap.put("China", "Beijing");
        stringMap.put("Japan", "Toyoky");
        stringMap.put("England", "London");
    }

    public void forLoop() {
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    public void forLoopContinue() {
        for (int i = 0; i < intArray.length; i++) {
            if (i == 2) continue;
            System.out.println(intArray[i]);
        }
    }

    public void forLoopBreak() {
        for (int i = 0; i < intArray.length; i++) {
            if (i == 2) break;
            System.out.println(intArray[i]);
        }
    }

    public void forEach() {
        for	(String country : stringArrayList) {
            System.out.println(country);
        }
    }

    public void whileLoop() {
        int i = 0;
        while(i < stringArrayList.size()) {
            System.out.println(stringArrayList.get(i));
            i++;
        }
    }

    public void doWhildLoop() {
        int i = 0;
        do {
            System.out.println(stringArrayList.get(i));
            i++;
        } while (i <= stringArrayList.size());
    }

    public void ifElseStates() {
        if (intArray.length > 0) {
            System.out.println("int array length > 0");
        } else if (intArray.length > 10) {
            System.out.println("int array length > 10");
        } else {
            System.out.println("int array length > 0 and < 10");
        }
    }

    public void swithStates() {
        int index = 5;
        switch (index) {
            case 1:
                System.out.println("index = 1");
                break;
            case 5:
                System.out.println("index = 5");
                break;
            default:
                System.out.println("index = unknown");
                break;
        }
    }
}
