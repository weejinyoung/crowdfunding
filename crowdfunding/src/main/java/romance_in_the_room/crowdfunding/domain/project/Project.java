package romance_in_the_room.crowdfunding.domain.project;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import romance_in_the_room.crowdfunding.domain.support.Support;
import romance_in_the_room.crowdfunding.domain.member.Member;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue
    @Column(name = "project_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    private Member projectMaker;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Support> supports = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "projectGoal_id")
    private ProjectGoal projectGoal;

    @Embedded
    private ProjectStory projectStory;

    private String projectName;

    private LocalDateTime projectOpenDate;

    @Builder
    public Project(String projectName, Member projectMaker, ProjectGoal projectGoal, ProjectStory projectStory) {
        this.projectName = projectName;
        this.projectMaker = projectMaker;
        this.projectGoal = projectGoal;
        this.projectStory = projectStory;
        this.projectOpenDate = LocalDateTime.now();
    }

//    public static Project createProject(String projectName, Member member, ProjectGoal projectGoal, ProjectStory projectStory) {
//        return new Project(projectName, member, projectGoal, projectStory);
//    }
}
