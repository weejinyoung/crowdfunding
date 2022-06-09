package romance_in_the_room.crowdfunding.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import romance_in_the_room.crowdfunding.domain.project.Project;
import romance_in_the_room.crowdfunding.repository.ProjectRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public Long postProject(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> findProjects() {
        return projectRepository.findAll();
    }

    public List<Project> findProjectByName(String projectName) {
        return projectRepository.findByName(projectName);
    }
}
