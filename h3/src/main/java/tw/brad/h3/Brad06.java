package tw.brad.h3;

import java.util.List;

import tw.brad.dao.GiftDao;
import tw.brad.model.Gift;

public class Brad06 {

	public static void main(String[] args) {
		GiftDao dao = new GiftDao();
		List<Gift> gifts = dao.getAll();
		for (Gift gift: gifts) {
			System.out.printf("%d, %s : %s\n", 
				gift.getId(), gift.getName(), gift.getTel());
		}		
	}

}
