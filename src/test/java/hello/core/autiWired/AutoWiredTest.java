package hello.core.autiWired;

import hello.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTestersAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutoWiredTest {

    @Test
    void AutoWireOption() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean{

        @Autowired(required = false)
        public void SetNoBean1(Member member){
            System.out.println("member = " + member);
        }

        @Autowired
        public void SetNoBean2(@Nullable Member member2){
            System.out.println("member2 = " + member2);
        }

        @Autowired
        public void SetNoBean2(Optional<Member> member3){
            System.out.println("member3 = " + member3);
        }
    }
}
