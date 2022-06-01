package romance_in_the_room.crowdfunding.domain.project;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
public class ProjectStory {

    @Id
    @OneToOne(mappedBy = "projectStory")
    private Project project;
}
