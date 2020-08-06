package springmvchb.practice.daoImp;


import springmvchb.practice.dao.CustomerDao;
import springmvchb.practice.entity.Customer;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CustomerDaoImp implements CustomerDao {
	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Customer> theQuery=currentSession.createQuery("from Customer",Customer.class);
		List<Customer> customers=theQuery.getResultList();
		System.out.println("Result: "+customers.toString());
		return customers;
	}

}


