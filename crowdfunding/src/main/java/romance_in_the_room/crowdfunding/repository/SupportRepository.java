package romance_in_the_room.crowdfunding.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import romance_in_the_room.crowdfunding.domain.support.Support;

import javax.persistence.EntityManager;

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
}
