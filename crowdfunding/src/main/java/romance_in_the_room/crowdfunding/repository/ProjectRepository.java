package romance_in_the_room.crowdfunding.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import romance_in_the_room.crowdfunding.domain.member.Member;
import romance_in_the_room.crowdfunding.domain.project.Project;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProjectRepository {

    private final EntityManager em;

    public Long save(Project project) {
        em.persist(project);
        return project.getId();
    }

    public Project findOne(Long id) {
        return em.find(Project.class, id);
    }

    public List<Project> findAll() {
        return em.createQuery("select p from Project p", Project.class)
                .getResultList();
    }

    public List<Project> findByName(String projectName) {
        return em.createQuery("select p from Project p where p.projectName = :projectName", Project.class)
                .setParameter("projectName", projectName)
                .getResultList();
    }
}
