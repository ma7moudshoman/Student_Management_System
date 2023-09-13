package com.example.Student_Management_System.Services;

import com.example.Student_Management_System.Dao.Student;
import com.example.Student_Management_System.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {

private StudentRepository studentRepository;
@ Autowired
    public StudentService(StudentRepository studentRepository){
        super();
this.studentRepository=studentRepository;
    }


    public List<Student> allStudent() {
        return studentRepository.findAll();
    }
    public  Student savestudent(Student student){
        return  studentRepository.save(student);
    }


    public  Student getStudent  (long id){
        return  studentRepository.findById(id).get();
    }
    /*
public  Student Updatestudent(long id) {
        return studentRepository.save(id);
}*/
    public  void deleteStudent(long id){
         studentRepository.deleteById(id);
}


}