package romance_in_the_room.crowdfunding.domain.project;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class ProjectGoal {

    @Id
    @OneToOne(mappedBy = "projectGoal")
    private Project project;
}
