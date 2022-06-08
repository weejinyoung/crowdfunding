package romance_in_the_room.crowdfunding.domain.project;

import lombok.Getter;

import javax.persistence.*;

@Embeddable
public class ProjectStory {

    private String title;
    private String target;

}
