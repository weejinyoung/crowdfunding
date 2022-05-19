package romance_in_the_room.crowdfunding.domain.project;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter @Setter
public class ProjectFundingInfo {

    private int targetAmount;
    private int currentAmount;
}
