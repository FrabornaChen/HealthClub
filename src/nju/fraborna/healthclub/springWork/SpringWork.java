package nju.fraborna.healthclub.springWork;

import nju.fraborna.healthclub.factory.ServiceFactory;
import nju.fraborna.healthclub.service.MemberService;

public class SpringWork {
	MemberService memberService = (MemberService) ServiceFactory
			.getMemberServiceInstance();

	public void work() {
		String ids = memberService.getAllMemberIDs();
		String[] id = ids.split(",");

		for (String string : id) {
			double payment = memberService.getPaymentPerMonth(string);
			boolean flag = memberService.deleteICNum(string, payment);

			if (flag)
				memberService.addPayRecord(string, payment);
		}
	}
}
