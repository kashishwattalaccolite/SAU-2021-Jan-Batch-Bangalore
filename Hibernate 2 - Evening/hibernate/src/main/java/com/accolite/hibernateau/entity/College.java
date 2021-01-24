package com.accolite.hibernateau.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "college")
@Data
public class College {

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


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String city;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<Student> students;

}
