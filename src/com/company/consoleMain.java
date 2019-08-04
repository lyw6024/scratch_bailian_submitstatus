package com.company;

import java.util.*;


public class consoleMain {
    public static void main(String[] argv)
    {

    	Map<String,Integer>weatherMaps= webManage.getWeatherMap();
        
        Set<String> lanSet=weatherMaps.keySet();
        for(String it :lanSet)
        {
            System.out.printf("%s,%d\n",it,weatherMaps.get(it));
        }

    }
}
