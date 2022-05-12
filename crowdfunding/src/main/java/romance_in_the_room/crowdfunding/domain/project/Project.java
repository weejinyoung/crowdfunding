package romance_in_the_room.crowdfunding.domain.project;

import lombok.Getter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Project {

    @Id @GeneratedValue
    private Long id;

    private String projectName;

    @Embedded
    private ProjectFixedForm form;
}
