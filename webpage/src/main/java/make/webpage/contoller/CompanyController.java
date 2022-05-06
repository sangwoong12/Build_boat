package make.webpage.contoller;

import lombok.RequiredArgsConstructor;
import make.webpage.entity.Company;
import make.webpage.entity.Member;
import make.webpage.form.CompanyForm;
import make.webpage.form.MemberForm;
import make.webpage.service.CompanyService;
import make.webpage.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping("/company/new")
    private String createForm(Model model){
        model.addAttribute("companyform", new CompanyForm());
        return "company/createCompanyForm";
    }
    @PostMapping("/company/new")
    public String create(@Valid CompanyForm form, BindingResult result) {//BindingResult 에러가 있어도 계속
        if (result.hasErrors()) {
            return "company/createCompanyForm";
        }

        Company company = new Company();
        company.setCompanyName(form.getCompanyName());
        company.setCompanyRegistrationNumber(company.getCompanyRegistrationNumber());
        company.setCompanySite(form.getCompanySite());
        company.setCompanyLocation(form.getCompanyLocation());

        companyService.join(company);
        return "redirect:/";
    }
    @GetMapping("/company")
    public String list(Model model){
        List<Company> company = companyService.findCompany();//간단해서 엔티티를 직접 참조하지만 별로 좋지않음 꼭 form을 따로 만들어서 하자
        model.addAttribute("company",company);
        return "company/companyList";
    }
}
