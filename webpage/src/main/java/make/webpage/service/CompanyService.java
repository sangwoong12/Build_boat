package make.webpage.service;

import lombok.RequiredArgsConstructor;
import make.webpage.entity.Company;
import make.webpage.entity.Member;
import make.webpage.repository.CompanyRepository;
import make.webpage.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor//final이 붙거나 @NotNull 이 붙은 필드의 생성자를 자동 생성해주는 롬복 어노테이션
public class CompanyService {
    private final CompanyRepository companyRepository;//final 안붙히면 왜 NUll포인트 오류가 나는건가.. 위의 이유로 나는거임

    @Transactional
    public Long join(Company company){
        validateDuplicateMember(company);
        companyRepository.save(company);
        return company.getId();
    }

    private void validateDuplicateMember(Company company) {
        List<Company> findNumbers = companyRepository.findByName(company.getCompanyName());
        if (!findNumbers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회사입니다.");
        }
    }

    public List<Company> findCompany(){
        return companyRepository.findAll();
    }

    public Company findOne(Long companyId){
        return companyRepository.findOne(companyId);
    }

    @Transactional
    public void update(Long id, String companyname) {
        Company company = companyRepository.findOne(id);
        company.setCompanyName(companyname);//transcational로 인해 영속성관계이고 따로 persist하지 않아도 변경감지로 인해 바뀐다.
    }
}
