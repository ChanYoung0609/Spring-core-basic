package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = context.getBean("memberService",MemberServiceImpl.class);
        OrderServiceImpl orderService = context.getBean("orderService",OrderServiceImpl.class);

        MemberRepository memberRepository = context.getBean("memberRepository",MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberService -> memberRepository = " + memberRepository1);
        System.out.println("orderService -> memberRepository = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);

        assertThat(memberRepository1).isSameAs(memberRepository2);
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }

    @Test
    void configurationDeep() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = context.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());
        //bean = class hello.core.AppConfig$$EnhancerBySpringCGLIB$$7f4d5c1f
        //AppConfig도 스프링이 CGLIB라는 바이트코드 조작 라이브러리를 사용해서
        //AppConfig를 상속받은 임의의 다른 클래스를 만들고, 그 다른 클래스를 스프링 빈으로 등록한다.
        //따라서, 싱글톤이 깨지는 것이 아니라, 싱글톤이 유지되도록 해주는 장치가 동작하는 것이다.
    }

}
