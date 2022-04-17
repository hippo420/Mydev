import java.util.List;

public class Metadata {
    List<Dataset> datasets;
    List<Comp> comps;
    List<EventInfo> eventInfos;
    List<String> codes;
    public List<Dataset> getDatasets() {
        return datasets;
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

    public List<Comp> getComps() {
        return comps;
    }

    public void setComps(List<Comp> comps) {
        this.comps = comps;
    }

    public List<EventInfo> getEventInfos() {
        return eventInfos;
    }

    public void setEventInfos(List<EventInfo> eventInfos) {
        this.eventInfos = eventInfos;
    }

    public Metadata(List<Dataset> datasets, List<Comp> comps, List<EventInfo> eventInfos, List<String> codes) {
        this.datasets = datasets;
        this.comps = comps;
        this.eventInfos = eventInfos;
        this.codes = codes;
    }
}
