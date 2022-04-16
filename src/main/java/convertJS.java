import java.io.*;
import java.lang.module.FindException;
import java.util.ArrayList;
import java.util.List;

public class convertJS {

    public static void main(String[] args) throws IOException
    {
        System.out.println(System.getProperty("user.dir"));

        try(FileReader fileReader = new FileReader("/Users/gaebabja/IdeaProjects/Mydev/src/main/resources/JS/test.txt"))
        {
            List<String> Data= makeData(fileReader);

            //fileReader.close();
            extractKeyData(Data);
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

    public static void extractEventData(List<String> data)
    {
        List<EventInfo> eventInfoList = new ArrayList<EventInfo>();

        boolean flag =false;
        for(int i=data.size()-1;i>=0;i--)
        {
            String compname, eventtype,eventname;
            if(data.get(i).indexOf("addEventHandler")>=0)
            {
                compname = data.get(i).substring(0,data.get(i).indexOf("addEventHandler")-1);
                eventtype=data.get(i).substring(data.get(i).indexOf('"')+1,data.get(i).lastIndexOf('"'));
                eventname=data.get(i).substring(data.get(i).indexOf(",this.")+6,data.get(i).lastIndexOf(','));
                System.out.println(compname+", "+eventtype+", "+eventname);
                eventInfoList.add(new EventInfo(compname,eventtype,eventname));
            }

        }
    }

    public static void extractKeyData(List<String> data)
    {
        System.out.println("실행..."+data.size());
        List<Dataset> datasetList = new ArrayList<Dataset>();
        List<Comp> compList=new ArrayList<Comp>();
        List<String> sourcecode = new ArrayList<String>();
        List<EventInfo> eventInfoList = new ArrayList<EventInfo>();
        sourcecode=extractCode(data);
        extractEventData(data);
        String keyword = "new ";
        int codeidx=0;
        for(int i=0;i<data.size();i++)
        {
            if(data.get(i).indexOf(keyword)>=0)
            {
                //데이터셋정보
                if(data.get(i).indexOf("new Dataset")>=0)
                {
                    String name;
                    String info;
                    name = data.get(i).substring(data.get(i).indexOf('"')+1,data.get(i).lastIndexOf('"'));
                    info = data.get(i+1).substring(data.get(i).indexOf('"'),data.get(i+1).lastIndexOf('"'));
                    datasetList.add(new Dataset(name, info));
                    //System.out.println(name+" : "+info);
                }else if(data.get(i).indexOf("registerScript")>=0)
                {
                    break;

                    //Regist UI Components Event
                }
                else if(data.get(i).indexOf("obj = new")>=0)
                {
                    int idx=1;
                    int j=i;
                    String compname;
                    String name;
                    String info="";
                    String parents="this";
                    compname = data.get(i).substring(data.get(i).indexOf("new")+4,data.get(i).indexOf('('));
                    name = data.get(i).substring(data.get(i).indexOf('"')+1,data.get(i).indexOf(',')-1);
                    while(true)
                    {
                        if(j==data.size()) break;


                        j+=1;
                        if(data.get(j).indexOf("obj = new")>=0)
                            break;

                        if(data.get(j).indexOf("set_")>=0)
                        {
                            String key,value;
                            key = data.get(j).substring(data.get(j).indexOf("set_")+4,data.get(j).indexOf('('));
                            value=data.get(j).substring(data.get(j).indexOf('(')+1,data.get(j).indexOf(')'));
                            //System.out.println(key+" "+value);
                            info+=" "+key+"="+value;
                        }
                        if (data.get(j).indexOf("addChild") >= 0&&data.get(j).indexOf("addChild")>4) {


                            parents = data.get(j).substring(0, data.get(j).indexOf(".addChild"));
                            parents.replace(" ","" );

                            break;
                        }
                    }
//                    System.out.println("comp: " + compname);
//                    System.out.println("name: " + name);
//                    System.out.println("info: " + info);
//                    System.out.println("parents: " + parents);
                    compList.add(new Comp(compname,name,info,parents));
                }else
                    continue;

                //

            }

        }

        List<String> keydata = new ArrayList<>();




    }
    public static List<String> extractCode(List<String> data)
    {
        List<String> sc = new ArrayList<String>();
        boolean flag=false;
        for(int i=0;i<data.size();i++)
        {//Regist UI Components Event
            if(data.get(i).indexOf("Regist UI Components Event")>=0)
                break;
            if(flag)
            {
                sc.add(data.get(i));
                //System.out.println(data.get(i));
            }
            if(data.get(i).indexOf("registerScript")>=0) {
                flag=true;
                continue;
            }
        }
        return sc;
    }
    public static List<String> makeData(FileReader fileReader) throws IOException
    {
        List<String> lines = new ArrayList<>();
        int ch=0;
        String stmt="";

        while((ch=fileReader.read())!=-1)
        {
            if((char)ch!='\n')
            {
                stmt+=(char)ch;
            }
            else
            {
                lines.add(stmt.trim());
                stmt="";
            }
        }
        return lines;
    }


}
