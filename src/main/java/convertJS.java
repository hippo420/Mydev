import java.io.*;

public class convertJS {
    public static void main(String[] args) throws IOException
    {
        System.out.println(System.getProperty("user.dir"));
        try(FileReader fileReader = new FileReader("/Users/gaebabja/IdeaProjects/Mydev/src/main/resources/JS/test.txt"))
        {


            int ch;
            while((ch=fileReader.read())!=-1)
            {
                System.out.print((char) ch);

            }
        }
        catch(Exception e)
        {
            System.out.println("ㅍㅏ일 입출력오류");
        }
        finally {

        }

    }


}
