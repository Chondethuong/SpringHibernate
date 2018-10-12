package springpractise.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import springpractise.dao.CustomerDAO;
import springpractise.entity.CustomeFormData;
import springpractise.entity.Customer;
import springpractise.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{
	private CustomerDAO customerDAO;

	@Required
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	public List<Customer> getAll() {
		return customerDAO.getAll();
	}

	public List<Customer> searchCustomer(CustomeFormData customer) {
		return customerDAO.searchCustomer(customer);
	}

	public void insertCustomer(Customer customer) {
		customerDAO.insertCustomer(customer);
	}

	public boolean deleteCustomer(Customer customer) {
		return customerDAO.deleteCustomer(customer);
	}

	public Customer getCustomerById(Integer id) {
		return customerDAO.getCustomerById(id);
	}

	public void updateCustomer(Customer customer) {
		customerDAO.updateCustomer(customer);
	}

	public long totalCustomer(CustomeFormData customer) {
		return customerDAO.totalCustomer(customer);
	}
}
