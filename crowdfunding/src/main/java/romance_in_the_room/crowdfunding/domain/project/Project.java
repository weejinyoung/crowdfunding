package romance_in_the_room.crowdfunding.domain.project;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Project {

    @Id @GeneratedValue
    @Column(name = "project_id")
    private Long id;

    private String projectName;

    @Embedded
    private ProjectFixedForm form;
}
