package make.webpage.contoller;

import lombok.RequiredArgsConstructor;
import make.webpage.entity.Member;
import make.webpage.form.MemberForm;
import make.webpage.service.MemberService;
import org.apache.tomcat.jni.Address;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/members/new")
    private String createForm(Model model){
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMemberForm";
    }
    @PostMapping("/members/new")
    public String create(@Valid MemberForm form, BindingResult result) {//BindingResult 에러가 있어도 계속
        if (result.hasErrors()) {
            return "members/createMemberForm";
        }

        Member member = new Member();
        member.setName(form.getName());
        member.setNumber(form.getNumber());

        memberService.join(member);
        return "redirect:/";
    }
    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();//간단해서 엔티티를 직접 참조하지만 별로 좋지않음 꼭 form을 따로 만들어서 하자
        model.addAttribute("members",members);
        return "members/memberList";
    }
}
