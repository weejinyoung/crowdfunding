package romance_in_the_room.crowdfunding.domain.funding;

import lombok.Getter;
import romance_in_the_room.crowdfunding.domain.member.Member;
import romance_in_the_room.crowdfunding.domain.project.Project;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Support {

    @Id
    @GeneratedValue
    @Column(name = "support_id")
    public Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    public Member supporter;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    private LocalDateTime supportDate;

    //멤버 연관관계 메서드//
    public void setSupporter(Member supporter) {
        this.supporter = supporter;
        supporter.getSupports().add(this);
    }

    //프로젝트 연관관계 메서드//
    public void setProject(Project project) {
        this.project = project;
        project.getSupports().add(this);
    }

    public static Support supportProject (Member member, Project project) {
        Support support = new Support();
        support.setSupporter(member);
        support.setProject(project);
        return support;
    }
}
