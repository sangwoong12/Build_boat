package make.webpage.service;

import lombok.RequiredArgsConstructor;
import lombok.val;
import make.webpage.entity.Member;
import make.webpage.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor//final이 붙거나 @NotNull 이 붙은 필드의 생성자를 자동 생성해주는 롬복 어노테이션
public class MemberService {
    private final MemberRepository memberRepository;//final 안붙히면 왜 NUll포인트 오류가 나는건가.. 위의 이유로 나는거임

    @Transactional
    public Long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findNumbers = memberRepository.findByNumber(member.getNumber());
        if (!findNumbers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }

    @Transactional
    public void update(Long id, String name) {
        Member member = memberRepository.findOne(id);
        member.setName(name);//transcational로 인해 영속성관계이고 따로 persist하지 않아도 변경감지로 인해 바뀐다.
    }

}
