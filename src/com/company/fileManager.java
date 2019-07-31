package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class fileManager {
    public static List<statusNode> getStatusNode()
    {
        try {

            List<statusNode> s =new ArrayList<>();
            BufferedReader bf = new BufferedReader(new FileReader("src/userFile/uid785958.info"));
            String nextLine=bf.readLine();
            while(nextLine!=null) {

                String[] elem=nextLine.split("\\|");
                statusNode sNode = new statusNode();
                sNode.title=elem[0];
                sNode.language=elem[1];
                sNode.status=elem[2];
                sNode.runtime=Integer.parseInt(elem[3]);
                sNode.memory=Integer.parseInt(elem[4]);
                sNode.codeLength=Integer.parseInt(elem[5]);

                s.add(sNode);
                nextLine=bf.readLine();

            }
            return s;
        }
        catch (IOException e)
        {
            System.exit(0);
            return null;
        }

    }
}
