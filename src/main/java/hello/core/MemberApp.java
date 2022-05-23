package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    // psvm
    public static void main(String[] args) {
       // AppConfig appConfig = new AppConfig();
       // MemberService memberService = appConfig.memberService();
        //app config 에서 모든 것을 결정하게 함
       // MemberServiceImpl memberService = new MemberServiceImpl();

        //AppConfig 에 있는 설정을 스프링빈에 다 넣어서 관리해줌
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //이름, 타입
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
