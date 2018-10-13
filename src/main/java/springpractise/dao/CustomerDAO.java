package springpractise.dao;

import java.util.List;

import springpractise.entity.CustomerFormData;
import springpractise.entity.Customer;

public interface CustomerDAO extends BaseDAO{
	List<Customer> getAll();
	List<Customer> searchCustomer(CustomerFormData customer);
	void insertCustomer (Customer customer);
	void updateCustomer (Customer customer);
	boolean deleteCustomer(Customer customer);
	Customer getCustomerById(Integer id);
	long totalCustomer(CustomerFormData customer);
}
