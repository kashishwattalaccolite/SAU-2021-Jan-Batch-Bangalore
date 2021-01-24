package com.accolite.hibernateau.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Student {

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}



	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name  = "age")
    private Integer age;
    
    @ManyToOne()
    College college;


}
