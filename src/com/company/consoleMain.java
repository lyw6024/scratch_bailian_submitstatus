package com.company;


import java.util.ArrayList;
import java.util.List;

public class consoleMain {
    public static void main(String[] argv)
    {

        List <statusNode> statusList,currLst;
        statusList=new ArrayList<>();

        currLst = webManage.generator("http://openjudge.cn/user/785958/");
        for (statusNode it : currLst)
        {
            statusList.add(it);
        }

/*
        for(int i=2;i<=16;i++) {
            currLst = webManage.generator("http://openjudge.cn/user/785958/?page="+i);
            for (statusNode it : currLst)
            {
                statusList.add(it);
            }
        }

 */

        System.out.println(statusList.size());
    }
}
