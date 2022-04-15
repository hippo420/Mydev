(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("TmSpcMnyTrustFundMgr_man01");
            this.set_titletext("특정금전신탁펀드관리");
            if (Form == this.constructor)
            {
                this._setFormPosition(1580,795);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("dstCond1", this);
            obj._setContents("<ColumnInfo><Column id=\"PRD_CD\" type=\"STRING\" size=\"256\"/><Column id=\"PRD_NM\" type=\"STRING\" size=\"256\"/><Column id=\"CURR_CD\" type=\"STRING\" size=\"256\"/><Column id=\"CURR_NM\" type=\"STRING\" size=\"256\"/><Column id=\"FUND_TYCD_NM\" type=\"STRING\" size=\"256\"/><Column id=\"FUND_TYCD\" type=\"STRING\" size=\"256\"/><Column id=\"FUND\" type=\"STRING\" size=\"256\"/><Column id=\"FUND_NM\" type=\"STRING\" size=\"256\"/><Column id=\"NEWYMD\" type=\"STRING\" size=\"256\"/><Column id=\"MTYYMD\" type=\"STRING\" size=\"256\"/><Column id=\"FUND_STS\" type=\"STRING\" size=\"256\"/><Column id=\"TERMIN_YMD\" type=\"STRING\" size=\"256\"/><Column id=\"CUST_BR\" type=\"STRING\" size=\"256\"/><Column id=\"ACCT_NO\" type=\"STRING\" size=\"256\"/><Column id=\"RSRV_MTHD_TYCD\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row/></Rows>");
            this.addChild(obj.name, obj);


            obj = new Dataset("dstList1", this);
            obj._setContents("<ColumnInfo><Column id=\"FUND\" type=\"STRING\" size=\"256\"/><Column id=\"ACCT_NO\" type=\"STRING\" size=\"256\"/><Column id=\"IMC\" type=\"STRING\" size=\"256\"/><Column id=\"CUST_YMD\" type=\"STRING\" size=\"256\"/><Column id=\"MTYYMD\" type=\"STRING\" size=\"256\"/><Column id=\"TERMIN_YMD\" type=\"STRING\" size=\"256\"/><Column id=\"CUST_BLNC\" type=\"STRING\" size=\"256\"/><Column id=\"CURR_CD\" type=\"STRING\" size=\"256\"/><Column id=\"PRD_CD\" type=\"STRING\" size=\"256\"/><Column id=\"OPROFIT_YN\" type=\"STRING\" size=\"256\"/><Column id=\"BR\" type=\"STRING\" size=\"256\"/><Column id=\"PROC_BR\" type=\"STRING\" size=\"256\"/><Column id=\"CPRN_BEN_CLNT\" type=\"STRING\" size=\"256\"/><Column id=\"PROFIT_BEN_CLNT\" type=\"STRING\" size=\"256\"/><Column id=\"RSRV_MTHD\" type=\"STRING\" size=\"256\"/><Column id=\"PROFIT_PAY_MTHD\" type=\"STRING\" size=\"256\"/><Column id=\"MLT_ASSET_YN\" type=\"STRING\" size=\"256\"/><Column id=\"TXN_CD\" type=\"STRING\" size=\"256\"/><Column id=\"FUND_STS\" type=\"STRING\" size=\"256\"/><Column id=\"PROFIT_PAY_YMD\" type=\"STRING\" size=\"256\"/><Column id=\"BFTAKE_BEF_TR_AMT\" type=\"STRING\" size=\"256\"/><Column id=\"BFTAKE_FEE_AMT\" type=\"STRING\" size=\"256\"/><Column id=\"BFTAKE_FEE_RATE\" type=\"STRING\" size=\"256\"/><Column id=\"AUTO_OUT_PROPS_YN\" type=\"STRING\" size=\"256\"/><Column id=\"CORE_PRD_CD\" type=\"STRING\" size=\"256\"/><Column id=\"LAST_CHG_DM\" type=\"STRING\" size=\"256\"/><Column id=\"LAST_CHG_ID\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);


            obj = new Dataset("dstCURR_CD", this);
            obj._setContents("<ColumnInfo><Column id=\"CD\" type=\"STRING\" size=\"256\"/><Column id=\"NM\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);


            obj = new Dataset("dstFUND_TYCD", this);
            obj._setContents("<ColumnInfo><Column id=\"CD\" type=\"STRING\" size=\"256\"/><Column id=\"NM\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);


            obj = new Dataset("dstPRD_CD", this);
            obj._setContents("<ColumnInfo><Column id=\"CD\" type=\"STRING\" size=\"256\"/><Column id=\"NM\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);


            obj = new Dataset("dstFUND_STS", this);
            obj._setContents("<ColumnInfo><Column id=\"CD\" type=\"STRING\" size=\"256\"/><Column id=\"NM\" type=\"STRING\" size=\"256\"/><Column id=\"ORG_NM\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Div("divDetail1",null,"119","1185",null,"0","2",null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_text("");
            this.addChild(obj.name, obj);

            obj = new Tab("tabMian","0","38",null,null,"0","0",null,null,null,null,this.divDetail1.form);
            obj.set_taborder("6");
            obj.set_tabindex("0");
            obj.set_preload("true");
            this.divDetail1.addChild(obj.name, obj);

            obj = new Tabpage("Tabpage1",this.divDetail1.form.tabMian);
            obj.set_text("펀드상세정보");
            obj.set_url("bo::bn/BnItemInfoMgr_div01.xfdl");
            this.divDetail1.form.tabMian.addChild(obj.name, obj);

            obj = new Tabpage("Tabpage2",this.divDetail1.form.tabMian);
            obj.set_text("운용상품정보");
            obj.set_url("bo::bn/BnItemInfoMgr_div02.xfdl");
            this.divDetail1.form.tabMian.addChild(obj.name, obj);

            obj = new Tabpage("Tabpage3",this.divDetail1.form.tabMian);
            obj.set_text("펀드수수료정보");
            obj.set_url("bo::bn/BnItemInfoMgr_div03.xfdl");
            obj.getSetter("enableskip").set("true");
            obj.set_async("false");
            this.divDetail1.form.tabMian.addChild(obj.name, obj);

            obj = new Tabpage("Tabpage4",this.divDetail1.form.tabMian);
            obj.set_text("선취보수정보");
            obj.set_url("bo::bn/BnItemInfoMgr_div04.xfdl");
            this.divDetail1.form.tabMian.addChild(obj.name, obj);

            obj = new Tabpage("Tabpage5",this.divDetail1.form.tabMian);
            obj.set_text("UMS정보");
            obj.set_url("bo::bn/BnItemInfoMgr_div05.xfdl");
            this.divDetail1.form.tabMian.addChild(obj.name, obj);

            obj = new Static("staSubTitle1","0","0","320","38",null,null,null,null,null,null,this.divDetail1.form);
            obj.set_taborder("7");
            obj.set_text("펀드상세");
            obj.set_cssclass("sta_WF_SubTitle01");
            this.divDetail1.addChild(obj.name, obj);

            obj = new Div("divCond1","0","0",null,"119","0",null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_cssclass("div_WF_SchBg");
            obj.getSetter("scrollbars").set("none");
            obj.set_tabstop("false");
            obj.set_text("");
            this.addChild(obj.name, obj);

            obj = new Static("staCURR_CD","840","5","66","23",null,null,null,null,null,null,this.divCond1.form);
            obj.set_text("통화");
            obj.set_cssclass("sta_WF_SchLabel");
            obj.set_taborder("1");
            this.divCond1.addChild(obj.name, obj);

            obj = new uCodeCombo("ucbCURR_CD","933","5","270","23",null,null,null,null,null,null,this.divCond1.form);
            obj.set_taborder("0");
            obj.set__11_binddataset("dstCond1");
            obj.set__21_popupheight("400");
            obj.set_visible("true");
            obj.set__20_popupwidth("400");
            obj.set__14_type("search");
            obj.set__24_iscutname("false");
            obj.set__12_bindcodecol("CURR_CD");
            obj.set__13_binddatacol("CURR_NM");
            obj.set__15_innercodecol("CD");
            obj.set__16_innerdatacol("NM");
            obj.set__22_innerdisplaycols("CD,NM");
            obj.set__23_innerdisplayheadcaptions("통화,통화명");
            obj.set__32_treelevelcol("PRD_LEVEL");
            obj.set__33_treecaptioncol("DIS_TEXT");
            obj.set__30_ispreload("true");
            obj.set__34_isfilteruppercase("true");
            obj.set__25_nulltext("전체");
            obj.set__28_codelength("3");
            obj.set__17_innerdataset("dstCURR_CD");
            this.divCond1.addChild(obj.name, obj);

            obj = new Static("staFUND_TYCD","0","5","90","23",null,null,null,null,null,null,this.divCond1.form);
            obj.set_text("펀드분류");
            obj.set_cssclass("sta_WF_SchLabel");
            obj.set_taborder("2");
            this.divCond1.addChild(obj.name, obj);

            obj = new uCodeCombo("ucbFUND_TYCD","93","5","290","23",null,null,null,null,null,null,this.divCond1.form);
            obj.set_taborder("3");
            obj.set__11_binddataset("dstCond1");
            obj.set__12_bindcodecol("FUND_TYCD");
            obj.set__13_binddatacol("FUND_TYCD_NM");
            obj.set__14_type("tree");
            obj.set__16_innerdatacol("NM");
            obj.set__22_innerdisplaycols("CD,NM");
            obj.set__23_innerdisplayheadcaptions("펀드,펀드명");
            obj.set__24_iscutname("true");
            obj.set__25_nulltext("전체");
            obj.set__30_ispreload("true");
            obj.set__28_codelength("3");
            obj.set__15_innercodecol("CD");
            obj.set__17_innerdataset("dstFUND_TYCD");
            obj.set__32_treelevelcol("PRD_LEVEL");
            obj.set__33_treecaptioncol("DIS_TEXT");
            obj.set__50_outputcols("FUND_TYCD_NM=NM");
            this.divCond1.addChild(obj.name, obj);

            obj = new Static("staFUND","386","5","90","23",null,null,null,null,null,null,this.divCond1.form);
            obj.set_text("펀드");
            obj.set_cssclass("sta_WF_SchLabel");
            obj.set_taborder("4");
            this.divCond1.addChild(obj.name, obj);

            obj = new uCodeCombo("ucbFUND","479","5","290","23",null,null,null,null,null,null,this.divCond1.form);
            obj.set_taborder("5");
            obj.set__10_sqlid("FR_FUND");
            obj.set__11_binddataset("dstCond1");
            obj.set__12_bindcodecol("FUND");
            obj.set__13_binddatacol("FUND_NM");
            obj.set__15_innercodecol("CD");
            obj.set__16_innerdatacol("NM");
            obj.set__22_innerdisplaycols("CD,NM");
            obj.set__23_innerdisplayheadcaptions("펀드,펀드명");
            obj.set__25_nulltext("전체");
            obj.set__28_codelength("12");
            obj.set__80_uselazyload("false");
            obj.set__81_pagesize("100");
            obj.set__30_ispreload("true");
            obj.set__50_outputcols("FUND_NAME_FROM=NM");
            obj.set__24_iscutname("true");
            obj.set__221_colswidth("150,200");
            this.divCond1.addChild(obj.name, obj);

            obj = new Static("staGC_AC00_00","0","33","90","23",null,null,null,null,null,null,this.divCond1.form);
            obj.set_text("상품");
            obj.set_cssclass("sta_WF_SchLabel");
            obj.set_taborder("6");
            this.divCond1.addChild(obj.name, obj);

            obj = new uCodeCombo("ucbPRD_CD","93","33","290","23",null,null,null,null,null,null,this.divCond1.form);
            obj.set_taborder("7");
            obj.set__11_binddataset("dstCond1");
            obj.set__12_bindcodecol("PRD_CD");
            obj.set__13_binddatacol("PRD_NM");
            obj.set__15_innercodecol("CD");
            obj.set__16_innerdatacol("NM");
            obj.set__22_innerdisplaycols("CD,NM");
            obj.set__23_innerdisplayheadcaptions("상품,상품명");
            obj.set__25_nulltext("전체");
            obj.set__28_codelength("12");
            obj.set__80_uselazyload("false");
            obj.set__81_pagesize("100");
            obj.set__30_ispreload("true");
            obj.set__50_outputcols("PRD_NM=NM");
            obj.set__24_iscutname("true");
            obj.set__221_colswidth("150,200");
            obj.set__17_innerdataset("dstPRD_CD");
            obj.set__14_type("tree");
            obj.set__32_treelevelcol("PRD_LEVEL");
            obj.set__33_treecaptioncol("DIS_TEXT");
            this.divCond1.addChild(obj.name, obj);

            obj = new Static("staACCT_NO","0","61","90","23",null,null,null,null,null,null,this.divCond1.form);
            obj.set_text("계좌번호");
            obj.set_cssclass("sta_WF_SchLabel");
            obj.set_taborder("8");
            this.divCond1.addChild(obj.name, obj);

            obj = new uCodeCombo("ucbACCT_NO","93","61","290","23",null,null,null,null,null,null,this.divCond1.form);
            obj.set_taborder("9");
            obj.set__10_sqlid("FR_FUND");
            obj.set__11_binddataset("dstCond1");
            obj.set__12_bindcodecol("FUND_LIST_FROM");
            obj.set__13_binddatacol("FUND_NAME_FROM");
            obj.set__15_innercodecol("CD");
            obj.set__16_innerdatacol("NM");
            obj.set__22_innerdisplaycols("CD,NM");
            obj.set__23_innerdisplayheadcaptions("펀드,펀드명");
            obj.set__25_nulltext("전체");
            obj.set__28_codelength("12");
            obj.set__80_uselazyload("false");
            obj.set__81_pagesize("100");
            obj.set__30_ispreload("true");
            obj.set__50_outputcols("FUND_NAME_FROM=NM");
            obj.set__24_iscutname("true");
            obj.set__221_colswidth("150,200");
            this.divCond1.addChild(obj.name, obj);

            obj = new uCombo("cboRSRV_MTHD_TYCD","93","89","165","23",null,null,null,null,null,null,this.divCond1.form);
            obj.set_taborder("10");
            obj.set_innerdataset("dstPRD_KIND");
            obj.set_codecolumn("CD");
            obj.set_datacolumn("NM");
            obj.set_enable("true");
            obj.set_displaynulltext("전체");
            obj.set_useclearbutton("true");
            obj.set_value("0");
            obj.set_index("0");
            this.divCond1.addChild(obj.name, obj);

            obj = new Static("staRSRV_MTHD_TYCD","0","89","90","23",null,null,null,null,null,null,this.divCond1.form);
            obj.set_text("적립방법");
            obj.set_cssclass("sta_WF_SchLabel");
            obj.set_taborder("11");
            this.divCond1.addChild(obj.name, obj);

            obj = new uCalDayFromTo("NEWYMD","479","33","200","23",null,null,null,null,null,null,this.divCond1.form);
            obj.set_taborder("12");
            this.divCond1.addChild(obj.name, obj);

            obj = new Static("staNEW_YMD","386","33","90","23",null,null,null,null,null,null,this.divCond1.form);
            obj.set_text("신규일");
            obj.set_cssclass("sta_WF_SchLabel");
            obj.set_taborder("13");
            this.divCond1.addChild(obj.name, obj);

            obj = new Static("staGC_AC00_01_00","386","61","90","23",null,null,null,null,null,null,this.divCond1.form);
            obj.set_text("만기일");
            obj.set_cssclass("sta_WF_SchLabel");
            obj.set_taborder("14");
            this.divCond1.addChild(obj.name, obj);

            obj = new uCalDayFromTo("MTYYMD","479","61","200","23",null,null,null,null,null,null,this.divCond1.form);
            obj.set_taborder("15");
            this.divCond1.addChild(obj.name, obj);

            obj = new Static("staFUND_STS","386","89","90","23",null,null,null,null,null,null,this.divCond1.form);
            obj.set_text("펀드상태");
            obj.set_cssclass("sta_WF_SchLabel");
            obj.set_taborder("16");
            this.divCond1.addChild(obj.name, obj);

            obj = new uCombo("cboFUND_STS","479","89","165","23",null,null,null,null,null,null,this.divCond1.form);
            obj.set_taborder("17");
            obj.set_innerdataset("dstFUND_STS");
            obj.set_codecolumn("CD");
            obj.set_datacolumn("NM");
            obj.set_enable("true");
            obj.set_displaynulltext("전체");
            obj.set_useclearbutton("true");
            obj.set_value("0");
            obj.set_index("0");
            this.divCond1.addChild(obj.name, obj);

            obj = new Static("staTERMIN_YMD","840","33","90","23",null,null,null,null,null,null,this.divCond1.form);
            obj.set_text("해지일");
            obj.set_cssclass("sta_WF_SchLabel");
            obj.set_taborder("18");
            this.divCond1.addChild(obj.name, obj);

            obj = new Static("staCUST_BR","840","61","78","23",null,null,null,null,null,null,this.divCond1.form);
            obj.set_text("수탁점");
            obj.set_cssclass("sta_WF_SchLabel");
            obj.set_taborder("19");
            this.divCond1.addChild(obj.name, obj);

            obj = new Static("staBR","840","89","78","23",null,null,null,null,null,null,this.divCond1.form);
            obj.set_text("관리점");
            obj.set_cssclass("sta_WF_SchLabel");
            obj.set_taborder("20");
            this.divCond1.addChild(obj.name, obj);

            obj = new Edit("edtTERMIN_YMD","933","33","138","23",null,null,null,null,null,null,this.divCond1.form);
            obj.set_taborder("21");
            this.divCond1.addChild(obj.name, obj);

            obj = new CheckBox("chk00","1074","33","100","23",null,null,null,null,null,null,this.divCond1.form);
            obj.set_taborder("22");
            obj.set_text("상환펀드제외");
            this.divCond1.addChild(obj.name, obj);

            obj = new uCodeCombo("ucbCUST_BR","933","61","290","23",null,null,null,null,null,null,this.divCond1.form);
            obj.set_taborder("23");
            obj.set__10_sqlid("FR_FUND");
            obj.set__11_binddataset("dstCond1");
            obj.set__12_bindcodecol("FUND_LIST_FROM");
            obj.set__13_binddatacol("FUND_NAME_FROM");
            obj.set__15_innercodecol("CD");
            obj.set__16_innerdatacol("NM");
            obj.set__22_innerdisplaycols("CD,NM");
            obj.set__23_innerdisplayheadcaptions("펀드,펀드명");
            obj.set__25_nulltext("전체");
            obj.set__28_codelength("12");
            obj.set__80_uselazyload("false");
            obj.set__81_pagesize("100");
            obj.set__30_ispreload("true");
            obj.set__50_outputcols("FUND_NAME_FROM=NM");
            obj.set__24_iscutname("true");
            obj.set__221_colswidth("150,200");
            this.divCond1.addChild(obj.name, obj);

            obj = new uCodeCombo("ucbBR","933","89","290","23",null,null,null,null,null,null,this.divCond1.form);
            obj.set_taborder("24");
            obj.set__10_sqlid("FR_FUND");
            obj.set__11_binddataset("dstCond1");
            obj.set__12_bindcodecol("FUND_LIST_FROM");
            obj.set__13_binddatacol("FUND_NAME_FROM");
            obj.set__15_innercodecol("CD");
            obj.set__16_innerdatacol("NM");
            obj.set__22_innerdisplaycols("CD,NM");
            obj.set__23_innerdisplayheadcaptions("펀드,펀드명");
            obj.set__25_nulltext("전체");
            obj.set__28_codelength("12");
            obj.set__80_uselazyload("false");
            obj.set__81_pagesize("100");
            obj.set__30_ispreload("true");
            obj.set__50_outputcols("FUND_NAME_FROM=NM");
            obj.set__24_iscutname("true");
            obj.set__221_colswidth("150,200");
            this.divCond1.addChild(obj.name, obj);

            obj = new Edit("edtFUND_CURR_CD","772","5","65","23",null,null,null,null,null,null,this.divCond1.form);
            obj.set_taborder("25");
            obj.set_enable("false");
            this.divCond1.addChild(obj.name, obj);

            obj = new Div("divList1","0","119",null,null,"1205","0",null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_cssclass("div_WF_ListBg");
            this.addChild(obj.name, obj);

            obj = new Static("staSubTitle1","0","0","200","38",null,null,null,null,null,null,this.divList1.form);
            obj.set_taborder("0");
            obj.set_text("펀드목록");
            obj.set_cssclass("sta_WF_SubTitle01");
            obj.set_fittocontents("width");
            this.divList1.addChild(obj.name, obj);

            obj = new Static("staTotCnt1",null,"10","70","23","0",null,null,null,null,null,this.divList1.form);
            obj.set_taborder("2");
            obj.set_text("총 0건");
            obj.set_cssclass("sta_WF_Total");
            obj.set_fittocontents("width");
            this.divList1.addChild(obj.name, obj);

            obj = new Button("btnSumView",null,"10","46","23","staTotCnt1:3",null,null,null,null,null,this.divList1.form);
            obj.set_taborder("4");
            obj.set_text("요약");
            obj.set_cssclass("btn_WF_ModCustom");
            obj.set_fittocontents("width");
            this.divList1.addChild(obj.name, obj);

            obj = new Button("btnAllView",null,"10","46","23","staTotCnt1:3",null,null,null,null,null,this.divList1.form);
            obj.set_taborder("1");
            obj.set_text("전체");
            obj.set_cssclass("btn_WF_ModCustom");
            obj.set_fittocontents("width");
            this.divList1.addChild(obj.name, obj);

            obj = new Grid("grdList1","0","38",null,null,"0","30",null,null,null,null,this.divList1.form);
            obj.set_taborder("3");
            obj.set_tabstop("false");
            obj.set_binddataset("dstList1");
            obj.set_readonly("true");
            obj.set_autoenter("select");
            obj.set_cellsizingtype("col");
            obj.getSetter("userdata").set("");
            obj.set_cellmovingtype("col");
            obj.set_nodataimage("url(\'theme://images/grd_WF_Nodata.png\')");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"32\"/><Column size=\"35\"/><Column size=\"100\"/><Column size=\"150\"/><Column size=\"150\"/><Column size=\"130\"/><Column size=\"87\"/><Column size=\"120\"/><Column size=\"100\"/><Column size=\"100\"/><Column size=\"100\"/><Column size=\"111\"/><Column size=\"112\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"100\"/><Column size=\"105\"/><Column size=\"99\"/><Column size=\"110\"/><Column size=\"119\"/><Column size=\"107\"/><Column size=\"148\"/><Column size=\"107\"/><Column size=\"107\"/><Column size=\"118\"/><Column size=\"145\"/><Column size=\"136\"/></Columns><Rows><Row size=\"60\" band=\"head\"/><Row size=\"28\"/></Rows><Band id=\"head\"><Cell displaytype=\"text\" text=\"NO\"/><Cell col=\"1\" displaytype=\"checkboxcontrol\" edittype=\"checkbox\"/><Cell col=\"2\" displaytype=\"text\" text=\"펀드코드\"/><Cell col=\"3\" displaytype=\"text\" text=\"계좌번호\"/><Cell col=\"4\" displaytype=\"text\" text=\"위탁자\"/><Cell col=\"5\" displaytype=\"text\" text=\"수탁일자\"/><Cell col=\"6\" displaytype=\"text\" text=\"만기일자\"/><Cell col=\"7\" displaytype=\"text\" text=\"해지일자\"/><Cell col=\"8\" displaytype=\"text\" text=\"수탁잔액\"/><Cell col=\"9\" displaytype=\"text\" text=\"통화\"/><Cell col=\"10\" displaytype=\"text\" text=\"상품코드\"/><Cell col=\"11\" displaytype=\"text\" text=\"타익여부\"/><Cell col=\"12\" displaytype=\"text\" text=\"수탁점\"/><Cell col=\"13\" displaytype=\"text\" text=\"관리점\"/><Cell col=\"14\" displaytype=\"text\" text=\"원본수익자\"/><Cell col=\"15\" displaytype=\"text\" text=\"이익수익자\"/><Cell col=\"16\" displaytype=\"text\" text=\"적립방법\"/><Cell col=\"17\" displaytype=\"text\" text=\"이익지급방법\"/><Cell col=\"18\" displaytype=\"text\" text=\"멀티에셋여부\"/><Cell col=\"19\" displaytype=\"text\" text=\"과세코드\"/><Cell col=\"20\" displaytype=\"text\" text=\"펀드상태\"/><Cell col=\"21\" displaytype=\"text\" text=\"이익지급일자\"/><Cell col=\"22\" displaytype=\"text\" text=\"선취전거래금액\"/><Cell col=\"23\" displaytype=\"text\" text=\"선취보수금액\"/><Cell col=\"24\" displaytype=\"text\" text=\"선취보수율(%)\"/><Cell col=\"25\" displaytype=\"text\" text=\"자동해지신청여부\"/><Cell col=\"26\" displaytype=\"text\" text=\"코어상품코드\"/><Cell col=\"27\" displaytype=\"text\" text=\"최종변경일시\"/><Cell col=\"28\" displaytype=\"text\" text=\"최종변경사번\"/></Band><Band id=\"body\"><Cell celltype=\"none\" displaytype=\"text\" textAlign=\"right\" expr=\"currow+1\"/><Cell col=\"1\" displaytype=\"checkboxcontrol\" edittype=\"checkbox\" text=\"bind:CHK\"/><Cell col=\"2\" displaytype=\"normal\" text=\"bind:FUND\" textAlign=\"center\"/><Cell col=\"3\" displaytype=\"normal\" text=\"bind:ACCT_NO\" textAlign=\"left\"/><Cell col=\"4\" displaytype=\"normal\" textAlign=\"left\" text=\"bind:IMC\"/><Cell col=\"5\" displaytype=\"normal\" textAlign=\"center\" text=\"bind:CUST_YMD\"/><Cell col=\"6\" displaytype=\"text\" textAlign=\"center\" text=\"bind:MTYYMD\"/><Cell col=\"7\" displaytype=\"normal\" textAlign=\"left\" text=\"bind:TERMIN_YMD\"/><Cell col=\"8\" displaytype=\"normal\" edittype=\"none\" text=\"bind:CUST_BLNC\" combodataset=\"dstNATION2\" combocodecol=\"CD\" combodatacol=\"NM\" textAlign=\"center\"/><Cell col=\"9\" displaytype=\"normal\" text=\"bind:CURR_CD\" combodataset=\"dstNATION2\" combocodecol=\"CD\" combodatacol=\"NM\"/><Cell col=\"10\" displaytype=\"text\" text=\"bind:PRD_CD\" textAlign=\"center\"/><Cell col=\"11\" text=\"bind:OPROFIT_YN\" displaytype=\"normal\" textAlign=\"center\"/><Cell col=\"12\" displaytype=\"normal\" text=\"bind:BR\" combodataset=\"dstISSUE_MKT_TYCD\" combocodecol=\"CD\" combodatacol=\"ORG_NM\" textAlign=\"center\"/><Cell col=\"13\" displaytype=\"normal\" textAlign=\"center\" text=\"bind:PROC_BR\"/><Cell col=\"14\" displaytype=\"normal\" textAlign=\"center\" text=\"bind:CPRN_BEN_CLNT\" calendardateformat=\"yyyy-MM-dd\" calendardisplaynulltype=\"nulltext\"/><Cell col=\"15\" displaytype=\"normal\" textAlign=\"center\" text=\"bind:PROFIT_BEN_CLNT\" combodataset=\"dstESTPRICE_TYCD\" combocodecol=\"CD\" combodatacol=\"ORG_NM\" calendardisplaynulltype=\"nulltext\" calendardateformat=\"yyyy-MM-dd\"/><Cell col=\"16\" displaytype=\"number\" textAlign=\"right\" text=\"bind:RSRV_MTHD\" combodataset=\"dstINT_DAYS_TYCD\" combocodecol=\"CD\" combodatacol=\"ORG_NM\"/><Cell col=\"17\" displaytype=\"normal\" textAlign=\"center\" text=\"bind:PROFIT_PAY_MTHD\" combodataset=\"dstBUSINESS_DAY_TYCD\" combocodecol=\"CD\" combodatacol=\"ORG_NM\"/><Cell col=\"18\" displaytype=\"normal\" calendardateformat=\"yyyy-MM-dd\" textAlign=\"center\" text=\"bind:MLT_ASSET_YN\" calendardisplaynulltype=\"nulltext\"/><Cell col=\"19\" displaytype=\"number\" text=\"bind:TXN_CD\" combodataset=\"dstBOND_ATTR_TYCD\" combocodecol=\"CD\" combodatacol=\"ORG_NM\" textAlign=\"right\"/><Cell col=\"20\" displaytype=\"number\" text=\"bind:FUND_STS\" textAlign=\"right\"/><Cell col=\"21\" displaytype=\"number\" textAlign=\"right\" text=\"bind:PROFIT_PAY_YMD\" combodataset=\"dstINT_CLASS\" combocodecol=\"CD\" combodatacol=\"ORG_NM\"/><Cell col=\"22\" displaytype=\"number\" calendardateformat=\"yyyy-MM-dd\" textAlign=\"right\" text=\"bind:BFTAKE_BEF_TR_AMT\" calendardisplaynulltype=\"nulltext\"/><Cell col=\"23\" displaytype=\"number\" calendardateformat=\"yyyy-MM-dd\" textAlign=\"right\" text=\"bind:BFTAKE_FEE_AMT\" calendardisplaynulltype=\"nulltext\"/><Cell col=\"24\" displaytype=\"combotext\" textAlign=\"center\" text=\"bind:BFTAKE_FEE_RATE\" combodataset=\"dstIRT_ENGG_TYCD\" combocodecol=\"CD\" combodatacol=\"ORG_NM\"/><Cell col=\"25\" displaytype=\"combotext\" textAlign=\"center\" text=\"bind:AUTO_OUT_PROPS_YN\" combodataset=\"dstINT_PAY_TYCD\" combocodecol=\"CD\" combodatacol=\"ORG_NM\"/><Cell col=\"26\" displaytype=\"combotext\" textAlign=\"center\" text=\"bind:CORE_PRD_CD\" combodataset=\"dstINT_POCP_DFACQ_TYCD\" combocodecol=\"CD\" combodatacol=\"ORG_NM\"/><Cell col=\"27\" displaytype=\"combotext\" textAlign=\"center\" text=\"bind:LAST_CHG_DM\" combodataset=\"dstPRE_SALE_INT_PAY_TYCD\" combocodecol=\"CD\" combodatacol=\"ORG_NM\"/><Cell col=\"28\" displaytype=\"number\" textAlign=\"right\" text=\"bind:LAST_CHG_ID\"/></Band></Format></Formats>");
            this.divList1.addChild(obj.name, obj);
            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",1580,795,this,function(p){});
            obj.set_mobileorientation("landscape");
            this.addLayout(obj.name, obj);
            
            // BindItem Information

            
            // TriggerItem Information

        };
        
        this.loadPreloadList = function()
        {
            this._addPreloadList("fdl","bo::bn/BnItemInfoMgr_div01.xfdl");
            this._addPreloadList("fdl","bo::bn/BnItemInfoMgr_div02.xfdl");
            this._addPreloadList("fdl","bo::bn/BnItemInfoMgr_div03.xfdl");
            this._addPreloadList("fdl","bo::bn/BnItemInfoMgr_div04.xfdl");
            this._addPreloadList("fdl","bo::bn/BnItemInfoMgr_div05.xfdl");
        };
        
        // User Script
        this.registerScript("TmSpcMnyTrustFundMgr_man01.xfdl", function() {
        /**
         *  특정금전신탁펀드 관리(3113)
         *  @MenuPath	신탁상품 > 신탁상품공통
         *  @FileName	TmSpcMnyTrustFundMgr_man01.xfdl
         *  @Creator	박선형
         *  @CreateDate	2022.04.11
         *  @Desction	특정금전신탁펀드 관리(3113)
         ************** 소스 수정 이력 ****************************************************
         *  date          		Modifier                Description
         *******************************************************************************
         *  2022.04.11			박선형					최초 생성
         *******************************************************************************
         */

        /************************************************************************************************
         * FORM 변수 선언 영역
         ************************************************************************************************/
        //JAVA서비스
        const CST_CTL_NAME = "tr/tm/TmSpcMnyTrustFundMgr";

        //--코드 데이터 검색 호출값-------------------------------------------------------------------------
        const CST_CD_OPEN  = "ON";									   // 화면 오픈 시 한번만 호출
        const CST_CD_USER  = "US";									   // 사용자 이름, ID
        const CST_CD_FUND   = "FD";

        //통합코드
        this.fvaGetDtlCodes = [
        					    ["FUND_STS"	, this.dstFUND_STS]	//펀드상태
        					  ];



        /************************************************************************************************
         * FORM EVENT 영역(oninit, onload)
         ************************************************************************************************/
        /**
         * Form이 처음 초기화할 때 발생하는 이벤트입니다.
         */
        this.TmSpcMnyTrustFundMgr_man01_oninit = function(obj,e)
        {
        	//통합코드 로드
        	this.gfnGetDtlCodes(this.fvaGetDtlCodes);

        	// 개별코드 로드
        	this.fnGetCodeData();

        };

        /**
         * Form의 모든 컴포넌트가 생성되고, 모든 오브젝트가 로딩되었을 때 발생하는 이벤트입니다.
         */
        this.TmSpcMnyTrustFundMgr_man01_onload = function(obj,e)
        {
        	this.gfnFormOnLoad();      						// * 필수 : Form 공통 기능 처리 (다국어,그리드)


        	//this.fnSetFilterDtlCd();						// 통합코드 필터
        	this.fnInitCond1();								// 조회조건 초기화

        };

        /**
         * 조회조건 초기화
         */
        this.fnInitCond1 = function()
        {
            //this.msBaseForm.gfnSetWFCurrencyTypeCombo(this.divCond1.form.cboCUR_TYPE, "dstCond1", "CUR_TYPE");   // 조회구분 세팅
        	this.gfnGetPrdCdDs(this.dstPRD_CD);   // 자산분류 데이터셋 복사 - 조회조건부용

           //통화코드
            this.gfnCopyCurrency(this.dstCURR_CD);

        	//신탁 관련 상품 코드 - 펀드분류
        	this.gfnGetTrustPrdCdDs(this.dstFUND_TYCD);

        	this.fnSetGrdView(this.divList1.form.btnAllView);
        };



        /************************************************************************************************
         * CALLBACK 콜백 처리부분(Transaction, Popup)
         ************************************************************************************************/
        /**
         * @desc 폼 Transaction Callback 함수
         */
        this.fnCallBackTran = function(psSvcId, psErrCode, psErrMsg)
        {
        	//오류 시 리턴(트랜젝션 오류 시 공통 함수에서 에러 메시지박스 Display)
            if(psErrCode < 0)
            {
        		this.gfnSetEnableCond(this.divCond1, true);	//조회조건 활성화
                return false;
            }

            switch(psSvcId)
            {
                case "lst1":
        			//조회조건 활성화
        			this.gfnSetEnableCond(this.divCond1, true);

        			//총건수 설정
        			this.gfnApplyTotalCount(this.grdList1, this.staTotCnt1);

        			break;
        		case "sav1" + this.CONST_IOMODE_INSERT:
        		case "sav1" + this.CONST_IOMODE_UPDATE:
        		case "sav1" + this.CONST_IOMODE_DELETE:
        			//입력,수정,삭제 후 재조회
        			this.btnSel_onclick();
        			break;
        	}
        };

        /**
         * @desc 코드 조회 CallBack
         * @param {String} psSvcId - 서비스 아이디
         * @param {String} psErrCode - 에러 코드
         * @param {String} psErrMsg - 에러 메세지
         */
        this.fnEachCodeCallback = function(psSvcId, psErrCode, psErrMsg)
        {
        	//오류 시 리턴(트랜젝션 오류 시 공통 함수에서 메시지박스 Display)
        	if(psErrCode < 0)
        	{
        		return false;
        	}

        	switch(psSvcId)
        	{
        	}
        };

        /**
         * 개별 SQL코드성 데이터 로드
         */
        this.fnGetCodeData = function(psGb)
        {
        	if ( this.gfnIsNull(psGb) ) psGb = CST_CD_OPEN;

        	var sFuncCallback = "fnEachCodeCallback";

        	switch(psGb)
        	{
        		case CST_CD_OPEN :
        			this.fnGetCodeData(CST_CD_USER);
        			break;
        		case CST_CD_USER :
                    this.gfnGetEachCode("AP_USER", [], this.dstUSER_ID, CST_CD_USER, this.fnEachCodeCallback, false);	  	// 사용자 이름, ID
        			break;

        	}
        }

        /************************************************************************************************
         * CRUD 및 TRANSACTION 서비스 호출 처리
         ************************************************************************************************/
        /**
         * 조회버튼 CLICK
         */
        this.btnSel_onclick = function(obj)
        {
        	// 필수 조건 check
        	if(this.fnValChk("lst") == false)
        	{
        		return false;
        	}

        	// grid head title원복
            this.gfnGridHeadTitleRecovery(this.grdList1);

        	// grid 입력 안되도록 설정
            this.grdList1.set_readonly(true);

        	// 조회조건 비활성화
        	this.gfnSetEnableCond(this.divCond1, false);

        	// 화면의 IO모드 조회로 변경
        	this.gfnSetIOmode(this.CONST_IOMODE_SEARCH);

        	// 조회 transaction
            this.gfnTrx("lst1", CST_CTL_NAME, this.CONST_TRANS_LIST, "dstCond1", "", "dstList1", "", false, "", "");


        };

        /**
         * 입력버튼 CLICK
         */
        this.btnIns_onclick = function(obj)
        {
        	// IO모드가 입력이 아닌경우
        	if(this.gfnGetIOmode() != this.CONST_IOMODE_INSERT)
        	{
        		// 조회조건 비활성화
        		this.gfnSetEnableCond(this.divCond1, false);

        		// 화면의 IO모드 입력으로 변경
        		this.gfnSetIOmode(this.CONST_IOMODE_INSERT);

        		// 그리드 접고 펼치기 설정
        		this.fnSetGrdView();
        	}

        	// 체크박스 초기화
        	this.gfnChkClear(this.dstList1);

        	// 그리드에 신규 row 삽입
        	this.gfnInsertRow(this.dstList1, this.dstList1.rowposition + 1);

        	// 상세영역 활성화
        	this.gfnSetEnable(this.divDetail1, this.CONST_IOMODE_INSERT);

        	// 입력부 컴포넌트 활성화/비활성화 설정
        	this.fnSetCompEnable();
        };

        /**
         * 수정버튼 CLICK
         */
        this.btnUpd_onclick = function(obj)
        {
        	// 그리드에 데이터가 한건도 없으면 return
        	if(this.dstList1.getRowCount() == 0)
        	{
        		return false;
        	}

        	// 조회조건 비활성화
        	this.gfnSetEnableCond(this.divCond1, false);

        	// 화면의 IO모드 수정으로 변경
        	this.gfnSetIOmode(this.CONST_IOMODE_UPDATE);

        	// 체크박스 초기화
        	this.gfnChkClear(this.dstList1);

        	// 그리드 접고 펼치기 설정
        	this.fnSetGrdView();

        	// 상세영역 활성화
        	this.gfnSetEnable(this.divDetail1, this.CONST_IOMODE_UPDATE);

        	// 입력부 컴포넌트 활성화/비활성화 설정
        	this.fnSetCompEnable();

        };

        /**
         * 삭제버튼 CLICK
         */
        this.btnDel_onclick = function(obj)
        {
        	// 그리드에 데이터가 한건도 없으면 return
        	if(this.dstList1.getRowCount() == 0)
        	{
        		return false;
        	}

        	// 선택된 데이터 있는지 여부 체크
        	if(this.dstList1.getMax("CHK") != "1")
        	{
        		this.gfnAlert("WCMSY001");	/** WCMSY001 : 선택된 데이터가 없습니다. */
        		return false;
        	}

        	this.gfnAlert("삭제서비스 실행!.");
        };

        /**
         * 저장버튼 CLICK
         */
        this.btnSav_onclick = function(obj)
        {
        	this.gfnAlert("저장서비스 실행!.");
        	this.btnSel_onclick();
        };


        /************************************************************************************************
         * 사용자 FUNCTION 영역
         ************************************************************************************************/
        /**
         * @desc 통합코드 필터
         */
        this.fnSetFilterDtlCd = function()
        {
        	//통합코드필터
        	this.dstEST_CURR_TYCD.filter("CD=='ITEM'||CD=='ISIN'||CD=='TICKER'||CD=='SEDOL'||CD=='CUSIP'");	//증권ID유형
        };

        /**
         * @desc 일자설정 : 조회일
         */
        this.fnSetWkymd = function()
        {
        	//조회일
        	var sWkymd = this.gfnGetWorkDateAcctCond("00001", "0000000001");

        	this.dstCond1.setColumn(0, "STDYMD", sWkymd);	//조회시작일
        };

        /**
         * @desc Validation 체크
         */
        this.fnValChk = function(psType)
        {
        	switch(psType.toUpperCase())
        	{
        		case "LST":
        			//조회일 체크
        			if(this.gfnIsDate(this.gfnTrim(this.dstCond1.getColumn(0, "STDYMD"))) == false)
        			{
        				this.gfnAlert("WCMSY006", ["체결일"]);	/* WCMSY006: [{0}]을(를) 입력하세요. */
        				this.divCond1.form.calSTDYMD.setFocus();
        				return false;
        			}
        	}

        	return true;
        };

        this.fnSetGrdView = function(obj,e)
        {
        	this.gfnSetGrdView(obj.parent.parent,1205);
        };

        /************************************************************************************************
         * 각 COMPONENT 별 EVENT 영역
         ************************************************************************************************/
        /**
         * @desc 그리드 grdList1 oncellclick 이벤트
         * @param {nexacro.Grid} obj - Grid
         * @param {nexacro.GridClickEventInfo} e - GridClickEventInfo
         */
        this.divGrid_grdList1_oncellclick = function(obj,e)
        {
        	var oDst = obj.getBindDataset();

        	// 조회/수정모드에서는 선택가능
        	// 입력에서는 DATASET ROWTYPE 이 추가된 행인 경우에만 선택가능
        	if( ((this.gfnGetIOmode() == this.CONST_IOMODE_SEARCH || this.gfnGetIOmode() == this.CONST_IOMODE_UPDATE) ||
        		 (this.gfnGetIOmode() == this.CONST_IOMODE_INSERT && oDst.getRowType(e.row) == Dataset.ROWTYPE_INSERT)
        		 )  && e.cell == obj.getBindCellIndex("body", "CHK"))
        	{
        		if (oDst.getColumn(e.row, "CHK") == 1)
        		{
        			oDst.setColumn(e.row, "CHK", 0);
        		}
        		else
        		{
        			oDst.setColumn(e.row, "CHK", 1);
        		}
        	}
        };

        /**
         * @desc 그리드 grdList1 oncelldblclick 이벤트
         * @param {nexacro.Grid} obj - Grid
         * @param {nexacro.GridClickEventInfo} e - GridClickEventInfo
         */
        this.divGrid_grdList1_oncelldblclick = function(obj,e)
        {
        	//그리드 접고 펼치기 설정
        	//this.fnSetGrdView();
        };

        /**
         * @desc 데이터셋 dstCond1 oncolumnchanged 이벤트
         * @param {nexacro.NormalDataset} obj - NormalDataset
         * @param {nexacro.DSColChangeEventInfo} e - DSColChangeEventInfo
         */
        this.dstCond1_oncolumnchanged = function(obj,e)
        {
        	switch(String(e.columnid).toUpperCase())
        	{
        		case "AC_TY":
                 if(e.newvalue == 1)
                 {
                    this.divCond1.form.ucbAC_CD.fnInnerFilter("CD=='KRW'");
                 }
                 else
                 {
                    this.divCond1.form.ucbAC_CD.fnInnerFilter();
                 }
                 break;

              case "SC_TY":
                 if(e.newvalue == 1)
                 {
                    this.divCond1.form.ucbSC_CD.fnInnerFilter("CD=='KRW'");
                 }
                 else
                 {
                    this.divCond1.form.ucbSC_CD.fnInnerFilter();
                 }
                 break;

        	 case "ITEM_LIST":		//증권종목
        			//this.divCond1.form.ucbCURR_CD.fnSetCode(this.divCond1.form.ucbITEM.fnGetColValue("CURR_CD"));	//종목 콤보 초기화
        			this.divCond1.form.edtITEM_CURR_CD.set_value(this.divCond1.form.ucbITEM.fnGetColValue("CURR_CD"));
         			break;
        	}
        };

        /**
         * @desc 데이터셋 dstList1 onrowposchanged 이벤트
         * @param {nexacro.NormalDataset} obj - NormalDataset
         * @param {nexacro.DSRowPosChangeEventInfo} e - DSRowPosChangeEventInfo
         */
        this.dstList1_onrowposchanged = function(obj,e)
        {
        	var bStat = this.dstList1.enableevent;
        	this.dstList1.set_enableevent(false);

        	//상세영역 enable 처리
        	this.gfnSetEnable(this.divDetail1, this.gfnGetIOmode());

        	//입력부 컴포넌트 활성화/비활성화 설정
        	this.fnSetCompEnable();

        	if(this.dstList2.getRowCount() > 0)
        	{
        		this.dstList2.clearData();

        		//총건수 설정
        		//this.gfnApplyTotalCount(this.tabMain.tabPage2.form.grdList3, this.tabMain.tabPage2.form.staTotCnt2);
        	}

        	this.dstList1.set_enableevent(bStat);
        };

        /**
         * @desc 데이터셋 dstList1 onrowsetchanged 이벤트
         * @param {nexacro.NormalDataset} obj - NormalDataset
         * @param {nexacro.DSRowsetChangeEventInfo} e - DSRowsetChangeEventInfo
         */
        this.dstList1_onrowsetchanged = function(obj,e)
        {
        	if(e.reason == Dataset.REASON_APPEND)
        	{
        		obj.set_rowposition(e.row);	//ROW포지션 변경

        		var bStat = obj.enableevent;
        		obj.set_enableevent(false);

        		var sStdymd			= this.dstCond1.getColumn(0, "STDYMD");
        		var sItem			= this.dstCond1.getColumn(0, "ITEM");

        		//수신기관
        		if(this.gfnIsE4C(sFirm) == false)
        		{
        			this.divDetail1.form.ucbFIRM.fnSetCode(sFirm);
        		}

        		//기준일
        		if(this.gfnIsDate(this.gfnTrim(sStdYmd)) == true)
        		{
        			obj.setColumn(e.row, "STDYMD", sStdYmd);
        		}

        		obj.set_enableevent(bStat);
        	}
        };

        /**
         * @desc 데이터셋 dstList1 canrowposchange 이벤트
         * @param {nexacro.NormalDataset} obj - NormalDataset
         * @param {nexacro.DSRowPosChangeEventInfo} e - DSRowPosChangeEventInfo
         */
        this.dstList1_canrowposchange = function(obj,e)
        {

        };



        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.TmSpcMnyTrustFundMgr_man01_onload,this);
            this.addEventHandler("oninit",this.TmSpcMnyTrustFundMgr_man01_oninit,this);
            this.divDetail1.form.tabMian.addEventHandler("onchanged",this.divDetail1_tabMian_onchanged,this);
            this.divDetail1.form.tabMian.addEventHandler("canchange",this.divDetail1_tabMian_canchange,this);
            this.divList1.form.btnSumView.addEventHandler("onclick",this.fnSetGrdView,this);
            this.divList1.form.btnAllView.addEventHandler("onclick",this.fnSetGrdView,this);
            this.divList1.form.grdList1.addEventHandler("onheadclick",this.grdList1_onheadclick,this);
            this.divList1.form.grdList1.addEventHandler("oncelldblclick",this.grdList1_oncelldblclick,this);
            this.divList1.form.grdList1.addEventHandler("oncellclick",this.grdList1_oncellclick,this);
        };
        this.loadIncludeScript("TmSpcMnyTrustFundMgr_man01.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
