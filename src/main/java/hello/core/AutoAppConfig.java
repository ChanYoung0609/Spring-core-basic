package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core", //탐색할 패키지 지정
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes =  Configuration.class)
)//필터등록 -> AppConfig는 컴포넌트 스캔 대상에서 제외
public class AutoAppConfig {
    //디폴트는 @ComponentScan 이고 basePackages 는 지정하지 않으면 설정 정보 클래스의 패키지가 시작위치가 됨

    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
