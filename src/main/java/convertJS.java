import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class convertJS {

	

    public static void main(String[] args) throws IOException
    {
    	String path=Constants.PATH;
    	String outPath=Constants.OUTPATH;
        List<String> fileList = new ArrayList<String>(fileList = extractFilePath.freader());

        for(String vo : fileList)
        {

            String fileNicname= vo.substring(vo.lastIndexOf("JS")+3,vo.indexOf('.'));

            try(FileReader fileReader = new FileReader(vo))
            {
                List<String> Data= makeData(fileReader);
                fileReader.close();

                List<Metadata> metadata = new ArrayList<Metadata>(metadata= extractKeyData(Data));

                String strdata = makeStr1(metadata.get(0).datasets,"D");
                String scode = makeStr(metadata.get(0).codes);
                List<String> scomp = new ArrayList<String>(makeStr2(metadata.get(0).ucomps,metadata.get(0).eventInfos));
                List<String> forminfo = new ArrayList<String>(makeStr3(metadata.get(0).forms,metadata.get(0).eventInfos));
                String formdata = forminfo.get(0);
                String laydata = forminfo.get(1);
                String binddata = makeStr5(metadata.get(0).binds);
                String sComLay = makeStr4(metadata.get(0).depths,scomp,metadata.get(0).ucomps);
                List<String> tmpoutputs = new ArrayList<String>();
                List<String> outputs = new ArrayList<String>();
                //TODO Converting JS TO XFDL
                tmpoutputs=convertJSToXDFL(formdata,laydata, scode,strdata,sComLay,binddata);
                
                outputs = filterDetail(metadata.get(0).ucomps, tmpoutputs);

                //파일쓰기
                File file = new File(outPath+fileNicname+".xfdl");
                if(!file.exists())
                {
                    file.createNewFile();
                }

                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                String strCode ="";
                for(int i=0;i< outputs.size();i++)
                    strCode+= outputs.get(i)+"\n";

                bufferedWriter.write(strCode);
                bufferedWriter.close();
                System.out.println("["+fileNicname+"]...파일 생성 완료");
            }
            catch(Exception e)
            {
                System.out.println("ㅍㅏ일 입출력오류"+e);
            }
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
    private static List<String> filterDetail(List<UComp> comp, List<String> lines )
    {
    	List<String> divName = new ArrayList<String>();
    	List<String> results =new ArrayList<String>();
    	
    	for(UComp vo: comp)
    	{
    		if("Div".equals(vo.getType()))
    		{
    			String name =vo.getId().substring(1,vo.getId().lastIndexOf('"')); 
    			divName.add(name.concat("detail"));
    			System.out.println(name.concat("detail"));
    		}
    	}
 
    	for(String co : divName)
    	{
    		
    		for(int i =0;i<lines.size();i++)
        	{
        		if(lines.get(i).indexOf(co)>=0 /*&& lines.get(i).trim().length()==co.trim().length()*/)
        		{
        			String tmp = lines.get(i).replace(co, "");
        			lines.remove(i);
        			lines.add(i, tmp);
        			//System.out.println(lines.get(i)+"의 line크기: "+lines.get(i).trim().length()+", co크기: "+co.trim().length());
        			//lines.remove(i);
        		}
        			
        	}
    	}
    	
    		
    	return results=lines;
    }
    private static List<String> convertJSToXDFL(String fd, String ld,String sc, String ds, String scl,String bd) throws IOException{
        List<String> results =new ArrayList<String>();


        try(FileReader fileReader = new FileReader(Constants.MACROPATH))
        {

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
                    String str= results.get(i).replace("{layinfo}",ld);
                    results.remove(i);
                    results.add(i,str);
                }
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
                if(results.get(i).indexOf("{layouts}")>=0)
                {
                    results.remove(i);
                    results.add(i,scl);
                }
                if(results.get(i).indexOf("{binds}")>=0)
                {
                    results.remove(i);
                    results.add(i,bd);
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("매크로 입출력 에러.......f");
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
    public static String makeStr5(List<BindItem> data)
    {
        String str="";
        for(BindItem vo: data)
        	str+="<Binditem id="+DDaom(vo.id)+" compid="+DDaom(vo.compid)+" propid="+DDaom(vo.propid)+" datasetid="+DDaom(vo.datasetid)+" columnid="+ DDaom(vo.columnid)+"/>\n";
        
        return  str;
    }
    
    public static String DDaom(String value)
    {
        String str="";
        if(value.indexOf('"')>=0)
        {
            value=value.substring(1,value.length()-1);
        }

        str+='"'+value+'"';
        return str;
    }
    public static  String makeStr4(List<String> depth, List<String> comp,List<UComp> ucomp) {
        List<String> dep = new ArrayList<String>();
        List<String> divname = new ArrayList<String>();
        String str = "";
        depth.remove(0);
        for (int i=0;i< depth.size();i++)
        {

            if (depth.get(i).indexOf(',') >= 0)
            {
                String[] str1 = depth.get(i).split(",");
                for (int j=0;j< str1.length;j++)
                    dep.add(str1[j]);
            }
            else
                dep.add(depth.get(i));
        }
        for(int i=0;i<ucomp.size();i++)
        {
            if(ucomp.get(i).getType().equals("Div"))
            {
            	//divname.add(ucomp.get(i).getId().substring(1,ucomp.get(i).getId().lastIndexOf('"')));
                if(ucomp.get(i).getParents().equals("this"))
                {
                    str+=comp.get(i)+"\n";
                }
                else
                {
                    if(str.indexOf(ucomp.get(i).parents)>=0)
                    {
                        str=str.replace(ucomp.get(i).parents+"detail",comp.get(i));
                    }
                }
            }else{
                if(ucomp.get(i).getParents().equals("this"))
                {
                    str+="\n"+comp.get(i);
                }
            }
        }

        for(int i=0;i<ucomp.size();i++)
        {
            if(ucomp.get(i).parents.equals("this")==false) {
                String tmp = "";
                if (ucomp.get(i).getType().trim().equals("Tab")) {

                    if (str.indexOf(ucomp.get(i).parents) >= 0) {

                        tmp = str.replace(ucomp.get(i).parents + "detail", comp.get(i));
                        str = tmp;
                        tmp = "";
                    }

                } else if (ucomp.get(i).getType().trim().equals("Tabpage")) {

                    if (str.indexOf(ucomp.get(i).parents + "detail") >= 0) {
                        str = str.replace(ucomp.get(i).parents + "detail", comp.get(i) + ucomp.get(i).parents + "detail");
                    }
                } else {
                    if (str.indexOf(ucomp.get(i).parents + "detail") >= 0) {
                        str = str.replace(ucomp.get(i).parents + "detail", comp.get(i) + ucomp.get(i).parents + "detail");
                    }
                }
            }
        }
        
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
    public static  List<String> makeStr2(List<UComp> data, List<EventInfo> data1)
    {
        List<String> stringList = new ArrayList<String>();
        String str="";
        List<Boolean> flag =new ArrayList<Boolean>();

        for(int i=0;i<data.size();i++)
        {
            int cnt=0;
            String strEvent="";
            String rDataset="";
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
            	if("BindItem".equals(data.get(i).getType()))
                {
                	str+=" compid="+DDaom(data.get(i).getLeft())+" propid="+DDaom(data.get(i).getTop())+" datasetid="+DDaom(data.get(i).getHeight())+" columnid="+ DDaom(data.get(i).getWidth());
                }
            	else
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
            }
            
            
            if(data.get(i).getInfo()!=null&& !data.get(i).getInfo().equals(""))
            {
                String tmpInfo="";
                if(data.get(i).getType().equals("Grid"))
                {
                    tmpInfo =data.get(i).getInfo().substring(0,data.get(i).getInfo().indexOf("Contents"));
                }
                else if(data.get(i).getType().equals("Radio"))
                {
                	
                	String innderdataset =data.get(i).getId().substring(1,data.get(i).getId().length()-1)+"_innerdataset";
                	
                	if(data.get(i).getInfo().indexOf(innderdataset)>=0)
                	{
                		
                		tmpInfo = data.get(i).getInfo().substring(0,data.get(i).getInfo().indexOf("Contents"));
                		rDataset = data.get(i).getInfo().substring(data.get(i).getInfo().indexOf("Contents")+10,data.get(i).getInfo().lastIndexOf("</Rows>")+"</Rows>".length());
                		rDataset="<Dataset id="+'"'+"innerdataset"+'"'+">\n"+rDataset+"\n</Dataset>";
                	}else {
                		tmpInfo= data.get(i).getInfo();
                	}
                }
                else
                {
                    tmpInfo=data.get(i).getInfo();
                }

                //log(tmpInfo);
                str+=" "+tmpInfo+strEvent;
            }
            if(data.get(i).getType().trim().equals("Tab"))
            {
                str+=">\n<Tabpages>\n"+data.get(i).getId().substring(1,data.get(i).getId().length()-1)+"detail\n</Tabpages>\n</Tab>";
            }
            else
            {
                if(data.get(i).getType().trim().equals("Div"))
                {
                    str+=">\n<Layouts>\n<Layout>\n"+data.get(i).getId().substring(1,data.get(i).getId().length()-1)+"detail\n</Layout>\n</Layouts>\n</Div>";

                }
                else if(data.get(i).getType().trim().equals("Radio"))
                {
                	if(rDataset.trim().length()==0) str += "/>\n";
                	else
                		str+=">\n"+rDataset+"\n</Radio>\n";
                }
                else {
                    if (data.get(i).getType().trim().equals("Grid")) {

                        String details = data.get(i).getInfo().substring(data.get(i).getInfo().indexOf("Contents")+10, data.get(i).getInfo().length()-1);
                        //log(details);
                        str += ">\n" + details + "\n" + "</" + data.get(i).getType() + ">\n";
                        //log(str);
                    } else
                        str += "/>\n";
                }
            }
            stringList.add(str);
            str="";
        }

//        log("UI comp str생성");
//        log(str);
        return stringList;
    }

    public  static  String makeStr1(List<Dataset> data, String type)
    {
        String str="";
        switch (type)
        {
            case "D":
                String name="", event="", info="",colinfo="";


                for(int i=0;i<data.size();i++)
                {
                    name = data.get(i).name;
                    info = data.get(i).info;
                    colinfo = data.get(i).colInfo.substring(1,data.get(i).colInfo.lastIndexOf('"'));
                    String tempdata="<Dataset id = "+'"'+name+'"'+" "+info+" "+event+"> \n" +colinfo+" \n</Dataset>";
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
                
                eventInfoList.add(new EventInfo(compname,eventtype,eventname));
            }

        }
        return eventInfoList;
    }

    public static List<Metadata> extractKeyData(List<String> data)
    {
        List<Metadata> md = new ArrayList<Metadata>();
        List<Form> formList=new ArrayList<Form>();
        List<Dataset> datasetList = new ArrayList<Dataset>();
        List<BindItem> bindList=new ArrayList<BindItem>();
        List<UComp> uCompList = new ArrayList<UComp>();
        List<String> sourcecode = new ArrayList<String>();
        List<EventInfo> eventInfoList = new ArrayList<EventInfo>();
        List<String> compDepth =new ArrayList<String>();
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
                    String name="";
                    String colinfo="";
                    String info="";
                    int j=i;
                    while(true)
                    {
                    	
                    	 if(j==data.size()-1) break;

                         j+=1;
                         if(data.get(j).indexOf("obj = new")>=0)
                             break;
                         
                         
                         if(data.get(j).indexOf("_setContents")>=0)
                         {
                        	 String value="";
                             
                             value=data.get(j).substring(data.get(j).indexOf('(')+1,data.get(j).lastIndexOf(')'));
                             colinfo=value;
                         }
                         if((data.get(j).indexOf("_set")>=0 ||data.get(j).indexOf("set_")>=0) && data.get(j).indexOf("_setContents")<0)
                         {
                        	 String key="",value="";
                        	 if(data.get(j).indexOf("set_")>=0)
                             {

                                 key = data.get(j).substring(data.get(j).indexOf("set_")+4,data.get(j).indexOf('('));

                             }
                             else if(data.get(j).indexOf("_set")>=0)
                             {
                                 key = data.get(j).substring(data.get(j).indexOf("_set")+4,data.get(j).indexOf('('));
                             }
                             value=data.get(j).substring(data.get(j).indexOf('(')+1,data.get(j).lastIndexOf(')'));
                        	 info+=" "+key+"="+value;
                         }
                    }
                    name = data.get(i).substring(data.get(i).indexOf('"')+1,data.get(i).lastIndexOf('"'));
                    
                    datasetList.add(new Dataset(name, colinfo,info));

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
                        //TODO

                        if(data.get(j).indexOf("set_")>=0||(data.get(j).indexOf("_setContents")>=0&&!compname.equals("Dataset"))||data.get(j).indexOf("getSetter")>=0)
                        {
                        	
                            String key="",value="";
                            if(data.get(j).indexOf("set_")>=0)
                            {

                                key = data.get(j).substring(data.get(j).indexOf("set_")+4,data.get(j).indexOf('('));

                            }
                            else if(data.get(j).indexOf("_set")>=0)
                            {
                                key = data.get(j).substring(data.get(j).indexOf("_set")+4,data.get(j).indexOf('('));
                            }
                            value=data.get(j).substring(data.get(j).indexOf('(')+1,data.get(j).lastIndexOf(')'));
                            if(data.get(j).indexOf("getSetter")>=0)
                            {
                                key = data.get(j).substring(data.get(j).indexOf('"')+1,data.get(j).indexOf(").set")-1);
                                value=data.get(j).substring(data.get(j).indexOf(").set")+6,data.get(j).lastIndexOf('"')+1);

                            }
                            //else
                            //{

                                //key = data.get(j).substring(data.get(j).indexOf("_set")+4,data.get(j).indexOf('('));
                                //value=data.get(j).substring(data.get(j).indexOf('(')+1,data.get(j).lastIndexOf(')'));
                                //System.out.println("key: "+key+", value: "+value);
                           // }
                           // System.out.println(key+" "+value);

                            info+=" "+key+"="+value;
                            String tmpinfo = info.replace("\\","");
                            info = tmpinfo;
                        }
                        if ((data.get(j).indexOf("addChild") >= 0&&data.get(j).indexOf("addChild")>4)
                        ||(data.get(j).indexOf("addLayout") >= 0&&data.get(j).indexOf("addLayout")>4)) {

                            if(data.get(j).indexOf("addChild") >= 0)
                                parents = data.get(j).substring(0, data.get(j).indexOf(".addChild"));
                            else
                                parents = data.get(j).substring(0, data.get(j).indexOf(".addLayout"));
                            parents=parents.replace(" ","" );
                            parents=parents.replace(".form","");
                            parents=parents.replace(".",",");

                            //deli = '.';
                            String[] tmpPa = parents.split(",");

                            for(int p=0;p< tmpPa.length;p++)
                            {

                                if(compDepth.size()< p+1){
                                    for(int s =0;s<p+1-compDepth.size();s++) {
                                        compDepth.add(tmpPa[p]);
                                        if(!compDepth.contains(name) && compname.equals("Div"))
                                        {
                                            compDepth.add(name);
                                        }
                                    }
                                }

                                if(compDepth.get(p).indexOf(tmpPa[p])<0)
                                {

                                    String tmp = compDepth.get(p);
                                    compDepth.remove(p);
                                    tmp=tmp.concat(","+tmpPa[p]);
                                    compDepth.add(p,tmp);

                                }
                            }
                            if(!parents.equals("this"))
                                parents = parents.substring(parents.lastIndexOf(",")+1, parents.length());

                            break;
                        }
                    }
                    String[] divcomp = {"uCalDayFromTo","uCalDay","uCalMMFromTo","uCalMM","uCodeCombo","uCombo"};
                    for(int pidx =0;pidx<divcomp.length;pidx++)
                    {
                    	if("Div".equals(compname) && info.indexOf("url")>=0 &&info.indexOf(divcomp[pidx])>=0 )
                    	{
                    		compname = divcomp[pidx];
                    		//url="fw::obj/uCalDayFromTo.xfdl"
                    		String url = "url="+'"'+"fw::obj/"+divcomp[pidx]+".xfdl"+'"';
                    		info = info.replaceAll(url, "");
                    		break;
                    	}
                    }
                    if(!"BindItem".equals(compname))
                    	uCompList.add(new UComp(compname,oParam[0],oParam[1],oParam[2],oParam[3],oParam[4],oParam[5],oParam[6],oParam[7]
                                                    ,oParam[8],oParam[9],oParam[10],info,parents));
                    else {
                    	bindList.add(new BindItem(oParam[0],oParam[1],oParam[2],oParam[3],oParam[4]));
                    }
                }else
                    continue;

                //

            }

        }

        md.add(new Metadata(formList,datasetList,uCompList,eventInfoList,sourcecode,compDepth,bindList));

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
                
            }
            if(data.get(i).indexOf("registerScript")>=0) {
                flag=true;
                continue;
            }
        }
        
        for(int i=sc.size()-1;i>=0;i--)
        {
        	
        	if( sc.get(i).indexOf("});")>=0)
        	{	
        		sc.remove(i);
        		break;
        	}else
        		sc.remove(i);
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
