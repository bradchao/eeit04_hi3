package tw.brad.h3;

import java.io.FileInputStream;

import tw.brad.apis.BCrypt;
import tw.brad.dao.MemberDao;
import tw.brad.model.Member;
import tw.brad.model.MemberInfo;

public class Brad07 {
	public static void main(String[] args) {

		MemberDao memberDao = new MemberDao();
		
		Member member = new Member();
		member.setAccount("newda");
		member.setPasswd(BCrypt.hashpw("123456", BCrypt.gensalt()));
		member.setCname("Newda");
		//---------
		try {
			FileInputStream fin = new FileInputStream("dir1/10.0.104.183.png");
			byte[] da = fin.readAllBytes();
			member.setMyicon(da);
		}catch(Exception e) {
			System.out.println(e);
		}
		//---------
		
		MemberInfo info = new MemberInfo();
		info.setBirthday("1999-02-03");
		info.setTel("456");
		info.setGender("male");
		
		member.setMemberInfo(info);
		
		memberDao.save(member);
		
		
		
	}
}
