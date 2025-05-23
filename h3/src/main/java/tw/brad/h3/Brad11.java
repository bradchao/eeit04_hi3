package tw.brad.h3;

import java.util.Date;

import tw.brad.dao.CustDao;
import tw.brad.model.Cust;
import tw.brad.model.Order;

public class Brad11 {

	public static void main(String[] args) {
		CustDao custDao = new CustDao();
		Cust cust = custDao.getById(9);
		if (cust != null) {
			System.out.println(cust.getOrders().size());
			
			Order order1 = new Order();
			order1.setOrderDate(new Date());
			
			Order order2 = new Order();
			order2.setOrderDate(new Date());
			
			cust.addOrder(order1);
			cust.addOrder(order2);
			
			custDao.update(cust);
		}else {
			System.out.println("NOT FOUND");
		}
	}

}
