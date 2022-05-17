package romance_in_the_room.crowdfunding.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Funding {

    @Id
    @GeneratedValue
    @Column(name = "funding_id")
    public Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    public Member member;

    @OneToMany(mappedBy = "funding", cascade = CascadeType.ALL)
    private List<FundingProject> fundingProjects = new ArrayList<>();

}
