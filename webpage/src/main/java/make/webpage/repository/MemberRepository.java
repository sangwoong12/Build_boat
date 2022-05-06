package make.webpage.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import make.webpage.entity.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public Long save(Member member){
        em.persist(member);
        return member.getId();
    }

    public Member findOne(Long id){
        return em.find(Member.class, id);
    }
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();//ctrl alt n

    }
    public List<Member> findByNumber(String number){
        return em.createQuery("select m from Member m where m.number = :number",Member.class)
                .setParameter("number",number)
                .getResultList();
    }

}
