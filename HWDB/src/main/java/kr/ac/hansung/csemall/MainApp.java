package kr.ac.hansung.csemall;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String args[]) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("kr/ac/hansung/conf/beans.xml");
		OfferDAO offerDAO = (OfferDAO) context.getBean("offerDAO");
		
		System.out.println("The record count is " + offerDAO.getRowCount());
		
		List<Offer> offerList = offerDAO.getOffers();
		
		for(Offer offer: offerList)
			System.out.println(offer);
		
		
		context.close();
	}
}