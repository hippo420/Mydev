import java.io.*;
import java.lang.module.FindException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class convertJS {



    public static void main(String[] args) throws IOException
    {
        System.out.println(System.getProperty("user.dir"));
        List<Metadata> metadata = new ArrayList<Metadata>();

        try(FileReader fileReader = new FileReader("/Users/gaebabja/IdeaProjects/Mydev/src/main/resources/JS/test.txt"))
        {
            List<String> Data= makeData(fileReader);

            //fileReader.close();
            metadata= extractKeyData(Data);
            String strdata = makeStr1(metadata.get(0).datasets,"D");
            String scode = makeStr(metadata.get(0).codes);
            String scomp = makeStr2(metadata.get(0).ucomps,metadata.get(0).eventInfos);
            List<String> forminfo = new ArrayList<String>();
            forminfo = makeStr3(metadata.get(0).forms,metadata.get(0).eventInfos);
            String formdata = forminfo.get(0);
            String laydata = forminfo.get(1);

            fileReader.close();
            List<String> outputs = new ArrayList<String>();

            //TODO Converting JS TO XFDL
            outputs=convertJSToXDFL(formdata,laydata, scode,strdata);

            //파일쓰기
            File file = new File("/Users/gaebabja/IdeaProjects/Mydev/src/main/resources/XFDL/result.xfdl.js");
            if(!file.exists())
            {
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String strCode ="";
            for(int i=0;i< outputs.size();i++)
            {
                strCode+= outputs.get(i)+"\n";
            }
            bufferedWriter.write(strCode);

            bufferedWriter.close();
//            fileWriter.close();
        }
//        catch(Exception e)
//        {
//            System.out.println("ㅍㅏ일 입출력오류"+e);
//        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e.getLocalizedMessage());
        }
        finally {

        }

    }




    public static List<String> readFile(String path)
    {
        List<String> stringList = new ArrayList<String>();

        return stringList;

    }
    public static void log(String str)
    {
        System.out.println(str);
    }
    private static List<String> convertJSToXDFL(String fd, String ld,String sc, String ds) throws IOException{
        List<String> results =new ArrayList<String>();

        log("convertJSToXDFL");
        try(
        FileReader fileReader = new FileReader("/Users/gaebabja/IdeaProjects/Mydev/src/main/resources/xfdlMacro/xfdlmcro.txt");
        )
        {
            //script
            //List<String> str1 =new ArrayList<String>();
            results = makeData(fileReader);
            fileReader.close();

            for(int i=0;i<results.size();i++)
            {
                if(results.get(i).indexOf("{forminfo}")>=0)
                {
                    String str= results.get(i).replace("{forminfo}",fd);
                    results.remove(i);
                    results.add(i,str);
                }
                if(results.get(i).indexOf("{layinfo}")>=0)
                {
                    String str= results.get(i).replace("{layinfo}",fd);
                    results.remove(i);
                    results.add(i,str);
                }
                //insert userscript into xdflmacro
                if(results.get(i).indexOf("{userScripts}")>=0)
                {
                    results.remove(i);
                    results.add(i,sc);
                }
                if(results.get(i).indexOf("{objects}")>=0)
                {
                    results.remove(i);
                    results.add(i,ds);
                }


                 // log(results.get(i));
            }
        }
        catch(Exception e)
        {
            System.out.println("매크로 에러");
        }
        return  results;
    }


    public static String makeStr(List<String> data)
    {
        String str="";
        for(int i =0;i< data.size();i++)
        {
            str+= data.get(i)+'\n';
        }
        return  str;
    }
    public static String DDaom(String value)
    {
        String str="";
        if(value.indexOf('"')>=0)
        {
            value=value.substring(1,value.length()-1);
        }
        //System.out.println(value);
        str+='"'+value+'"';
        return str;
    }

    public static  List<String> makeStr3(List<Form> data, List<EventInfo> data1)
    {
        List<String> strList = new ArrayList<String>();
        String str="";
        String strEvent="";
        for(int i =0;i<data1.size();i++)
            if(data.get(0).id.trim().equals(data1.get(i).compname))
                strEvent+=" "+data1.get(i).eventtype+"="+'"'+data1.get(i).eventname+'"';

        str+=" id=" +'"'+data.get(0).id+'"'+ " width=" + '"' + data.get(0).width+'"'+" height="+'"'+data.get(0).height+'"'+strEvent;
        strList.add(str);
        strList.add(" width=" + '"' + data.get(0).width+'"'+" height="+'"'+data.get(0).height+'"');
        return  strList;

    }
    public static  String makeStr2(List<UComp> data, List<EventInfo> data1)
    {
        String str="";
        List<Boolean> flag =new ArrayList<Boolean>();


        for(int i=0;i<data.size();i++)
        {
            int cnt=0;
            String strEvent="";
            for(int j=0;j<data1.size();j++)
            {
                String comp = '"'+data1.get(j).compname.trim()+'"';
                if(comp.trim().equals(DDaom(data.get(i).getId().trim())))
                {

                    strEvent+=" "+data1.get(j).eventtype+"="+'"'+data1.get(j).eventname+'"';
                }
            }

            str+="<"+data.get(i).getType()+" id ="+DDaom(data.get(i).getId());
            if(!"Tabpage".equals(data.get(i).getType()))
            {
                if(data.get(i).getLeft()!=null && !data.get(i).getLeft().equals(""))
                    str+=" left="+DDaom(data.get(i).getLeft());
                if(data.get(i).getBottom()!=null&& !data.get(i).getBottom().equals(""))
                    str+=" bottom="+DDaom(data.get(i).getBottom());
                if(data.get(i).getTop()!=null&& data.get(i).getTop().length()!=0)
                    str+=" top="+DDaom(data.get(i).getTop());
                if(data.get(i).getRight()!=null&& !data.get(i).getRight().equals(""))
                    str+=" right="+DDaom(data.get(i).getRight());
                if(data.get(i).getHeight()!=null&& !data.get(i).getHeight().equals(""))
                    str+=" height="+DDaom(data.get(i).getHeight());
                if(data.get(i).getMaxheight()!=null&& !data.get(i).getMaxheight().equals(""))
                    str+=" maxheight="+DDaom(data.get(i).getMaxheight());
                if(data.get(i).getMinheight()!=null&& !data.get(i).getMinheight().equals(""))
                    str+=" minheight="+DDaom(data.get(i).getMinheight());
                if(data.get(i).getWidth()!=null&& !data.get(i).getWidth().equals(""))
                    str+=" width="+DDaom(data.get(i).getWidth());
                if(data.get(i).getMaxwidth()!=null&& !data.get(i).getMaxwidth().equals(""))
                    str+=" maxwidth="+DDaom(data.get(i).getMaxwidth());
                if(data.get(i).getMinwidth()!=null&& !data.get(i).getMinwidth().equals(""))
                    str+=" minwidth="+DDaom(data.get(i).getMinwidth());
            }
            if(data.get(i).getInfo()!=null&& !data.get(i).getInfo().equals(""))
                str+=" "+data.get(i).getInfo()+strEvent;
            str+="/>\n";
        }
        log("UI comp str생성");
        log(str);
        return str;
    }

    public  static  String makeStr1(List<Dataset> data, String type)
    {
        String str="";
        switch (type)
        {
            case "D":
                String name="", event="", info="";


                System.out.println(data.size());
                for(int i=0;i<data.size();i++)
                {
                    name = data.get(i).name;
                    info = data.get(i).colInfo;
                    String tempdata="<Dataset id = "+'"'+name+'"'+" "+event+"> \n" +info+" \n</Dataset>";
                    str+=tempdata.replace("\\","");
                    str+="\n";
                }

                break;
            case "C":

                break;
        }
        return str;
    }



    public static List<EventInfo> extractEventData(List<String> data)
    {
        List<EventInfo> eventInfoList = new ArrayList<EventInfo>();

        boolean flag =false;
        for(int i=data.size()-1;i>=0;i--)
        {
            String compname, eventtype,eventname;
            if(data.get(i).indexOf("addEventHandler")>=0)
            {
                compname = data.get(i).substring(0,data.get(i).indexOf("addEventHandler")-1);
                compname = compname.substring(compname.lastIndexOf('.')+1,compname.length());

                eventtype=data.get(i).substring(data.get(i).indexOf("(")+2,data.get(i).indexOf(',')-1);
                eventname=data.get(i).substring(data.get(i).indexOf(",this.")+6,data.get(i).lastIndexOf(','));
                if("this".equals(compname))
                    compname= eventname.substring(0,eventname.lastIndexOf('_'));
                System.out.println(compname+", "+eventname+", "+eventtype);
                eventInfoList.add(new EventInfo(compname,eventtype,eventname));
            }

        }
        return eventInfoList;
    }

    public static List<Metadata> extractKeyData(List<String> data)
    {
        List<Metadata> md = new ArrayList<Metadata>();
        System.out.println("실행..."+data.size());
        List<Form> formList=new ArrayList<Form>();
        List<Dataset> datasetList = new ArrayList<Dataset>();
        //List<Comp> compList=new ArrayList<Comp>();
        List<UComp> uCompList = new ArrayList<UComp>();
        List<String> sourcecode = new ArrayList<String>();
        List<EventInfo> eventInfoList = new ArrayList<EventInfo>();
        sourcecode=extractCode(data);
        eventInfoList=extractEventData(data);
        String keyword = "new ";
        int codeidx=0;
        for(int i=0;i<data.size();i++)
        {
            //컴포넌트 정보
            if(data.get(i).indexOf("this.on_create = function()")>=0)
            {
                String formid="";
                String fWidth="";
                String fHeight="";
                String fInfo="";
                int j=i;
                while (true)
                {
                    int idx=1;

                    System.out.println("j:"+j);
                    if(j==data.size()||data.get(j).indexOf("Object(Dataset, ExcelExportObject) Initialize")>=0) break;

                    if(data.get(j).indexOf("set_name")>=0)
                    {
                        formid=data.get(j).substring(data.get(j).indexOf('"')+1,data.get(j).lastIndexOf('"'));

                    }
                    else if(data.get(j).indexOf("set_")>=0)
                    {
                        String key,value;
                        key = data.get(j).substring(data.get(j).indexOf("set_")+4,data.get(j).indexOf('('));
                        value=data.get(j).substring(data.get(j).indexOf('(')+1,data.get(j).indexOf(')'));
                        System.out.println(key+" "+value);
                        fInfo+=" "+key+"="+value;
                    }
                    else if(data.get(j).indexOf("_setFormPosition")>=0)
                    {
                        String str = data.get(j).substring(data.get(j).indexOf('(')+1,data.get(j).indexOf(')'));
                        String[] tmp=str.split(",");
                        fWidth=tmp[0];
                        fHeight=tmp[1];
                    }

                    j++;
                }
                formList.add(new Form(formid,fWidth,fHeight,fInfo));

            }
            else if(data.get(i).indexOf(keyword)>=0)
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
                    if(data.get(i).indexOf("obj = new Layout")>=0)
                        continue;
                    int idx=1;
                    int j=i;
                    if(j==data.size()) break;
                    String compname;
                    String name;
                    String info="";
                    String parents="this";
                    compname = data.get(i).substring(data.get(i).indexOf("new")+4,data.get(i).indexOf('('));
                    String tempParam = data.get(i).substring(data.get(i).indexOf('(')+1,data.get(i).indexOf(')'));

                    String[] oParam ={"","","","","",""
                                     ,"","","","","",""};

                    name = data.get(i).substring(data.get(i).indexOf('"')+1,data.get(i).indexOf(',')-1);
                    if(data.get(i).indexOf("Dataset")==-1)
                    {
                        if(data.get(i).indexOf("Layout")>=0)
                            continue;
                        String[] oParamTemp={};
                        oParamTemp= tempParam.split(",");
                        for(int t=0;t<oParamTemp.length;t++)
                        {
                            if("null".equals(oParamTemp[t]))
                                oParam[t] = "";
                            else
                                oParam[t]=oParamTemp[t];
                        }
                    }
                    while(true)
                    {
                        if(j==data.size()-1) break;

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
                        if ((data.get(j).indexOf("addChild") >= 0&&data.get(j).indexOf("addChild")>4)
                        ||(data.get(j).indexOf("addLayout") >= 0&&data.get(j).indexOf("addLayout")>4)) {

                            if(data.get(j).indexOf("addChild") >= 0)
                                parents = data.get(j).substring(0, data.get(j).indexOf(".addChild"));
                            else
                                parents = data.get(j).substring(0, data.get(j).indexOf(".addLayout"));
                            parents.replace(" ","" );

                            break;
                        }
                    }
                    //System.out.println("comp: " + compname);
                    //System.out.println("name: " + name);
                    //System.out.println("info: " + info);
                    //System.out.println("parents: " + parents);
                    //컴ㅁ포넌트 set_설정값을 어떻게 저장할 것인가........
                   // compList.add(new Comp(compname,name,info,parents,null,null,null,null));
                    uCompList.add(new UComp(compname,oParam[0],oParam[1],oParam[2],oParam[3],oParam[4],oParam[5],oParam[6],oParam[7]
                                                    ,oParam[8],oParam[9],oParam[10],info,oParam[11] ));
                }else
                    continue;

                //

            }

        }

        md.add(new Metadata(formList,datasetList,uCompList,eventInfoList,sourcecode));

    return  md;


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
