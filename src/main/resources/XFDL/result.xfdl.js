<?xml version="1.0" encoding="utf-8"?><FDL version="2.1"><Form {formInfo}>{layouts}<Objects><Dataset id = "dstCond1" > 
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
</Objects><Script type ="xscript5.1"><![CDATA[/**
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

]]></script></Form>