public class readWebcontent{
	public static readWeb(){
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
        }
        catch (MalformedURLException e){
            System.out.println("Connect error");
            System.exit(0);
        }
        catch (IOException e){
            System.out.println("Input error");
            System.exit(0);
        }
	}
}