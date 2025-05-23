package tw.brad.h3;

import java.util.Date;

import tw.brad.dao.CustDao;
import tw.brad.model.Cust;
import tw.brad.model.Order;

public class Brad12 {

	public static void main(String[] args) {
		CustDao custDao = new CustDao();
		custDao.removeOrderFromCust(9, 7);
	}

}
