package tw.brad.h3;

import tw.brad.dao.MemberDao;
import tw.brad.model.Member;
import tw.brad.model.MemberInfo;

public class Brad08 {

	public static void main(String[] args) {
		MemberDao memberDao = new MemberDao();
		Member member = memberDao.getById(13);
		System.out.println(member.getAccount());
		System.out.println("----");
		if (member.getMemberInfo() == null) {
			System.out.println("no info");
			MemberInfo info = new MemberInfo();
			info.setBirthday("1999-02-03");
			info.setTel("456");
			info.setGender("male");	
			member.setMemberInfo(info);
			memberDao.update(member);
		}else {
			System.out.println(member.getMemberInfo().getBirthday());
		}
	}

}
