package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    //스프링 빈으로 설정되도록 코드 작성
    //두 리포지토리를 스프링 빈으로 설정한다.
    //그리고 스프링 빈에 등록된 멤버 리포지토리를 멤버 서비스에 넣어준다.
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    //구현체
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
