package com.cg.capstore.dao;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.capstore.bean.Admin;
import com.cg.capstore.bean.Customer;
import com.cg.capstore.bean.Merchant;


@Repository
@Transactional
public class UserDAO implements IUserDAO{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public String validateUser(String email,String password) {
		// TODO Auto-generated method stub
		
		Query query =entityManager.createQuery("select u from Merchant u where merchant_mobile_no=:mobile");
		query.setParameter("mobile", email);
		Merchant m=(Merchant) query.getSingleResult();
		if(m!=null && m.getPassword().equals(password))
		{
			return "merchantpage";
		}
			Query query2 =entityManager.createQuery("select u from Customer u where customer_mobile_no=:mobile");
			query.setParameter("mobile", email);
			Customer c=(Customer) query2.getSingleResult();
			if(c!=null && c.getPassword().equals(password))
			{
				return "customerpage";
			}
			
			Query query3 =entityManager.createQuery("select u from Admin u where mobile_no=:mobile");
			query.setParameter("mobile", email);
			Admin a=(Admin) query3.getSingleResult();
			if(a!=null && a.getPassword().equals(password))
			{
				return "adminpage";
			}
		return "login";	
	}
	
	

}
