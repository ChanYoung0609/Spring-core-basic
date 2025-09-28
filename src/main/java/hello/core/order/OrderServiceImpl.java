package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscounPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository ;//= new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy;

    // DIP 위반(의존관계 구체에 의존 x 추상에 의존해야함) 현재 둘다 의존 하는중
    //private final DiscountPolicy discountPolicy =new FixDiscounPolicy();

    // OCP 위반 (할인 정책을 변경하려면 클라이언트 코드를 변경해야함)
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();


    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
