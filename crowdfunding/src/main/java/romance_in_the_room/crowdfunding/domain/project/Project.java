package romance_in_the_room.crowdfunding.domain.project;

import lombok.Getter;
import romance_in_the_room.crowdfunding.domain.funding.Support;
import romance_in_the_room.crowdfunding.domain.member.Member;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private Member projectMaker;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Support> supports = new ArrayList<>();

    private String projectName;

    private LocalDateTime projectPostDate;
}
