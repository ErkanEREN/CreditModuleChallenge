package dev.erkaneren.CreditModuleChallenge.persistance.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID, generator = "customer_generator")
	private long id;

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_squencer")
	@Column(name = "squence")
	private long _index;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "creditLimit")
	private long creditLimit;

	@Column(name = "usedCreditLimit")
	private long usedCreditLimit;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public long getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(long creditLimit) {
		this.creditLimit = creditLimit;
	}

	public long getUsedCreditLimit() {
		return usedCreditLimit;
	}

	public void setUsedCreditLimit(long usedCreditLimit) {
		this.usedCreditLimit = usedCreditLimit;
	}

	public Customer() {
	}

	public Customer(long id, String name, String surname, long creditLimit, long usedCreditLimit) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.creditLimit = creditLimit;
		this.usedCreditLimit = usedCreditLimit;
	}

	@Override
	public String toString() {
		return "Tutorial" +
			"[ id=" + getId() +
			", name=" + getName() +
			", surname=" + getSurname() +
			", creditLimit=" + getCreditLimit() +
			", usedCreditLimit=" + getUsedCreditLimit() + "]";
	}
}
