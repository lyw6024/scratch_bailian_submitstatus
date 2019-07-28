package com.company;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class webManage{
    public static List<statusNode> generator(String url)
    {

        String rawMsg=webManage.readWeb(url);
        String tableContent= webManage.matchRegex(rawMsg,"<div class=\"recently-submit\">(.*?)</div>");

        Pattern rawTablePatten=Pattern.compile("<tbody>(.*?)</tbody>");
        Matcher rawTableMatcher=rawTablePatten.matcher(tableContent);
        String rawTable="";
        if(rawTableMatcher.find())
            rawTable=rawTableMatcher.group(0);

        List<String>  arr=new ArrayList<>();

        Pattern regexPatten = Pattern.compile("(<tr>|<tr class=\"alt\">)(.*?)</tr>");
        Matcher matchGroup = regexPatten.matcher(rawTable);

        while(matchGroup.find())
        {
            arr.add(rawTable.substring(matchGroup.start(),matchGroup.end()));
        }
        String toSolveValue;
        List <statusNode> statusList =new ArrayList<>();
        statusNode sn1;
        for(String it : arr)
        {
            sn1=new statusNode();
            Pattern regexTitle = Pattern.compile("<td class=\"title\"><a .+?>(.*?)</a></td>");
            Matcher matcherTitle = regexTitle.matcher(it);
            if(matcherTitle.find())
                sn1.title=webManage.replaceRegex(matcherTitle.group(0),"<.+?>","");

            Pattern regexStatus = Pattern.compile("<td class=\"result\"><a .+?>(.*?)</a></td>");
            Matcher matcherStatus = regexStatus.matcher(it);
            if(matcherStatus.find())
                sn1.status=webManage.replaceRegex(matcherStatus.group(0),"<.+?>","");

            Pattern regexMem = Pattern.compile("<td class=\"memory\">(.*?)</td>");
            Matcher matcherMem = regexMem.matcher(it);
            if(matcherMem.find()) {
                toSolveValue = webManage.replaceRegex(matcherMem.group(0), "<.+?>", "");
                if(!toSolveValue.isBlank()) {
                    toSolveValue = toSolveValue.substring(0, toSolveValue.length() - 2);
                    sn1.memory = Integer.parseInt(toSolveValue);
                }
            }
            Pattern regexTime = Pattern.compile("<td class=\"spending-time\">(.*?)</td>");
            Matcher matcherTime = regexTime.matcher(it);
            if(matcherTime.find()) {
                toSolveValue= webManage.replaceRegex(matcherTime.group(0), "<.+?>", "");
                if(!toSolveValue.isBlank()) {
                    toSolveValue = toSolveValue.substring(0, toSolveValue.length() - 2);
                    sn1.runtime = Integer.parseInt(toSolveValue);
                }
            }

            Pattern regexCdLength = Pattern.compile("<td class=\"code-length\">(.*?)</td>");
            Matcher matcherCdLength = regexCdLength.matcher(it);
            if(matcherCdLength.find()) {
                toSolveValue= webManage.replaceRegex(matcherCdLength.group(0), "<.+?>", "");

                toSolveValue = toSolveValue.substring(0, toSolveValue.length() - 2);
                sn1.codeLength = Integer.parseInt(toSolveValue);

            }

                Pattern regexLang = Pattern.compile("<td class=\"language\"><a .+?>(.*?)</a></td>");
            Matcher matcherLang = regexLang.matcher(it);
            if(matcherLang.find())
                sn1.language=webManage.replaceRegex(matcherLang.group(0),"<.+?>","" );

            statusList.add(sn1);
        }
        return statusList;
    }

    public static String replaceRegex(String rawMessage,String regex,String target)
    {
        Pattern regexPatten = Pattern.compile(regex);
        Matcher matchGroup = regexPatten.matcher(rawMessage);
        StringBuffer res = new StringBuffer();
        while(matchGroup.find()){
            matchGroup.appendReplacement(res,target);
        }
        matchGroup.appendTail(res);
        return res.toString();
    }

    public static String matchRegex(String rawMessage,String regex)
    {
        Pattern meanRegex = Pattern.compile(regex);
        Matcher meanGp = meanRegex.matcher(rawMessage);
        if (meanGp.find()) {
            return meanGp.group(1);
        }
        else
            {
            return "";
        }
    }
	public static String readWeb(String strUrl){
        String webpageCtx;
		try {
            URL url = new URL(strUrl);
            InputStream is = url.openStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bf = new BufferedReader(isr);
            String str;
            webpageCtx = "";
            while ((str = bf.readLine())!=null){
                webpageCtx += str;
            }
            bf.close();
            isr.close();
            is.close();
            return webpageCtx;
        }
        catch (MalformedURLException e){
            System.out.println("Connect error");
            return "";
        }
        catch (IOException e){
            System.out.println("Input error");
            return "";
        }
	}
}

