
package jsonToPojo;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Highest Qualification",
    "Branch"
})
@Generated("jsonschema2pojo")
public class Education {

    @JsonProperty("Highest Qualification")
    private String highestQualification;
    @JsonProperty("Branch")
    private String branch;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Highest Qualification")
    public String getHighestQualification() {
        return highestQualification;
    }

    @JsonProperty("Highest Qualification")
    public void setHighestQualification(String highestQualification) {
        this.highestQualification = highestQualification;
    }

    public Education withHighestQualification(String highestQualification) {
        this.highestQualification = highestQualification;
        return this;
    }

    @JsonProperty("Branch")
    public String getBranch() {
        return branch;
    }

    @JsonProperty("Branch")
    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Education withBranch(String branch) {
        this.branch = branch;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Education withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Education.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("highestQualification");
        sb.append('=');
        sb.append(((this.highestQualification == null)?"<null>":this.highestQualification));
        sb.append(',');
        sb.append("branch");
        sb.append('=');
        sb.append(((this.branch == null)?"<null>":this.branch));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.highestQualification == null)? 0 :this.highestQualification.hashCode()));
        result = ((result* 31)+((this.branch == null)? 0 :this.branch.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Education) == false) {
            return false;
        }
        Education rhs = ((Education) other);
        return ((((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties)))&&((this.highestQualification == rhs.highestQualification)||((this.highestQualification!= null)&&this.highestQualification.equals(rhs.highestQualification))))&&((this.branch == rhs.branch)||((this.branch!= null)&&this.branch.equals(rhs.branch))));
    }

}
