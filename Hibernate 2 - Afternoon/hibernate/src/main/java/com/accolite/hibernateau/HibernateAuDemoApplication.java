package com.accolite.hibernateau;

import com.accolite.hibernateau.entity.Student;

import com.accolite.hibernateau.entity.College;
import com.accolite.hibernateau.repository.CollegeJPARepository;
import com.accolite.hibernateau.repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@Transactional
public class HibernateAuDemoApplication implements CommandLineRunner {

    @Resource
    CollegeRepository collegeRepository;

    @Autowired
    CollegeJPARepository collegeJPARepository;

    public static void main(String[] args) {
        SpringApplication.run(HibernateAuDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Student student = new Student(); //create operation
        student.setAge(19);
        student.setName("Dhanush");

        Student student2 = new Student();
        student2.setAge(18);
        student2.setName("Vivek");
        
        Student student3 = new Student();
        student3.setAge(22);
        student3.setName("Kashish");
        
        Set<Student> studentSet2 = new HashSet<>();
        studentSet2.add(student3);
        
        Set<Student> studentSet = new HashSet<>();
        studentSet.add(student);
        studentSet.add(student2);

        College college = new College();
        college.setStudents(studentSet);
        college.setName("Degree College");
        college.setCity("Hamirpur");


        collegeRepository.addCollege(college); //add data (insert operation)
        
        College college2 = new College();
        college2.setStudents(studentSet2);
        college2.setName("NIT Hamirpur");
        college2.setCity("Hamirpur");

        
        collegeRepository.addCollege(college2);
        
        //Read operation 
        College fromDb2 = collegeJPARepository.findCollegeByName("Degree College");
        System.out.println("Name: " +fromDb2.getName());
        System.out.println("City: " +fromDb2.getCity());
        System.out.println("Students: " +fromDb2.getStudents());
        
        //update operation
        fromDb2.setName("Degree College Anu");
        collegeRepository.updateCollege(fromDb2);
        
        //delete operation
       // collegeRepository.deleteCollege(fromDb2);
         

    }
}
