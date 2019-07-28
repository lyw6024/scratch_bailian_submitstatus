package com.company;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class webManage{
    public static String replaceRegex(String rawMessage,String regex,String target)
    {
        Pattern regexPatten = Pattern.compile(regex);
        Matcher matchGroup = regexPatten.matcher(rawMessage);
        if(matchGroup.find())
        {
            //TODO: 1
        }
        return ;
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