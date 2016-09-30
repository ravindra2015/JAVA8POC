package org.springframework.samples.mvc.javapoc.broker;


import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

public class BrokerBean {
	
	@NotEmpty
	private String name;
	
	@Min(21)
	private int age;
	@NotEmpty
	private String accountNo;
	
	private String brokers;
	

	public String getBrokers() {
		return brokers;
	}

	public void setBrokers(String brokers) {
		this.brokers = brokers;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "BrokerBean [name=" + name + ", age=" + age + ", accountNo=" + accountNo + "]";
	}

	
	

	
}
