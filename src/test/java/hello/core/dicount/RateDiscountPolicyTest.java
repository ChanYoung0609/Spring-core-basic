package hello.core.dicount;

import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class RateDiscountPolicyTest {
    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 10% 할인 적용" )
    void vip_o(){
        //given
        Member member = new Member(1L,  "memberVIP", hello.core.member.Grade.VIP);

        //when
        int discount = rateDiscountPolicy.discount(member, 10000);
        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }
    @Test
    @DisplayName("VIP 아니면 할인 적용X" )
    void vip_x(){

        //given
        Member member = new Member(2L,  "memberBASIc", Grade.BASIC);

        //when
        int discount = rateDiscountPolicy.discount(member, 10000);
        //then
        org.assertj.core.api.Assertions.assertThat(discount).isEqualTo(1000);
    }

}
