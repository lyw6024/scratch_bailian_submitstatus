package com.company;

import java.util.ArrayList;
import java.util.List;

public class consoleMain {
    public static void main(String[] argv)
    {
        String url ="http://openjudge.cn/user/785958/?page=2";
        String rawMsg=webManage.readWeb(url);
        String tableContent= webManage.matchRegex(rawMsg,"<div class=\"recently-submit\">(.*?)</div>");

        String rawTable=webManage.replaceRegex(tableContent,"\\s","");
        System.out.println(rawTable);

        List<String> arr=webManage.regexPattern2Lst(rawTable,"<tr>(.*?)</tr>");
        for(String it :arr)
        {
            System.out.println(it);
        }
    }
}
