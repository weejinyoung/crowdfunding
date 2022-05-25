package romance_in_the_room.crowdfunding.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import romance_in_the_room.crowdfunding.domain.funding.Funding;
import romance_in_the_room.crowdfunding.domain.member.Member;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;

@Repository
@RequiredArgsConstructor
public class FundingRepository {

    private final EntityManager em;

    public Long save(Funding funding) {
        em.persist(funding);
        return funding.getId();
    }

    public Funding findOne(Long id) {
        return em.find(Funding.class, id);
    }
}
