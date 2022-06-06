package romance_in_the_room.crowdfunding.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import romance_in_the_room.crowdfunding.domain.project.Project;
import romance_in_the_room.crowdfunding.service.ProjectService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/crowdfunding/project/post")
    public PostProjectResponse postNewProject(@RequestBody @Valid PostProjectRequest request) {
        Project project = Project.createProject(request.);
    }

    @Data
    @AllArgsConstructor
    static class PostProjectResponse {
    }

    @Data
    @AllArgsConstructor
    static class PostProjectRequest {
        private Long
    }
}
