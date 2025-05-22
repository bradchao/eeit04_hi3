package tw.brad.h3;

import tw.brad.apis.BCrypt;
import tw.brad.dao.MemberDao;
import tw.brad.model.Member;
import tw.brad.model.MemberInfo;

public class Brad07 {
	public static void main(String[] args) {

		MemberDao memberDao = new MemberDao();
		
		Member member = new Member();
		member.setAccount("Nick");
		member.setPasswd(BCrypt.hashpw("123456", BCrypt.gensalt()));
		member.setCname("Nick");
		
		MemberInfo info = new MemberInfo();
		info.setBirthday("1999-02-03");
		info.setTel("456");
		info.setGender("male");
		
		member.setMemberInfo(info);
		
		memberDao.save(member);
		
		
		
	}
}
