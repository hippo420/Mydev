public class Form {
    public String id;
    public String width;
    public String height;
    public String info;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }



    public Form(String id, String width, String height, String info) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.info = info;
    }
}
