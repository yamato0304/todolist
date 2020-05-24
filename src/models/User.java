package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "users")
@NamedQueries({ @NamedQuery(name = "getAllUsers", query = "SELECT e FROM User AS e ORDER BY e.id DESC"),

		@NamedQuery(name = "getUsersCount", query = "SELECT COUNT(e) FROM User AS e"),

		@NamedQuery(name = "checkLoginCodeAndPassword", query = "SELECT e FROM User AS e WHERE e.delete_flag = 0 AND e.name = :name AND e.password = :pass") })
@Entity

public class User {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@Column(name = "password", length = 64, nullable = false)
	private String password;

	@Column(name = "admin_flag", nullable = false)
	private Integer admin_flag;

	@Column(name = "delete_flag", nullable = false)
	private Integer delete_flag;



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAdmin_flag() {
		return admin_flag;
	}

	public void setAdmin_flag(Integer admin_flag) {
		this.admin_flag = admin_flag;
	}

	public Integer getDelete_flag() {
		return delete_flag;
	}

	public void setDelete_flag(Integer delete_flag) {
		this.delete_flag = delete_flag;
	}

}
