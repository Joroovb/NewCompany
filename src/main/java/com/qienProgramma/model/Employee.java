package com.qienProgramma.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private double salary;

	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "phone_id", referencedColumnName = "id")
	private Phone phone;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="the_messages",
			joinColumns = @JoinColumn(name = "id"),
			inverseJoinColumns = @JoinColumn(name = "messages_id"))
	private List<Messages> messages = new ArrayList<>();

	
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	public List<Messages> getMessages() {
		return messages;
	}

	public void addMessage(Messages message) {
		this.messages.add(message);
		System.out.println("New Message");
	}

	public void addPhone(Phone phone) {
		this.phone = phone;
	}

	public Phone getPhone() {
		return phone;
	}
}
