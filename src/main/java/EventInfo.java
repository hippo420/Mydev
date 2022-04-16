public class EventInfo {

    public String compname;
    public String eventtype;
    public String eventname;

    public String getCompname() {
        return compname;
    }

    public void setCompname(String compname) {
        this.compname = compname;
    }

    public String getEventtype() {
        return eventtype;
    }

    public void setEventtype(String eventtype) {
        this.eventtype = eventtype;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public EventInfo(String compname, String eventtype, String eventname) {
        this.compname = compname;
        this.eventtype = eventtype;
        this.eventname = eventname;
    }
}
