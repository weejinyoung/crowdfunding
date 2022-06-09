package romance_in_the_room.crowdfunding.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import romance_in_the_room.crowdfunding.domain.project.Project;
import romance_in_the_room.crowdfunding.domain.support.Support;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SupportRepository {

    private final EntityManager em;

    public Long save(Support support) {
        em.persist(support);
        return support.getId();
    }

    public Support findOne(Long id) {
        return em.find(Support.class, id);
    }

    public List<Support> findAll() {
        return em.createQuery("select s from Support s", Support.class)
                .getResultList();
    }

    public List<Support> findBySupporter(String name) {
        return em.createQuery("select s from Support s where s.supporter.name = :name", Support.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<Support> findByProject(String projectName) {
        return em.createQuery("select s from Support s where s.project.projectName = :projectName", Support.class)
                .setParameter("projectName", projectName)
                .getResultList();
    }

}
