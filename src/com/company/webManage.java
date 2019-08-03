package com.company;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class webManage{

    public static List<Integer> getTemperatureList()
    {
        final String url="http://www.nmc.cn/publish/forecast/china.html";

        String ctx=webManage.readWeb(url);
        Pattern regexPatten = Pattern.compile("<div class=\"temp\">(.*?)</div>");
        Matcher matchGroup = regexPatten.matcher(ctx);

        List<Integer> arr =new ArrayList<>();
        String curr;
        while(matchGroup.find())
        {
            curr=webManage.replaceRegex( ctx.substring(matchGroup.start(),matchGroup.end()),"<.+?>","" ).trim();

            arr.add( Integer.parseInt(curr.substring(0,curr.length()-1)));
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

