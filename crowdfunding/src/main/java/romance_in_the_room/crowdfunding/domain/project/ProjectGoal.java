package romance_in_the_room.crowdfunding.domain.project;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
public class ProjectGoal {

    @Id
    @OneToOne(mappedBy = "projectGoal")
    private Project project;
}
