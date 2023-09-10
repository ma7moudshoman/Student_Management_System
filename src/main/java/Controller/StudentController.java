package Controller;

import Dao.Student;
import Repository.StudentRepository;
import Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller

public class StudentController {
@Autowired
 StudentService studentService;
@Autowired
    StudentRepository studentRepository;



  //  http://localhost:8080/students
@GetMapping("/student")
    public String ListStudent(Model model){
    model.addAttribute("student" ,studentService.getAllStudent());
    return "students";
}
@GetMapping("/new_student")
    public String createstudent(Model model){
    Student student=new Student();
    model.addAttribute("student",student);
    return "Success created";
}
@GetMapping("/savestudent")
    public String savestudent(@RequestParam("student") Student student){
studentService.savestudent(student);
return "saved";
}
 }



