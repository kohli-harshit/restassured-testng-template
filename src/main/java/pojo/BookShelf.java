package pojo;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "kind",
        "id",
        "selfLink",
        "title",
        "access",
        "updated",
        "created",
        "volumeCount",
        "volumesLastUpdated"
})
public class BookShelf {
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("selfLink")
    private String selfLink;
    @JsonProperty("title")
    private String title;
    @JsonProperty("access")
    private String access;
    @JsonProperty("updated")
    private String updated;
    @JsonProperty("created")
    private String created;
    @JsonProperty("volumeCount")
    private Integer volumeCount;
    @JsonProperty("volumesLastUpdated")
    private String volumesLastUpdated;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("selfLink")
    public String getSelfLink() {
        return selfLink;
    }

    @JsonProperty("selfLink")
    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("access")
    public String getAccess() {
        return access;
    }

    @JsonProperty("access")
    public void setAccess(String access) {
        this.access = access;
    }

    @JsonProperty("updated")
    public String getUpdated() {
        return updated;
    }

    @JsonProperty("updated")
    public void setUpdated(String updated) {
        this.updated = updated;
    }

    @JsonProperty("created")
    public String getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(String created) {
        this.created = created;
    }

    @JsonProperty("volumeCount")
    public Integer getVolumeCount() {
        return volumeCount;
    }

    @JsonProperty("volumeCount")
    public void setVolumeCount(Integer volumeCount) {
        this.volumeCount = volumeCount;
    }

    @JsonProperty("volumesLastUpdated")
    public String getVolumesLastUpdated() {
        return volumesLastUpdated;
    }

    @JsonProperty("volumesLastUpdated")
    public void setVolumesLastUpdated(String volumesLastUpdated) {
        this.volumesLastUpdated = volumesLastUpdated;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
