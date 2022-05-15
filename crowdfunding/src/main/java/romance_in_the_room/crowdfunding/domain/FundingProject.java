package romance_in_the_room.crowdfunding.domain;

import lombok.Getter;
import romance_in_the_room.crowdfunding.domain.project.Project;

import javax.persistence.*;

@Entity
@Table(name = "funding_project")
@Getter
public class FundingProject {

    @Id @GeneratedValue
    @Column(name = "funding_project_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "funding_id")
    private Funding funding;
}
