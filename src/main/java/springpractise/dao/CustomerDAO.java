package springpractise.dao;

import java.util.List;

import springpractise.entity.Customer;

public interface CustomerDAO extends BaseDAO{
	List<Customer> getAll();
	List<Customer> searchCustomer(Customer customer,int page);
	void insertCustomer (Customer customer);
	void updateCustomer (Customer customer);
	boolean deleteCustomer(Customer customer);
	Customer getCustomerById(Integer id);
	long totalCustomer(Customer customer);
}
