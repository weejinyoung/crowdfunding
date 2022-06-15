package romance_in_the_room.crowdfunding.domain.support;

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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    public Member supporter;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    private LocalDateTime supportDate;

    //멤버 연관관계 메서드//
    private void setSupporter(Member member) {
        this.supporter = member;
        supporter.getSupports().add(this);
    }

    //프로젝트 연관관계 메서드//
    private void setProject(Project project) {
        this.project = project;
        project.getSupports().add(this);
    }

    private void setSupportDate() {
        this.supportDate = LocalDateTime.now();
    }

    public static Support createSupport(Member member, Project project) {
        Support support = new Support();
        support.setSupporter(member);
        support.setProject(project);
        support.setSupportDate();
        return support;
    }
}
