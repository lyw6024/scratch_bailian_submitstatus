package com.company;

public class consoleMain {
    public static void main(String[] argv)
    {
        String url ="http://openjudge.cn/user/785958/?page=2";
        String rawMsg=webManage.readWeb(url);
        String tableContent= webManage.matchRegex(rawMsg,"<div class=\"recently-submit\">(.*?)</div>");
        System.out.println(tableContent.replace("<[^>]+>","\n"));
    }
}
