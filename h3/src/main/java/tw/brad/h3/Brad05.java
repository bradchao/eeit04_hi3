package tw.brad.h3;

import tw.brad.dao.MemberDao;
import tw.brad.model.Member;

public class Brad05 {
	public static void main(String[] args) {
		Member member = new Member();
		member.setAccount("mark");
		member.setPasswd("123456");
		member.setCname("Mark");
		
		MemberDao dao = new MemberDao();
		//dao.save(member);
		
		Member member2 = dao.getById(12);
		if (member2 != null) {
			System.out.println(member2.getAccount());
		}
		
		
	}
}
