package hello.core.discount;

public interface DiscountPolicy {

    /**
     * @return  할인 정책
     * @param member
     * @param price
     * @return
     */

    int discount(hello.core.member.Member member,int price);
}
