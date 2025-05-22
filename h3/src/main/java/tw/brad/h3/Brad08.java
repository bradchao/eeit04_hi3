package tw.brad.h3;

import tw.brad.dao.MemberDao;
import tw.brad.model.Member;
import tw.brad.model.MemberInfo;

public class Brad08 {

	public static void main(String[] args) {
		MemberDao memberDao = new MemberDao();
		Member member = memberDao.getById(17);
		if (member != null) {
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
				MemberInfo info = member.getMemberInfo();
				System.out.println(info.getBirthday());
				info.setTel("0912-777777");
				memberDao.update(member);
			}
		}else {
			System.out.println("Member NOT FOUND");
		}
	}

}
