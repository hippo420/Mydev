public class EventInfo {

    public String compname;
    public String eventname;
    public String eventtype;

    public String getCompname() {
        return compname;
    }

    public void setCompname(String compname) {
        this.compname = compname;
    }


    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getEventtype() {
        return eventtype;
    }

    public void setEventtype(String eventtype) {
        this.eventtype = eventtype;
    }

    public EventInfo(String compname, String eventtype, String eventname) {
        this.compname = compname;
        this.eventtype = eventtype;
        this.eventname = eventname;
    }
}
