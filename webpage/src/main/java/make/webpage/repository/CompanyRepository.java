package make.webpage.repository;

import lombok.RequiredArgsConstructor;
import make.webpage.entity.Company;
import make.webpage.entity.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CompanyRepository {
    private final EntityManager em;

    public Long save(Company company){
        em.persist(company);
        return company.getId();
    }

    public Company findOne(Long id){
        return em.find(Company.class, id);
    }
    public List<Company> findAll() {
        return em.createQuery("select c from Company c", Company.class)
                .getResultList();//ctrl alt n

    }
    public List<Company> findByName(String name){
        return em.createQuery("select c from Company c where c.companyName = :companyName",Company.class)
                .setParameter("companyName",name)
                .getResultList();
    }
}
