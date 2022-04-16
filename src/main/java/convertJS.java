import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class convertJS {
    public static void main(String[] args) throws IOException
    {
        System.out.println(System.getProperty("user.dir"));

        try(FileReader fileReader = new FileReader("/Users/gaebabja/IdeaProjects/Mydev/src/main/resources/JS/test.txt"))
        {
            List<String> Data= makeData(fileReader);

            fileReader.close();

            List<String> output = new ArrayList<>();

            //TODO Converting JS TO XFDL

            File file = new File("/Users/gaebabja/IdeaProjects/Mydev/src/main/resources/XFDL/result.xfdl.js");
            if(!file.exists())
            {
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String strCode ="";
            for(int i=0;i< output.size();i++)
            {
                strCode+= output.get(i);
            }
            bufferedWriter.write(strCode);

            bufferedWriter.close();
            fileWriter.close();
        }
        catch(Exception e)
        {
            System.out.println("ㅍㅏ일 입출력오류");
        }
        finally {

        }

    }



    public static List<String> makeData(FileReader fileReader) throws IOException
    {
        List<String> lines = new ArrayList<>();
        int ch=0;
        String stmt="";

        while((ch=fileReader.read())!=-1)
        {
            if(ch!=13)
            {
                stmt+=(char)ch;
            }
            else
            {
                lines.add(stmt);
                stmt="";
            }
        }
        return lines;
    }


}
