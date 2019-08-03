

<%@ page language="java" pageEncoding="utf-8" %>

<html>
<head>
	<meta charset="utf-8">
	<title>translate
	</title>
	</head>
	<body>
<%@page import = "java.io.*"%>
<%@page import = "java.net.*"%>
<%@page import = "java.util.*"%>
<%@page import = "java.util.regex.*"%>

<%!

    public static List<Integer> getTemperatureList()
    {
        final String url="http://www.nmc.cn/publish/forecast/china.html";

        String ctx=readWeb(url);
        Pattern regexPatten = Pattern.compile("<div class=\"temp\">(.*?)</div>");
        Matcher matchGroup = regexPatten.matcher(ctx);

        List<Integer> arr =new ArrayList<>();
        String curr;
        while(matchGroup.find())
        {

            curr=replaceRegex( ctx.substring(matchGroup.start(),matchGroup.end()),"<.+?>","" ).trim();
	//		arr.add( curr );

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
//            return URLDecode.decode(URLEncode.encode(webpageCtx,"utf-8"),"gbk");
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



%>
	<%=readWeb("http://malic.xyz/")%>
<%-- List<Integer> arr=getTemperatureList(); %>

<p>size=
<%=arr.size()%>
<%
for(Integer it:arr)
	out.println(""+it.toString()+"<br>");
--%>
</p>
</body>

</html>