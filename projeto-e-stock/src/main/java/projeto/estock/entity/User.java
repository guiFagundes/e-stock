package projeto.estock.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class User implements Bean {

	@Id
	@GeneratedValue
	private long id;

	@NotNull
	private String email;

	@NotNull
	private String name;

	public User() {
		super();
	}

	public User(long id) {
		this();
		this.id = id;
	}

	public User(String email, String name) {
		this();
		this.email = email;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
