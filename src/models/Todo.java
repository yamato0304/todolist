package models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import controllers.Type;

@Entity
@NamedQueries({ @NamedQuery(name = "getAlltodos", query = "SELECT m FROM Todo AS m ORDER BY m.deadline ASC "),
		@NamedQuery(name = "getjobtodos", query = "SELECT m FROM Todo AS m WHERE m.type=1 ORDER BY m.deadline ASC "),
		@NamedQuery(name = "getprivatetodos", query = "SELECT m FROM Todo AS m WHERE m.type=2 ORDER BY m.deadline ASC "),

        @NamedQuery(name = "getMyAlltodos", query = "SELECT m FROM Todo AS m WHERE m.user_id = :user_id ORDER BY m.deadline ASC "),
        @NamedQuery(name = "getMyjobtodos", query = "SELECT m FROM Todo AS m WHERE m.user_id = :user_id AND m.type=1 ORDER BY m.deadline ASC "),
        @NamedQuery(name = "getMyprivatetodos", query = "SELECT m FROM Todo AS m WHERE m.user_id = :user_id AND m.type=2 ORDER BY m.deadline ASC "),
})

@Table(name = "todos")
public class Todo {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "user_id", length = 255, nullable = false)
	private Integer user_id;

	@Column(name = "content", length = 255, nullable = false)
	private String content;

	@Column(name = "deadline", nullable = false)
	private Date deadline;

	@Column(name = "type", nullable = false)
	private Integer type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getcontent() {
		return content;
	}

	public void setcontent(String content) {
		this.content = content;
	}

	public Integer getUserid() {
		return user_id;
	}

	public void setUserid(Integer user_id) {
		this.user_id = user_id;
	}

	public Date getdeadline() {
		return deadline;
	}

	public void setdeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Integer gettype() {
		return type;
	}

	public void settype(Integer type) {
		this.type = type;
	}

	public String gettypename() {
		return Type.gettype(this.type);

	}

}