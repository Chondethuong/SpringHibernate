package springpractise.service.impl;

import org.springframework.beans.factory.annotation.Required;

import springpractise.dao.AccountDAO;
import springpractise.entity.Account;
import springpractise.service.AccountService;

public class AccountServiceImpl implements AccountService{
	private AccountDAO accountDAO;
	
	@Required
	public void setAccountDAO(AccountDAO accountDAO){
		this.accountDAO = accountDAO;
	}
		
	public Account getAccount(String username) {
		return accountDAO.getAccountByUsername(username);
	}

	public boolean validateAccount(String username, String password) {
		return accountDAO.validateAccount(username, password);
	}

}
