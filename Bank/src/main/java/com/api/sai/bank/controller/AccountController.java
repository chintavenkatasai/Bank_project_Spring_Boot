package com.api.sai.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.sai.bank.model.Account;
import com.api.sai.bank.service.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	
	AccountService as;
	@PostMapping("/addac")
	public String add(@RequestBody Account ac)
	{
		return as.add(ac);
	}
	@GetMapping("/getac")
	public List<Account> getaccounts()
	{
		return as.getaccounts();
	}
	@GetMapping("/{accountno}")
	public String getAccountByAccountno(@PathVariable String accountno)
	{
		return as.getAccountByAccountno(accountno);
		
	}
	@PutMapping("/{accountno}/addm")
	public String deposit(@PathVariable String accountno,@RequestParam double amount)
	{
		return as.deposit(accountno,amount);
	}
	@PutMapping("/withdrawal/{accountno}")
	public String withdrawal(@PathVariable String accountno,@RequestParam double amount)
	{
		return as.withdrawal(accountno,amount);
	}

}
