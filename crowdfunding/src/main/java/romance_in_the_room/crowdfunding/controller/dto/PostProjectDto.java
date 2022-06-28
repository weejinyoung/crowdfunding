package romance_in_the_room.crowdfunding.controller.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import romance_in_the_room.crowdfunding.domain.member.Member;
import romance_in_the_room.crowdfunding.domain.project.Project;
import romance_in_the_room.crowdfunding.domain.project.ProjectGoal;
import romance_in_the_room.crowdfunding.domain.project.ProjectStory;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PostProjectDto {

    private String projectName;
    private ProjectGoal projectGoal;
    private ProjectStory projectStory;
    private LocalDateTime projectOpenDate;

    @Builder
    public PostProjectDto(String projectName, ProjectGoal projectGoal, ProjectStory projectStory) {
        this.projectName = projectName;
        this.projectGoal = projectGoal;
        this.projectStory = projectStory;
        this.projectOpenDate = LocalDateTime.now();
    }

    public Project toEntity(Member projectMaker) {
        return Project.builder()
                .projectName(projectName)
                .projectMaker(projectMaker)
                .projectGoal(projectGoal)
                .projectStory(projectStory)
                .build();
    }
}
