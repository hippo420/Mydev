import java.util.List;

public class Metadata {
    List<Form> forms;
    List<Dataset> datasets;
    List<UComp> ucomps;
    List<EventInfo> eventInfos;
    List<String> codes;
    List<String> depths;
    public List<Dataset> getDatasets() {
        return datasets;
    }

    public Metadata(List<Form> forms, List<Dataset> datasets, List<UComp> ucomps, List<EventInfo> eventInfos, List<String> codes, List<String> depths) {
        this.forms=forms;
        this.datasets = datasets;
        this.ucomps = ucomps;
        this.eventInfos = eventInfos;
        this.codes = codes;
        this.depths = depths;
    }

    public List<String> getDepths() {
        return depths;
    }

    public void setDepths(List<String> depths) {
        this.depths = depths;
    }

    public List<Form> getForms() {
        return forms;
    }

    public void setForms(List<Form> forms) {
        this.forms = forms;
    }

    public List<UComp> getUcomps() {
        return ucomps;
    }

    public void setUcomps(List<UComp> ucomps) {
        this.ucomps = ucomps;
    }

    public List<String> getCodes() {
        return codes;
    }

    public void setCodes(List<String> codes) {
        this.codes = codes;
    }

    public void setDatasets(List<Dataset> datasets) {
        this.datasets = datasets;
    }



    public List<EventInfo> getEventInfos() {
        return eventInfos;
    }

    public void setEventInfos(List<EventInfo> eventInfos) {
        this.eventInfos = eventInfos;
    }


}
