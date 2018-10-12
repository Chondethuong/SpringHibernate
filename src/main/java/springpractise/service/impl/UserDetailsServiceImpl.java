package springpractise.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import springpractise.dao.AccountDAO;
import springpractise.entity.Account;

public class UserDetailsServiceImpl implements UserDetailsService{
	private AccountDAO accountDAO;
	
	@Required
	public void setAccountDAO(AccountDAO accountDAO){
		this.accountDAO = accountDAO;
	}
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountDAO.getAccountByUsername(username);
		List<GrantedAuthority> authorities = buildUserAuthority();
		User user = new User(account.getUsername(), account.getPassword().trim(), authorities);
		return user;
	}
	private List<GrantedAuthority> buildUserAuthority() {
		return new ArrayList<GrantedAuthority>();
	}
}
