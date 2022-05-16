package romance_in_the_room.crowdfunding.domain.project;

import lombok.Getter;
import romance_in_the_room.crowdfunding.domain.Member;

import javax.persistence.*;

@Entity
@Getter
public class Project {

    @Id @GeneratedValue
    @Column(name = "project_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String projectName;

    @Embedded
    private ProjectFixedForm form;
}
