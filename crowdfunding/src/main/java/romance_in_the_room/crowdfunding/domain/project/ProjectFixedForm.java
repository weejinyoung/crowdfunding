package romance_in_the_room.crowdfunding.domain.project;

import lombok.Getter;

import javax.persistence.Embeddable;
import javax.persistence.Lob;
import java.util.Date;
import java.util.List;

@Embeddable
@Getter
public class ProjectFixedForm {

    private String category;
    private List<String> fundingWays;
    private Date deadLine;
    private List<String> fundingRewards;
    private String projectGoal;
    private String description;
}
