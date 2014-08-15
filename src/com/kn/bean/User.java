package com.kn.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "user")
@XmlRootElement(name = "user")
public class User {

	private String id;
	private String name;
	private String email;
	private String password;
	//private int age;
	private List<UZC> uzcs;

	public User() {
		super();
	}
	
	public User(String name) {
		super();
		this.name = name;
	}
	
	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	
	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	@Id
	@Column(name="userId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name="username")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="plainPassword")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "userId")
	public List<UZC> getUZC() {
		return uzcs;
	}

	public void setUZC(List<UZC> uzcs) {
		this.uzcs = uzcs;
	}

	/*public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}*/
	
}
