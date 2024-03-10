
package sqlToPojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "CANDIDATE_DETAILS")
@Table
@Data
@NoArgsConstructor
public class CandidateEntity {

    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "PROFESSION")
    private String profession;
    @Column(name = "EXPERIENCE")
    private Integer experience;
    @Column(name = "CURRENT_LOCATION")
    private String currentLocation;
    @Column(name = "HOME_TOWN")
    private String homeTown;
    @Column(name = "HIGHEST_EDUCATION")
    private String highestEducation;
    @Column(name = "SPECIALIZATION_IN")
    private String specializationIn;

}
