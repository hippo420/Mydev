public class Dataset {
    String name;
    String info;
    String colInfo;

    public Dataset(String name, String colInfo, String info) {
        this.name = name;
        this.colInfo = colInfo;
        this.info = info;
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

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
    
    
}
