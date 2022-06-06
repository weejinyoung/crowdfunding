package romance_in_the_room.crowdfunding.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import romance_in_the_room.crowdfunding.domain.member.Member;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public Long saveMember(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

    public Member findByMyId(String myId) {
        return em.createQuery("select m from Member m where m.myId = :myId", Member.class)
                .setParameter("myId", myId)
                .getSingleResult();
    }

    public Member findByPassword(String password) {
        return em.createQuery("select m from Member m where m.password = :password", Member.class)
                .setParameter("password", password)
                .getSingleResult();
    }

}
