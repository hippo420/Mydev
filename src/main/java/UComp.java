public class UComp {
    public String type;
    public String id;
    public String left;
    public String top;
    public String width;
    public String height;
    public String right;
    public String bottom;
    public String minwidth;
    public String maxwidth;
    public String minheight;
    public String maxheight;
    public String parents;
    public String info;

    
    
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UComp(String type, String id, String left, String top, String width, String height, String right, String bottom, String minwidth, String maxwidth, String minheight, String maxheight, String info,String parents ) {
        this.type = type;
        this.id = id;
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
        this.right = right;
        this.bottom = bottom;
        this.minwidth = minwidth;
        this.maxwidth = maxwidth;
        this.minheight = minheight;
        this.maxheight = maxheight;
        this.parents = parents;
        this.info = info;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
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

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    public String getMinwidth() {
        return minwidth;
    }

    public void setMinwidth(String minwidth) {
        this.minwidth = minwidth;
    }

    public String getMaxwidth() {
        return maxwidth;
    }

    public void setMaxwidth(String maxwidth) {
        this.maxwidth = maxwidth;
    }

    public String getMinheight() {
        return minheight;
    }

    public void setMinheight(String minheight) {
        this.minheight = minheight;
    }

    public String getMaxheight() {
        return maxheight;
    }

    public void setMaxheight(String maxheight) {
        this.maxheight = maxheight;
    }

    public String getParents() {
        return parents;
    }

    public void setParents(String parents) {
        this.parents = parents;
    }
}
