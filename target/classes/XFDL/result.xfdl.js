<?xml version="1.0" encoding="utf-8"?>/n<FDL version="2.1">/n    <Form  id="TmSpcMnyTrustFundMgr_man01" width="1580" height="795">/n    <Layouts>/n        <Layout  id="TmSpcMnyTrustFundMgr_man01" width="1580" height="795">/n            {layouts}/n        </Layout>/n    </Layouts>/n        <Objects>/n<Dataset id = "dstCond1" > 
<ColumnInfo><Column id="PRD_CD" type="STRING" size="256"/><Column id="PRD_NM" type="STRING" size="256"/><Column id="CURR_CD" type="STRING" size="256"/><Column id="CURR_NM" type="STRING" size="256"/><Column id="FUND_TYCD_NM" type="STRING" size="256"/><Column id="FUND_TYCD" type="STRING" size="256"/><Column id="FUND" type="STRING" size="256"/><Column id="FUND_NM" type="STRING" size="256"/><Column id="NEWYMD" type="STRING" size="256"/><Column id="MTYYMD" type="STRING" size="256"/><Column id="FUND_STS" type="STRING" size="256"/><Column id="TERMIN_YMD" type="STRING" size="256"/><Column id="CUST_BR" type="STRING" size="256"/><Column id="ACCT_NO" type="STRING" size="256"/><Column id="RSRV_MTHD_TYCD" type="STRING" size="256"/></ColumnInfo><Rows><Row/></Rows> 
</Dataset>
<Dataset id = "dstList1" > 
<ColumnInfo><Column id="FUND" type="STRING" size="256"/><Column id="ACCT_NO" type="STRING" size="256"/><Column id="IMC" type="STRING" size="256"/><Column id="CUST_YMD" type="STRING" size="256"/><Column id="MTYYMD" type="STRING" size="256"/><Column id="TERMIN_YMD" type="STRING" size="256"/><Column id="CUST_BLNC" type="STRING" size="256"/><Column id="CURR_CD" type="STRING" size="256"/><Column id="PRD_CD" type="STRING" size="256"/><Column id="OPROFIT_YN" type="STRING" size="256"/><Column id="BR" type="STRING" size="256"/><Column id="PROC_BR" type="STRING" size="256"/><Column id="CPRN_BEN_CLNT" type="STRING" size="256"/><Column id="PROFIT_BEN_CLNT" type="STRING" size="256"/><Column id="RSRV_MTHD" type="STRING" size="256"/><Column id="PROFIT_PAY_MTHD" type="STRING" size="256"/><Column id="MLT_ASSET_YN" type="STRING" size="256"/><Column id="TXN_CD" type="STRING" size="256"/><Column id="FUND_STS" type="STRING" size="256"/><Column id="PROFIT_PAY_YMD" type="STRING" size="256"/><Column id="BFTAKE_BEF_TR_AMT" type="STRING" size="256"/><Column id="BFTAKE_FEE_AMT" type="STRING" size="256"/><Column id="BFTAKE_FEE_RATE" type="STRING" size="256"/><Column id="AUTO_OUT_PROPS_YN" type="STRING" size="256"/><Column id="CORE_PRD_CD" type="STRING" size="256"/><Column id="LAST_CHG_DM" type="STRING" size="256"/><Column id="LAST_CHG_ID" type="STRING" size="256"/></ColumnInfo> 
</Dataset>
<Dataset id = "dstCURR_CD" > 
<ColumnInfo><Column id="CD" type="STRING" size="256"/><Column id="NM" type="STRING" size="256"/></ColumnInfo> 
</Dataset>
<Dataset id = "dstFUND_TYCD" > 
<ColumnInfo><Column id="CD" type="STRING" size="256"/><Column id="NM" type="STRING" size="256"/></ColumnInfo> 
</Dataset>
<Dataset id = "dstPRD_CD" > 
<ColumnInfo><Column id="CD" type="STRING" size="256"/><Column id="NM" type="STRING" size="256"/></ColumnInfo> 
</Dataset>
<Dataset id = "dstFUND_STS" > 
<ColumnInfo><Column id="CD" type="STRING" size="256"/><Column id="NM" type="STRING" size="256"/><Column id="ORG_NM" type="STRING" size="256"/></ColumnInfo> 
</Dataset>
        </Objects>/n    <Script type ="xscript5.1"><![CDATA[/n        /**/n
         *  특정금전신탁펀드 관리(3113)/n
         *  @MenuPath	신탁상품 > 신탁상품공통/n
         *  @FileName	TmSpcMnyTrustFundMgr_man01.xfdl/n
         *  @Creator	박선형/n
         *  @CreateDate	2022.04.11/n
         *  @Desction	특정금전신탁펀드 관리(3113)/n
         ************** 소스 수정 이력 ****************************************************/n
         *  date          		Modifier                Description/n
         *******************************************************************************/n
         *  2022.04.11			박선형					최초 생성/n
         *******************************************************************************/n
         *//n
/n
        /************************************************************************************************/n
         * FORM 변수 선언 영역/n
         ************************************************************************************************//n
        //JAVA서비스/n
        const CST_CTL_NAME = "tr/tm/TmSpcMnyTrustFundMgr";/n
/n
        //--코드 데이터 검색 호출값-------------------------------------------------------------------------/n
        const CST_CD_OPEN  = "ON";									   // 화면 오픈 시 한번만 호출/n
        const CST_CD_USER  = "US";									   // 사용자 이름, ID/n
        const CST_CD_FUND   = "FD";/n
/n
        //통합코드/n
        this.fvaGetDtlCodes = [/n
        					    ["FUND_STS"	, this.dstFUND_STS]	//펀드상태/n
        					  ];/n
/n
/n
/n
        /************************************************************************************************/n
         * FORM EVENT 영역(oninit, onload)/n
         ************************************************************************************************//n
        /**/n
         * Form이 처음 초기화할 때 발생하는 이벤트입니다./n
         *//n
        this.TmSpcMnyTrustFundMgr_man01_oninit = function(obj,e)/n
        {/n
        	//통합코드 로드/n
        	this.gfnGetDtlCodes(this.fvaGetDtlCodes);/n
/n
        	// 개별코드 로드/n
        	this.fnGetCodeData();/n
/n
        };/n
/n
        /**/n
         * Form의 모든 컴포넌트가 생성되고, 모든 오브젝트가 로딩되었을 때 발생하는 이벤트입니다./n
         *//n
        this.TmSpcMnyTrustFundMgr_man01_onload = function(obj,e)/n
        {/n
        	this.gfnFormOnLoad();      						// * 필수 : Form 공통 기능 처리 (다국어,그리드)/n
/n
/n
        	//this.fnSetFilterDtlCd();						// 통합코드 필터/n
        	this.fnInitCond1();								// 조회조건 초기화/n
/n
        };/n
/n
        /**/n
         * 조회조건 초기화/n
         *//n
        this.fnInitCond1 = function()/n
        {/n
            //this.msBaseForm.gfnSetWFCurrencyTypeCombo(this.divCond1.form.cboCUR_TYPE, "dstCond1", "CUR_TYPE");   // 조회구분 세팅/n
        	this.gfnGetPrdCdDs(this.dstPRD_CD);   // 자산분류 데이터셋 복사 - 조회조건부용/n
/n
           //통화코드/n
            this.gfnCopyCurrency(this.dstCURR_CD);/n
/n
        	//신탁 관련 상품 코드 - 펀드분류/n
        	this.gfnGetTrustPrdCdDs(this.dstFUND_TYCD);/n
/n
        	this.fnSetGrdView(this.divList1.form.btnAllView);/n
        };/n
/n
/n
/n
        /************************************************************************************************/n
         * CALLBACK 콜백 처리부분(Transaction, Popup)/n
         ************************************************************************************************//n
        /**/n
         * @desc 폼 Transaction Callback 함수/n
         *//n
        this.fnCallBackTran = function(psSvcId, psErrCode, psErrMsg)/n
        {/n
        	//오류 시 리턴(트랜젝션 오류 시 공통 함수에서 에러 메시지박스 Display)/n
            if(psErrCode < 0)/n
            {/n
        		this.gfnSetEnableCond(this.divCond1, true);	//조회조건 활성화/n
                return false;/n
            }/n
/n
            switch(psSvcId)/n
            {/n
                case "lst1":/n
        			//조회조건 활성화/n
        			this.gfnSetEnableCond(this.divCond1, true);/n
/n
        			//총건수 설정/n
        			this.gfnApplyTotalCount(this.grdList1, this.staTotCnt1);/n
/n
        			break;/n
        		case "sav1" + this.CONST_IOMODE_INSERT:/n
        		case "sav1" + this.CONST_IOMODE_UPDATE:/n
        		case "sav1" + this.CONST_IOMODE_DELETE:/n
        			//입력,수정,삭제 후 재조회/n
        			this.btnSel_onclick();/n
        			break;/n
        	}/n
        };/n
/n
        /**/n
         * @desc 코드 조회 CallBack/n
         * @param {String} psSvcId - 서비스 아이디/n
         * @param {String} psErrCode - 에러 코드/n
         * @param {String} psErrMsg - 에러 메세지/n
         *//n
        this.fnEachCodeCallback = function(psSvcId, psErrCode, psErrMsg)/n
        {/n
        	//오류 시 리턴(트랜젝션 오류 시 공통 함수에서 메시지박스 Display)/n
        	if(psErrCode < 0)/n
        	{/n
        		return false;/n
        	}/n
/n
        	switch(psSvcId)/n
        	{/n
        	}/n
        };/n
/n
        /**/n
         * 개별 SQL코드성 데이터 로드/n
         *//n
        this.fnGetCodeData = function(psGb)/n
        {/n
        	if ( this.gfnIsNull(psGb) ) psGb = CST_CD_OPEN;/n
/n
        	var sFuncCallback = "fnEachCodeCallback";/n
/n
        	switch(psGb)/n
        	{/n
        		case CST_CD_OPEN :/n
        			this.fnGetCodeData(CST_CD_USER);/n
        			break;/n
        		case CST_CD_USER :/n
                    this.gfnGetEachCode("AP_USER", [], this.dstUSER_ID, CST_CD_USER, this.fnEachCodeCallback, false);	  	// 사용자 이름, ID/n
        			break;/n
/n
        	}/n
        }/n
/n
        /************************************************************************************************/n
         * CRUD 및 TRANSACTION 서비스 호출 처리/n
         ************************************************************************************************//n
        /**/n
         * 조회버튼 CLICK/n
         *//n
        this.btnSel_onclick = function(obj)/n
        {/n
        	// 필수 조건 check/n
        	if(this.fnValChk("lst") == false)/n
        	{/n
        		return false;/n
        	}/n
/n
        	// grid head title원복/n
            this.gfnGridHeadTitleRecovery(this.grdList1);/n
/n
        	// grid 입력 안되도록 설정/n
            this.grdList1.set_readonly(true);/n
/n
        	// 조회조건 비활성화/n
        	this.gfnSetEnableCond(this.divCond1, false);/n
/n
        	// 화면의 IO모드 조회로 변경/n
        	this.gfnSetIOmode(this.CONST_IOMODE_SEARCH);/n
/n
        	// 조회 transaction/n
            this.gfnTrx("lst1", CST_CTL_NAME, this.CONST_TRANS_LIST, "dstCond1", "", "dstList1", "", false, "", "");/n
/n
/n
        };/n
/n
        /**/n
         * 입력버튼 CLICK/n
         *//n
        this.btnIns_onclick = function(obj)/n
        {/n
        	// IO모드가 입력이 아닌경우/n
        	if(this.gfnGetIOmode() != this.CONST_IOMODE_INSERT)/n
        	{/n
        		// 조회조건 비활성화/n
        		this.gfnSetEnableCond(this.divCond1, false);/n
/n
        		// 화면의 IO모드 입력으로 변경/n
        		this.gfnSetIOmode(this.CONST_IOMODE_INSERT);/n
/n
        		// 그리드 접고 펼치기 설정/n
        		this.fnSetGrdView();/n
        	}/n
/n
        	// 체크박스 초기화/n
        	this.gfnChkClear(this.dstList1);/n
/n
        	// 그리드에 신규 row 삽입/n
        	this.gfnInsertRow(this.dstList1, this.dstList1.rowposition + 1);/n
/n
        	// 상세영역 활성화/n
        	this.gfnSetEnable(this.divDetail1, this.CONST_IOMODE_INSERT);/n
/n
        	// 입력부 컴포넌트 활성화/비활성화 설정/n
        	this.fnSetCompEnable();/n
        };/n
/n
        /**/n
         * 수정버튼 CLICK/n
         *//n
        this.btnUpd_onclick = function(obj)/n
        {/n
        	// 그리드에 데이터가 한건도 없으면 return/n
        	if(this.dstList1.getRowCount() == 0)/n
        	{/n
        		return false;/n
        	}/n
/n
        	// 조회조건 비활성화/n
        	this.gfnSetEnableCond(this.divCond1, false);/n
/n
        	// 화면의 IO모드 수정으로 변경/n
        	this.gfnSetIOmode(this.CONST_IOMODE_UPDATE);/n
/n
        	// 체크박스 초기화/n
        	this.gfnChkClear(this.dstList1);/n
/n
        	// 그리드 접고 펼치기 설정/n
        	this.fnSetGrdView();/n
/n
        	// 상세영역 활성화/n
        	this.gfnSetEnable(this.divDetail1, this.CONST_IOMODE_UPDATE);/n
/n
        	// 입력부 컴포넌트 활성화/비활성화 설정/n
        	this.fnSetCompEnable();/n
/n
        };/n
/n
        /**/n
         * 삭제버튼 CLICK/n
         *//n
        this.btnDel_onclick = function(obj)/n
        {/n
        	// 그리드에 데이터가 한건도 없으면 return/n
        	if(this.dstList1.getRowCount() == 0)/n
        	{/n
        		return false;/n
        	}/n
/n
        	// 선택된 데이터 있는지 여부 체크/n
        	if(this.dstList1.getMax("CHK") != "1")/n
        	{/n
        		this.gfnAlert("WCMSY001");	/** WCMSY001 : 선택된 데이터가 없습니다. *//n
        		return false;/n
        	}/n
/n
        	this.gfnAlert("삭제서비스 실행!.");/n
        };/n
/n
        /**/n
         * 저장버튼 CLICK/n
         *//n
        this.btnSav_onclick = function(obj)/n
        {/n
        	this.gfnAlert("저장서비스 실행!.");/n
        	this.btnSel_onclick();/n
        };/n
/n
/n
        /************************************************************************************************/n
         * 사용자 FUNCTION 영역/n
         ************************************************************************************************//n
        /**/n
         * @desc 통합코드 필터/n
         *//n
        this.fnSetFilterDtlCd = function()/n
        {/n
        	//통합코드필터/n
        	this.dstEST_CURR_TYCD.filter("CD=='ITEM'||CD=='ISIN'||CD=='TICKER'||CD=='SEDOL'||CD=='CUSIP'");	//증권ID유형/n
        };/n
/n
        /**/n
         * @desc 일자설정 : 조회일/n
         *//n
        this.fnSetWkymd = function()/n
        {/n
        	//조회일/n
        	var sWkymd = this.gfnGetWorkDateAcctCond("00001", "0000000001");/n
/n
        	this.dstCond1.setColumn(0, "STDYMD", sWkymd);	//조회시작일/n
        };/n
/n
        /**/n
         * @desc Validation 체크/n
         *//n
        this.fnValChk = function(psType)/n
        {/n
        	switch(psType.toUpperCase())/n
        	{/n
        		case "LST":/n
        			//조회일 체크/n
        			if(this.gfnIsDate(this.gfnTrim(this.dstCond1.getColumn(0, "STDYMD"))) == false)/n
        			{/n
        				this.gfnAlert("WCMSY006", ["체결일"]);	/* WCMSY006: [{0}]을(를) 입력하세요. *//n
        				this.divCond1.form.calSTDYMD.setFocus();/n
        				return false;/n
        			}/n
        	}/n
/n
        	return true;/n
        };/n
/n
        this.fnSetGrdView = function(obj,e)/n
        {/n
        	this.gfnSetGrdView(obj.parent.parent,1205);/n
        };/n
/n
        /************************************************************************************************/n
         * 각 COMPONENT 별 EVENT 영역/n
         ************************************************************************************************//n
        /**/n
         * @desc 그리드 grdList1 oncellclick 이벤트/n
         * @param {nexacro.Grid} obj - Grid/n
         * @param {nexacro.GridClickEventInfo} e - GridClickEventInfo/n
         *//n
        this.divGrid_grdList1_oncellclick = function(obj,e)/n
        {/n
        	var oDst = obj.getBindDataset();/n
/n
        	// 조회/수정모드에서는 선택가능/n
        	// 입력에서는 DATASET ROWTYPE 이 추가된 행인 경우에만 선택가능/n
        	if( ((this.gfnGetIOmode() == this.CONST_IOMODE_SEARCH || this.gfnGetIOmode() == this.CONST_IOMODE_UPDATE) ||/n
        		 (this.gfnGetIOmode() == this.CONST_IOMODE_INSERT && oDst.getRowType(e.row) == Dataset.ROWTYPE_INSERT)/n
        		 )  && e.cell == obj.getBindCellIndex("body", "CHK"))/n
        	{/n
        		if (oDst.getColumn(e.row, "CHK") == 1)/n
        		{/n
        			oDst.setColumn(e.row, "CHK", 0);/n
        		}/n
        		else/n
        		{/n
        			oDst.setColumn(e.row, "CHK", 1);/n
        		}/n
        	}/n
        };/n
/n
        /**/n
         * @desc 그리드 grdList1 oncelldblclick 이벤트/n
         * @param {nexacro.Grid} obj - Grid/n
         * @param {nexacro.GridClickEventInfo} e - GridClickEventInfo/n
         *//n
        this.divGrid_grdList1_oncelldblclick = function(obj,e)/n
        {/n
        	//그리드 접고 펼치기 설정/n
        	//this.fnSetGrdView();/n
        };/n
/n
        /**/n
         * @desc 데이터셋 dstCond1 oncolumnchanged 이벤트/n
         * @param {nexacro.NormalDataset} obj - NormalDataset/n
         * @param {nexacro.DSColChangeEventInfo} e - DSColChangeEventInfo/n
         *//n
        this.dstCond1_oncolumnchanged = function(obj,e)/n
        {/n
        	switch(String(e.columnid).toUpperCase())/n
        	{/n
        		case "AC_TY":/n
                 if(e.newvalue == 1)/n
                 {/n
                    this.divCond1.form.ucbAC_CD.fnInnerFilter("CD=='KRW'");/n
                 }/n
                 else/n
                 {/n
                    this.divCond1.form.ucbAC_CD.fnInnerFilter();/n
                 }/n
                 break;/n
/n
              case "SC_TY":/n
                 if(e.newvalue == 1)/n
                 {/n
                    this.divCond1.form.ucbSC_CD.fnInnerFilter("CD=='KRW'");/n
                 }/n
                 else/n
                 {/n
                    this.divCond1.form.ucbSC_CD.fnInnerFilter();/n
                 }/n
                 break;/n
/n
        	 case "ITEM_LIST":		//증권종목/n
        			//this.divCond1.form.ucbCURR_CD.fnSetCode(this.divCond1.form.ucbITEM.fnGetColValue("CURR_CD"));	//종목 콤보 초기화/n
        			this.divCond1.form.edtITEM_CURR_CD.set_value(this.divCond1.form.ucbITEM.fnGetColValue("CURR_CD"));/n
         			break;/n
        	}/n
        };/n
/n
        /**/n
         * @desc 데이터셋 dstList1 onrowposchanged 이벤트/n
         * @param {nexacro.NormalDataset} obj - NormalDataset/n
         * @param {nexacro.DSRowPosChangeEventInfo} e - DSRowPosChangeEventInfo/n
         *//n
        this.dstList1_onrowposchanged = function(obj,e)/n
        {/n
        	var bStat = this.dstList1.enableevent;/n
        	this.dstList1.set_enableevent(false);/n
/n
        	//상세영역 enable 처리/n
        	this.gfnSetEnable(this.divDetail1, this.gfnGetIOmode());/n
/n
        	//입력부 컴포넌트 활성화/비활성화 설정/n
        	this.fnSetCompEnable();/n
/n
        	if(this.dstList2.getRowCount() > 0)/n
        	{/n
        		this.dstList2.clearData();/n
/n
        		//총건수 설정/n
        		//this.gfnApplyTotalCount(this.tabMain.tabPage2.form.grdList3, this.tabMain.tabPage2.form.staTotCnt2);/n
        	}/n
/n
        	this.dstList1.set_enableevent(bStat);/n
        };/n
/n
        /**/n
         * @desc 데이터셋 dstList1 onrowsetchanged 이벤트/n
         * @param {nexacro.NormalDataset} obj - NormalDataset/n
         * @param {nexacro.DSRowsetChangeEventInfo} e - DSRowsetChangeEventInfo/n
         *//n
        this.dstList1_onrowsetchanged = function(obj,e)/n
        {/n
        	if(e.reason == Dataset.REASON_APPEND)/n
        	{/n
        		obj.set_rowposition(e.row);	//ROW포지션 변경/n
/n
        		var bStat = obj.enableevent;/n
        		obj.set_enableevent(false);/n
/n
        		var sStdymd			= this.dstCond1.getColumn(0, "STDYMD");/n
        		var sItem			= this.dstCond1.getColumn(0, "ITEM");/n
/n
        		//수신기관/n
        		if(this.gfnIsE4C(sFirm) == false)/n
        		{/n
        			this.divDetail1.form.ucbFIRM.fnSetCode(sFirm);/n
        		}/n
/n
        		//기준일/n
        		if(this.gfnIsDate(this.gfnTrim(sStdYmd)) == true)/n
        		{/n
        			obj.setColumn(e.row, "STDYMD", sStdYmd);/n
        		}/n
/n
        		obj.set_enableevent(bStat);/n
        	}/n
        };/n
/n
        /**/n
         * @desc 데이터셋 dstList1 canrowposchange 이벤트/n
         * @param {nexacro.NormalDataset} obj - NormalDataset/n
         * @param {nexacro.DSRowPosChangeEventInfo} e - DSRowPosChangeEventInfo/n
         *//n
        this.dstList1_canrowposchange = function(obj,e)/n
        {/n
/n
        };/n
/n
/n
/n
        });/n
        /n
    ]]></script>/n    </Form>/n