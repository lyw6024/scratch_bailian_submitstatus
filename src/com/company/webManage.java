package com.company;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class webManage{
    public static List<String> regexPattern2Lst(String rawMessage,String regex)
    {
        List<String>  arr=new ArrayList<>();
        Pattern regexPatten = Pattern.compile(regex);
        Matcher matchGroup = regexPatten.matcher(rawMessage);
        System.out.println(matchGroup.groupCount());
        if(matchGroup.find())
        {
            for(int i=1;i<matchGroup.groupCount();i++)
                arr.add(matchGroup.group(i));
        }
        else
        {
            arr.add("");
        }
        return arr;
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