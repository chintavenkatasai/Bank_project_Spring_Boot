package com.api.sai.bank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String accountno;
	String name;
	double balance;
	public Account(int id, String accountno, String name, double balance) {
		super();
		this.id = id;
		 this.accountno = accountno;
		this.name = name;
		this.balance = balance;
	}
	public Account() {
                       
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountno() {
		return accountno;
	}

	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account details:\nid=" + id + ",\nAccountno=" + accountno + ",\nname=" + name + ",\nbalance=" + balance + "";
	}
	
}
