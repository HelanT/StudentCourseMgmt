package com.takeo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="STUDENT_DTLS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SNO")
	@JsonProperty("STUDENT_NO")
	private Integer sno;
	@Column(name="SNAME")
	@JsonProperty("SNAME")
	@Size( min = 2, message ="student name should have at least 2 characters")
	private String sname;
	@JsonProperty("SADD")
	@Column(name="SADD")
	private String sadd;
	@NotEmpty
	@Email
	@JsonProperty("EMAIL")
	@Column(name="EMAIL")
	private String email;
	@ManyToOne
	@JoinColumn(name="course_ID")
	private Course course;

}
