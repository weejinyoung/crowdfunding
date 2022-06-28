package romance_in_the_room.crowdfunding.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import romance_in_the_room.crowdfunding.controller.dto.PostProjectDto;
import romance_in_the_room.crowdfunding.domain.member.Member;
import romance_in_the_room.crowdfunding.domain.project.Project;
import romance_in_the_room.crowdfunding.domain.project.ProjectGoal;
import romance_in_the_room.crowdfunding.domain.project.ProjectStory;
import romance_in_the_room.crowdfunding.service.MemberService;
import romance_in_the_room.crowdfunding.service.ProjectService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;
    private final MemberService memberService;

    @PostMapping("/crowdfunding/project/post")
    public PostProjectResponse postNewProject(
            @PathVariable Long projectMakerId,
            @RequestBody @Valid PostProjectDto postProjectDto) {

        //ProjectGoal projectGoal = ProjectGoal.createProjectGoal(request.getProjectName());

        //임시조치
       // ProjectStory projectStory = new ProjectStory();

        //Project project = Project.createProject(request.getProjectName(), projectMaker, projectGoal, projectStory);
        Long projectId = projectService.postProject(projectMakerId, postProjectDto);
        return new PostProjectResponse(projectId);
    }

/*
    @GetMapping("/crowdfunding/project/find-by-maker")
*/


    @Data
    @AllArgsConstructor
    static class PostProjectResponse {
        private Long id;
    }

    @Data
    @AllArgsConstructor
    static class PostProjectRequest {
        private Long memberId;
        private String projectName;
    }
}
