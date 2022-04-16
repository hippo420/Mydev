public class Dataset {
    String name;
    String colInfo;

    public Dataset(String name, String colInfo) {
        this.name = name;
        this.colInfo = colInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColInfo() {
        return colInfo;
    }

    public void setColInfo(String colInfo) {
        this.colInfo = colInfo;
    }
}
