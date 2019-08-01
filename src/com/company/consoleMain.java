package com.company;

import java.util.*;

public class consoleMain {
    public static void main(String[] argv)
    {
        /*
        List <statusNode> statusList,currLst;
        statusList=new ArrayList<>();

        currLst = webManage.generator("http://openjudge.cn/user/785958/");
        for (statusNode it : currLst)
        {
            statusList.add(it);
        }


        for(int i=2;i<=16;i++) {
            currLst = webManage.generator("http://openjudge.cn/user/785958/?page="+i);
            for (statusNode it : currLst)
            {
                statusList.add(it);
            }
        }


        System.out.println(statusList.size());

        for(statusNode it:statusList)
        {
            System.out.printf("%s|%s|%s|%d|%d|%d\n",it.title,it.language,it.status,it.runtime,it.memory,it.codeLength);
        }


         */
        List<statusNode> sList= fileManager.getStatusNode();
        Map<String,Integer> AllLanguageCollection=new HashMap<>();
        Map<String,Integer> AcLanguageCollection=new HashMap<>();
        Integer AcCount,totalCount=0;
        AcCount=0;

        for(statusNode it : sList)
        {
            totalCount+=1;
            if (AllLanguageCollection.containsKey(it.language)) {
                AllLanguageCollection.put(it.language, AllLanguageCollection.get(it.language) + 1);
            } else {
                AllLanguageCollection.put(it.language, 1);
            }

            if(it.status.equals("Accepted")) {
                AcCount+=1;
                if (AcLanguageCollection.containsKey(it.language)) {
                    AcLanguageCollection.put(it.language, AcLanguageCollection.get(it.language) + 1);
                } else {
                    AcLanguageCollection.put(it.language, 1);
                }
            }
        }

        Set<String> lanSet=AllLanguageCollection.keySet();
        for(String it :lanSet)
        {
            System.out.printf("%s,%.2f%%\n",it,(float)100*AllLanguageCollection.get(it)/totalCount);
        }

        System.out.println();
        lanSet=AcLanguageCollection.keySet();
        for(String it :lanSet)
        {
            System.out.printf("%s,%.2f%%\n",it,(float)100*AcLanguageCollection.get(it)/totalCount);
        }

    }

}
