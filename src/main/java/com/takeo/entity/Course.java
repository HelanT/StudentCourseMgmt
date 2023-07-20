package com.takeo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="COURSE_DTLS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COURSE_ID")
	@JsonProperty("ID")
	private Integer cid;
	@NotEmpty
	@JsonProperty("CNAME")
	@Size(min = 2,message="course name should have at least 2 charcters")
	@Column(name="CNAME")
	private String cname;
	@NotEmpty
	@Size(min = 2,message = "Course duration should have  at least 2 Characters")
	@JsonProperty("CDURATION")
	@Column(name="CDURATION")
	private String cduration;
    @NotEmpty
    @Size(min = 2,message = "course fee should have  at least 2 number")
	@JsonProperty("CFEE")
	@Column(name="CFEE")
    private Double cfee;
    @JsonIgnore
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<Student> student;
    

}
