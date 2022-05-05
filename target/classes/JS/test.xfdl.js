(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("ioio");
            this.set_titletext("New Form");
            this.set_scrollbartype("auto");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("Dataset00", this);
            obj._setContents("<ColumnInfo><ConstColumn id=\"ConstColumn0\" type=\"STRING\" size=\"30\"/><ConstColumn id=\"ConstColumn1\" type=\"STRING\" size=\"30\"/><Column id=\"Column0\" type=\"STRING\" size=\"256\"/><Column id=\"Column1\" type=\"STRING\" size=\"256\"/><Column id=\"Column2\" type=\"STRING\" size=\"256\"/><Column id=\"Column3\" type=\"STRING\" size=\"256\"/><Column id=\"Column4\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Div("Div00","12","4","558","55",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("Div00");
            this.addChild(obj.name, obj);

            obj = new Combo("Combo00","32","20","147","25",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("0");
            obj.set_text("Combo00");
            this.Div00.addChild(obj.name, obj);

            obj = new Div("Div00_0","296","19","168","29",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("1");
            obj.set_text("Div00");
            this.Div00.addChild(obj.name, obj);

            obj = new Div("Div00_0_0","37","10","113","16",null,null,null,null,null,null,this.Div00.form.Div00_0.form);
            obj.set_taborder("0");
            obj.set_text("Div00");
            this.Div00.form.Div00_0.addChild(obj.name, obj);

            obj = new Div("Div01","10","77","417","133",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("Div01");
            this.addChild(obj.name, obj);

            obj = new Grid("Grid00","23","18","364","98",null,null,null,null,null,null,this.Div01.form);
            obj.set_taborder("0");
            obj._setContents("");
            this.Div01.addChild(obj.name, obj);

            obj = new Button("Button00","499","91",null,null,"23","43","100","102","101","103",this);
            obj.set_taborder("2");
            obj.set_text("testsdfsdf");
            obj.set_positionstep("1");
            this.addChild(obj.name, obj);

            obj = new Grid("Grid00","40","223","354","170",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_binddataset("Dataset00");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"ConstColumn0\"/><Cell col=\"1\" text=\"ConstColumn1\"/><Cell col=\"2\" text=\"Column0\"/><Cell col=\"3\" text=\"Column1\"/><Cell col=\"4\" text=\"Column2\"/><Cell col=\"5\" text=\"Column3\"/><Cell col=\"6\" text=\"Column4\"/></Band><Band id=\"body\"><Cell text=\"bind:ConstColumn0\" edittype=\"combo\" displaytype=\"combotext\"/><Cell col=\"1\" text=\"bind:ConstColumn1\"/><Cell col=\"2\" text=\"bind:Column0\"/><Cell col=\"3\" text=\"bind:Column1\"/><Cell col=\"4\" text=\"bind:Column2\"/><Cell col=\"5\" text=\"bind:Column3\"/><Cell col=\"6\" text=\"bind:Column4\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Tab("Tab00","463","114","150","100",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            obj.set_tabindex("0");
            this.addChild(obj.name, obj);

            obj = new Tabpage("Tabpage1",this.Tab00);
            obj.set_text("Tabpage1");
            this.Tab00.addChild(obj.name, obj);

            obj = new Tabpage("Tabpage2",this.Tab00);
            obj.set_text("Tabpage2");
            this.Tab00.addChild(obj.name, obj);

            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",1280,720,this,function(p){});
            this.addLayout(obj.name, obj);
            
            // BindItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("ioio.xfdl", function() {

        this.Div01_Grid00_cantreestatuschange = function(obj,e)
        {

        };

        this.Dataset00_oncolumnchanged = function(obj,e)
        {

        };


        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.Div01.form.Grid00.addEventHandler("cantreestatuschange",this.Div01_Grid00_cantreestatuschange,this);
            this.Dataset00.addEventHandler("oncolumnchanged",this.Dataset00_oncolumnchanged,this);
        };

        this.loadIncludeScript("ioio.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
