package com.company;

import java.util.*;


public class consoleMain {
    public static void main(String[] argv)
    {

        List<Integer> arr=webManage.getTemperatureList();
        for(Integer it :arr)
        {
            System.out.printf("%d,",it);
        }
        System.out.println();

    }
}
