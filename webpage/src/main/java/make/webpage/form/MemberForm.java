package make.webpage.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberForm {

    @NotEmpty(message = "회원 이름은 필수입니다.")
    private String name;

    @NotEmpty(message = "전화번호는 필수입니다.")
    private String number;
}