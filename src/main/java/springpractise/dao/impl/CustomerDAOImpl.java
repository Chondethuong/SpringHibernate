package springpractise.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import springpractise.dao.CustomerDAO;
import springpractise.entity.Customer;

@Transactional
public class CustomerDAOImpl extends BaseDAOImpl implements CustomerDAO{
	
	@SuppressWarnings("unchecked")
	public List<Customer> getAll() {
		Criteria cr = getSession().createCriteria(Customer.class);
		return cr.list();
	}
	@SuppressWarnings("unchecked")
	public List<Customer> searchCustomer(Customer customer, int page) {
		Criteria cr = getSession().createCriteria(Customer.class);
		if (null != customer.getName() && !customer.getName().trim().equals("")){
			cr.add(Restrictions.like("name", "%"+customer.getName().trim()+"%"));
		}
		if (null != customer.getPhone() && !customer.getPhone().trim().equals("")){
			cr.add(Restrictions.like("phone", "%"+customer.getPhone().trim()+"%"));
		}
		if (null != customer.getDob()){
			cr.add(Restrictions.eq("dob", customer.getDob()));
		}
		if (null != customer.getEmail() && !customer.getEmail().trim().equals("")){
			cr.add(Restrictions.like("email", "%"+customer.getEmail().trim()+"%"));
		}
		if (null != customer.getGender()){
			cr.add(Restrictions.eq("gender", customer.getGender()));
		}
		cr.setFirstResult(page == 1 ? 1 :(page-1)*5);
		cr.setMaxResults(5);
		return cr.list();
	}
	public void insertCustomer(Customer customer) {
		Session session = getSession();
		if (null != customer){
			session.persist(customer);
			session.evict(customer);
		}
	}
	public boolean deleteCustomer(Customer customer) {
		if(null != customer){
			Session session = getSession();
			Object persistentInstance = session.load(Customer.class, customer.getId());
			if (null != persistentInstance){
				session.delete(persistentInstance);
			}
		}
		return false;
	}
	public Customer getCustomerById(Integer id) {
		if (null != id){
			Criteria cri = getSession().createCriteria(Customer.class);
			cri.add(Restrictions.eq("id", id));
			return (Customer) cri.list().get(0);
		}
		return null;
	}
	public void updateCustomer(Customer customer) {
		Session session = getSession();
		if (null != customer){
			session.saveOrUpdate(customer);
		}
	}
	public long totalCustomer(Customer customer) {

		Criteria cr = getSession().createCriteria(Customer.class);
		if (null != customer.getName() && !customer.getName().trim().equals("")){
			cr.add(Restrictions.like("name", "%"+customer.getName().trim()+"%"));
		}
		if (null != customer.getPhone() && !customer.getPhone().trim().equals("")){
			cr.add(Restrictions.like("phone", "%"+customer.getPhone().trim()+"%"));
		}
		if (null != customer.getDob()){
			cr.add(Restrictions.eq("dob", customer.getDob()));
		}
		if (null != customer.getEmail() && !customer.getEmail().trim().equals("")){
			cr.add(Restrictions.like("email", "%"+customer.getEmail().trim()+"%"));
		}
		if (null != customer.getGender()){
			cr.add(Restrictions.eq("gender", customer.getGender()));
		}
		return (Long) cr.setProjection(Projections.rowCount()).uniqueResult();
	}
}
