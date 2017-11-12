
package pojo.bookshelf;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "country",
    "saleability",
    "isEbook",
    "listPrice",
    "retailPrice",
    "buyLink"
})
public class SaleInfo {

    @JsonProperty("country")
    private String country;
    @JsonProperty("saleability")
    private String saleability;
    @JsonProperty("isEbook")
    private Boolean isEbook;
    @JsonProperty("listPrice")
    private ListPrice listPrice;
    @JsonProperty("retailPrice")
    private RetailPrice retailPrice;
    @JsonProperty("buyLink")
    private String buyLink;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("saleability")
    public String getSaleability() {
        return saleability;
    }

    @JsonProperty("saleability")
    public void setSaleability(String saleability) {
        this.saleability = saleability;
    }

    @JsonProperty("isEbook")
    public Boolean getIsEbook() {
        return isEbook;
    }

    @JsonProperty("isEbook")
    public void setIsEbook(Boolean isEbook) {
        this.isEbook = isEbook;
    }

    @JsonProperty("listPrice")
    public ListPrice getListPrice() {
        return listPrice;
    }

    @JsonProperty("listPrice")
    public void setListPrice(ListPrice listPrice) {
        this.listPrice = listPrice;
    }

    @JsonProperty("retailPrice")
    public RetailPrice getRetailPrice() {
        return retailPrice;
    }

    @JsonProperty("retailPrice")
    public void setRetailPrice(RetailPrice retailPrice) {
        this.retailPrice = retailPrice;
    }

    @JsonProperty("buyLink")
    public String getBuyLink() {
        return buyLink;
    }

    @JsonProperty("buyLink")
    public void setBuyLink(String buyLink) {
        this.buyLink = buyLink;
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
