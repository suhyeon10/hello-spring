package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//컨트롤러라는 객체를 만들어서 컨테이너에 등록하도록 함(이를 스프링 빈이 관리된다고 함)
@Controller
public class MemberController {

    //스프링 컨테이너에 등록하여 1개만 생성하여 여러곳에서 돌려 쓰게 끔 함
    private final MemberService memberService;


    //의존관계 주입
    //컨트롤러와 서비스를 연결시켜줄때 사용
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping("/members/new")
    public String createForm(){
        //templates 밑으로 html을 찾음
        return "members/createMemberForm";
     }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberlist";
    }
}
