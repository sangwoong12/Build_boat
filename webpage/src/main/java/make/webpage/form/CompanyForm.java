package make.webpage.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CompanyForm {


    @NotEmpty(message = "회사 이름은 필수입니다.")
    private String companyName;
    @NotNull(message = "사업자 번호는 필수입니다.")
    private Integer companyRegistrationNumber;
    @NotEmpty(message = "위치는 필수입니다.")
    private String companyLocation;
    @NotEmpty(message = "사이트는 필수입니다.")
    private String companySite;

}
