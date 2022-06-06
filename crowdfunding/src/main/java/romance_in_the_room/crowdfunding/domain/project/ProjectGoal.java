package romance_in_the_room.crowdfunding.domain.project;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class ProjectGoal {

    @Id @GeneratedValue
    @Column(name = "projectGoal_id")
    private Long id;




}
