package tw.brad.h3;

import java.util.List;

import tw.brad.dao.MemberDao;
import tw.brad.model.Member;

public class Brad09 {

	public static void main(String[] args) {
		MemberDao memberDao = new MemberDao();
		List<Member> members = memberDao.findByTel("0912");
		if (members != null) {
			for (Member member: members) {
				System.out.println(
						member.getId() + " : " + 
						member.getAccount() + " : " +
						member.getMemberInfo().getTel());
			}
		}else {
			System.out.println("NOT FOUND");
		}
	}

}
