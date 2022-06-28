package romance_in_the_room.crowdfunding.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import romance_in_the_room.crowdfunding.controller.dto.PostProjectDto;
import romance_in_the_room.crowdfunding.domain.member.Member;
import romance_in_the_room.crowdfunding.domain.project.Project;
import romance_in_the_room.crowdfunding.repository.MemberRepository;
import romance_in_the_room.crowdfunding.repository.ProjectRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final MemberRepository memberRepository;

    public Long postProject(Long projectMakerId, PostProjectDto postProjectDto) {
        Member projectMaker = memberRepository.findOne(projectMakerId);
        Project postProject = postProjectDto.toEntity(projectMaker);
        return projectRepository.save(postProject);
    }

    public List<Project> findProjects() {
        return projectRepository.findAll();
    }

    public List<Project> findProjectByName(String projectName) {
        return projectRepository.findByName(projectName);
    }

    public List<Project> findProjectByProjectMaker(String projectMaker) {
        return projectRepository.findByProjectMaker(projectMaker);
    }
}
