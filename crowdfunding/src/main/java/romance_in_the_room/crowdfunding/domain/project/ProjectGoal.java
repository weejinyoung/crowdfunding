package romance_in_the_room.crowdfunding.domain.project;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class ProjectGoal {

    @Id
    @GeneratedValue
    @Column(name = "projectGoal_id")
    private Long id;

    private String goalTitle;

    protected ProjectGoal(String goalTitle) {
        this.goalTitle = goalTitle;
    }

    public static ProjectGoal createProjectGoal(String goalTitle) {
        return new ProjectGoal(goalTitle);
    }
}
