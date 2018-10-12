package springpractise.service;

import springpractise.entity.Account;

public interface AccountService {
	Account getAccount(String username);
	boolean validateAccount(String username, String password);
}
