public class Comp {

    //공통정보
    public String compname;
    public String name;
    public String info;
    public String parents;

    public Comp(String compname, String name, String info, String parents) {
        this.compname =compname;
        this.name = name;
        this.info = info;
        this.parents = parents;
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
