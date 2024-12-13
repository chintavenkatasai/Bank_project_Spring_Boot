package com.api.sai.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.sai.bank.model.Account;
import com.api.sai.bank.repository.Accountrepo;
@Service
public class AccountService {
@Autowired
  Accountrepo are;
	public String add(Account ac) {
	return "Account Added Succesfully.\n"+	are.save(ac);
	}
	public List<Account> getaccounts() {
		return are.findAll();
	}
	public String getAccountByAccountno(String accountno) {
		
		try
		{
			if(are.findByaccountno(accountno)!=null)
			{
				return ""+are.findByaccountno(accountno);
			}
			else
			{
				throw new Exception("Account Not found");
			}
			
		}
		catch(Exception e)
		{
			System.out.println("sai");
			
			return e.getMessage();
		}
		
	}
	public String deposit(String accountno, double amount) {
		
		try
		{
			if(are.findByaccountno(accountno)!=null)
			{
				Account ac=are.findByaccountno(accountno);
				double updated=ac.getBalance()+ amount;
                ac.setBalance(updated);
                System.out.println(updated);
                are.save(ac);
                return amount+" Credited to your Account "+accountno+"\nAvailable balance is :"+updated;
			}
			else
			{
				throw new Exception("Account Not found");
			}
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}
	public String withdrawal(String accountno, double amount) {

		try
		{
			if(are.findByaccountno(accountno)!=null)
			{
				
				Account ac=are.findByaccountno(accountno);
				if(ac.getBalance()>=amount)
				{
				double updated=ac.getBalance()-amount;
				ac.setBalance(updated);
				are.save(ac);
				return amount+" Withdrawal from your Account : "+accountno+"\nAvailable balance is :"+updated;
				}
				else 
				{
					throw new Exception("Insufficient funds");
				}
			}
			else
			{
				throw new Exception("Account Not Found");
			}
		}
		catch(Exception e)
		{
			
			return e.getMessage();
		}
	}
	

}
