import com.mysql.cj.util.DnsSrv;

public class Comp {

    //공통정보
    public String compname;
    public String name;
    public String info;
    public String parents;
    public String ptop;
    public String pleft;
    public String pright;
    public String pbottom;
    public String prop1;
    public String prop2;
    public String prop3;
    public String prop4;
    public String prop5;
    public String prop6;

    public String getProp1() {
        return prop1;
    }

    public void setProp1(String prop1) {
        this.prop1 = prop1;
    }

    public String getProp2() {
        return prop2;
    }

    public void setProp2(String prop2) {
        this.prop2 = prop2;
    }

    public String getProp3() {
        return prop3;
    }

    public void setProp3(String prop3) {
        this.prop3 = prop3;
    }

    public String getProp4() {
        return prop4;
    }

    public void setProp4(String prop4) {
        this.prop4 = prop4;
    }

    public String getProp5() {
        return prop5;
    }

    public void setProp5(String prop5) {
        this.prop5 = prop5;
    }

    public String getProp6() {
        return prop6;
    }

    public void setProp6(String prop6) {
        this.prop6 = prop6;
    }


    public Comp(String name, String parents, String ptop, String pleft, String pright, String pbottom, String prop1, String prop2, String prop3, String prop4, String prop5, String prop6) {
        this.name = name;
        this.parents = parents;
        this.ptop = ptop;
        this.pleft = pleft;
        this.pright = pright;
        this.pbottom = pbottom;
        this.prop1 = prop1;
        this.prop2 = prop2;
        this.prop3 = prop3;
        this.prop4 = prop4;
        this.prop5 = prop5;
        this.prop6 = prop6;
    }

    public Comp(String compname, String name, String info, String parents, String ptop, String pleft, String pright, String pbottom) {
        this.compname = compname;
        this.name = name;
        this.info = info;
        this.parents = parents;
        this.ptop = ptop;
        this.pleft = pleft;
        this.pright = pright;
        this.pbottom = pbottom;
    }

    public String getPtop() {
        return ptop;
    }

    public void setPtop(String ptop) {
        this.ptop = ptop;
    }

    public String getPleft() {
        return pleft;
    }

    public void setPleft(String pleft) {
        this.pleft = pleft;
    }

    public String getPright() {
        return pright;
    }

    public void setPright(String pright) {
        this.pright = pright;
    }

    public String getPbottom() {
        return pbottom;
    }

    public void setPbottom(String pbottom) {
        this.pbottom = pbottom;
    }

    public String getCompname() {
        return compname;
    }

    public void setCompname(String compname) {
        this.compname = compname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getParents() {
        return parents;
    }

    public void setParents(String parents) {
        this.parents = parents;
    }
}
