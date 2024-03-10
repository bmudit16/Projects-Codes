
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
    "First Name",
    "LastName",
    "Gender",
    "Profession",
    "Experience (inYears)",
    "location",
    "Education"
})
@Generated("jsonschema2pojo")
public class CandidateDetails {

    @JsonProperty("First Name")
    private String firstName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("Gender")
    private String gender;
    @JsonProperty("Profession")
    private String profession;
    @JsonProperty("Experience (inYears)")
    private Integer experienceInYears;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("Education")
    private Education education;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("First Name")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("First Name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public CandidateDetails withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @JsonProperty("LastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("LastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public CandidateDetails withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @JsonProperty("Gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("Gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    public CandidateDetails withGender(String gender) {
        this.gender = gender;
        return this;
    }

    @JsonProperty("Profession")
    public String getProfession() {
        return profession;
    }

    @JsonProperty("Profession")
    public void setProfession(String profession) {
        this.profession = profession;
    }

    public CandidateDetails withProfession(String profession) {
        this.profession = profession;
        return this;
    }

    @JsonProperty("Experience (inYears)")
    public Integer getExperienceInYears() {
        return experienceInYears;
    }

    @JsonProperty("Experience (inYears)")
    public void setExperienceInYears(Integer experienceInYears) {
        this.experienceInYears = experienceInYears;
    }

    public CandidateDetails withExperienceInYears(Integer experienceInYears) {
        this.experienceInYears = experienceInYears;
        return this;
    }

    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    public CandidateDetails withLocation(Location location) {
        this.location = location;
        return this;
    }

    @JsonProperty("Education")
    public Education getEducation() {
        return education;
    }

    @JsonProperty("Education")
    public void setEducation(Education education) {
        this.education = education;
    }

    public CandidateDetails withEducation(Education education) {
        this.education = education;
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

    public CandidateDetails withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CandidateDetails.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("firstName");
        sb.append('=');
        sb.append(((this.firstName == null)?"<null>":this.firstName));
        sb.append(',');
        sb.append("lastName");
        sb.append('=');
        sb.append(((this.lastName == null)?"<null>":this.lastName));
        sb.append(',');
        sb.append("gender");
        sb.append('=');
        sb.append(((this.gender == null)?"<null>":this.gender));
        sb.append(',');
        sb.append("profession");
        sb.append('=');
        sb.append(((this.profession == null)?"<null>":this.profession));
        sb.append(',');
        sb.append("experienceInYears");
        sb.append('=');
        sb.append(((this.experienceInYears == null)?"<null>":this.experienceInYears));
        sb.append(',');
        sb.append("location");
        sb.append('=');
        sb.append(((this.location == null)?"<null>":this.location));
        sb.append(',');
        sb.append("education");
        sb.append('=');
        sb.append(((this.education == null)?"<null>":this.education));
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
        result = ((result* 31)+((this.profession == null)? 0 :this.profession.hashCode()));
        result = ((result* 31)+((this.firstName == null)? 0 :this.firstName.hashCode()));
        result = ((result* 31)+((this.lastName == null)? 0 :this.lastName.hashCode()));
        result = ((result* 31)+((this.education == null)? 0 :this.education.hashCode()));
        result = ((result* 31)+((this.gender == null)? 0 :this.gender.hashCode()));
        result = ((result* 31)+((this.experienceInYears == null)? 0 :this.experienceInYears.hashCode()));
        result = ((result* 31)+((this.location == null)? 0 :this.location.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CandidateDetails) == false) {
            return false;
        }
        CandidateDetails rhs = ((CandidateDetails) other);
        return (((((((((this.profession == rhs.profession)||((this.profession!= null)&&this.profession.equals(rhs.profession)))&&((this.firstName == rhs.firstName)||((this.firstName!= null)&&this.firstName.equals(rhs.firstName))))&&((this.lastName == rhs.lastName)||((this.lastName!= null)&&this.lastName.equals(rhs.lastName))))&&((this.education == rhs.education)||((this.education!= null)&&this.education.equals(rhs.education))))&&((this.gender == rhs.gender)||((this.gender!= null)&&this.gender.equals(rhs.gender))))&&((this.experienceInYears == rhs.experienceInYears)||((this.experienceInYears!= null)&&this.experienceInYears.equals(rhs.experienceInYears))))&&((this.location == rhs.location)||((this.location!= null)&&this.location.equals(rhs.location))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
