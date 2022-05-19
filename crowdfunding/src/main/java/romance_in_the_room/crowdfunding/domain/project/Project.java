package romance_in_the_room.crowdfunding.domain.project;

import lombok.Getter;
import romance_in_the_room.crowdfunding.domain.funding.Funding;
import romance_in_the_room.crowdfunding.domain.member.Member;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Project {

    @Id @GeneratedValue
    @Column(name = "project_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "project")
    private List<Funding> fundings = new ArrayList<>();

    private String projectName;

    @Embedded
    private ProjectFundingInfo fundingInfo;

    @Embedded
    private ProjectDateInfo dateInfo;
}
