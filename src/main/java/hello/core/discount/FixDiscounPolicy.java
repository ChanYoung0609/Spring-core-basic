package hello.core.discount;

public class FixDiscounPolicy implements DiscountPolicy {

    private int duscountFixAmount = 1000; // 1000원 할인

    @Override
    public int discount(hello.core.member.Member member, int price) {
        if(member.getGrade() == hello.core.member.Grade.VIP){
            return duscountFixAmount;
        }else{
            return 0;
        }
    }
}
