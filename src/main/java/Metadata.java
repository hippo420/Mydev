import java.util.List;

public class Metadata {
    List<Form> forms;
    List<Dataset> datasets;
    List<UComp> ucomps;
    List<EventInfo> eventInfos;
    List<String> codes;
    public List<Dataset> getDatasets() {
        return datasets;
    }

    public Metadata(List<Form> forms, List<Dataset> datasets, List<UComp> ucomps, List<EventInfo> eventInfos, List<String> codes) {
        this.forms=forms;
        this.datasets = datasets;
        this.ucomps = ucomps;
        this.eventInfos = eventInfos;
        this.codes = codes;
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
