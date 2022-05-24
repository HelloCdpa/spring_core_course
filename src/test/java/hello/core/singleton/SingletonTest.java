package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        //1. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        MemberService memberService2 = appConfig.memberService();

        //참조값이 다른 것을 확인
        //계속 객체가 생성되어서 올라감 -> 많은 고객 요청 처리 어려움
        System.out.println("memberService2 = " + memberService2);
        System.out.println("memberService1 = " + memberService1);

        // 같지 않아야 함
        // 요청을 할 때마다 객체가 계~속 생성됨 해결 방안 => 싱글톤 패턴(객체 1개 생성 후 공유하도록 생성)
        assertThat(memberService1).isNotSameAs(memberService2);

    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        // new 로 꺼내면 오류
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        // isSameAs == 인스턴스가 같은 지 비교 / isEqual equal
        assertThat(singletonService1).isSameAs(singletonService2);

    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
        //AppConfig appConfig = new AppConfig();
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        //1. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        System.out.println("memberService2 = " + memberService2);
        System.out.println("memberService1 = " + memberService1);

        assertThat(memberService1).isSameAs(memberService2);
    }
}
