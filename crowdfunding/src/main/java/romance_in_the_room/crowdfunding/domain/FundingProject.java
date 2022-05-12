package romance_in_the_room.crowdfunding.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class FundingProject {

    @Id @GeneratedValue
    private Long id;

    private Member member;


}
