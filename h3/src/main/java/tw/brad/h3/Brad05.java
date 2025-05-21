package tw.brad.h3;

import java.util.List;

import tw.brad.apis.BCrypt;
import tw.brad.dao.MemberDao;
import tw.brad.model.Member;

public class Brad05 {
	public static void main(String[] args) {
		Member member = new Member();
		member.setAccount("mark");
		member.setPasswd(
				BCrypt.hashpw("123456", BCrypt.gensalt()));
		member.setCname("Mark");
		
		MemberDao dao = new MemberDao();
		//dao.save(member);
		//dao.update(member);
		
		Member member2 = dao.getById(12);
		if (member2 != null) {
			System.out.println(member2.getAccount()+":"+member2.getCname());
			dao.delete(member2);
		}

		Member member3 = dao.getById(5);
		if (member3 != null) {
			member3.setCname("湯尼");
			dao.update(member3);
		}		
		System.out.println("---");
		
		List<Member> members = dao.getAll();
		for (Member member4: members) {
			System.out.printf("%d, %s : %s\n", 
				member4.getId(), member4.getAccount(), member4.getCname());
		}
		

		
	}
}
