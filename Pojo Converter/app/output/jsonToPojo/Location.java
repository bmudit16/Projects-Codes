
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
    "current Location",
    "Home Town"
})
@Generated("jsonschema2pojo")
public class Location {

    @JsonProperty("current Location")
    private String currentLocation;
    @JsonProperty("Home Town")
    private String homeTown;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("current Location")
    public String getCurrentLocation() {
        return currentLocation;
    }

    @JsonProperty("current Location")
    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Location withCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
        return this;
    }

    @JsonProperty("Home Town")
    public String getHomeTown() {
        return homeTown;
    }

    @JsonProperty("Home Town")
    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public Location withHomeTown(String homeTown) {
        this.homeTown = homeTown;
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

    public Location withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Location.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("currentLocation");
        sb.append('=');
        sb.append(((this.currentLocation == null)?"<null>":this.currentLocation));
        sb.append(',');
        sb.append("homeTown");
        sb.append('=');
        sb.append(((this.homeTown == null)?"<null>":this.homeTown));
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
        result = ((result* 31)+((this.homeTown == null)? 0 :this.homeTown.hashCode()));
        result = ((result* 31)+((this.currentLocation == null)? 0 :this.currentLocation.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Location) == false) {
            return false;
        }
        Location rhs = ((Location) other);
        return ((((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties)))&&((this.homeTown == rhs.homeTown)||((this.homeTown!= null)&&this.homeTown.equals(rhs.homeTown))))&&((this.currentLocation == rhs.currentLocation)||((this.currentLocation!= null)&&this.currentLocation.equals(rhs.currentLocation))));
    }

}
