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

import javax.websocket.server.PathParam;
import java.util.List;

@Controller

public class StudentController {



@Autowired
 StudentService studentService;


@Autowired
private StudentRepository studentRepository;



  //  http://localhost:8080/students
@GetMapping("/student")
    public String ListStudent(Model model){
    model.addAttribute("student" ,studentService.getAllStudent());
    return "students";
}
    //  http://localhost:8080/new_student

@GetMapping("/new_student")
    public String createstudent(Model model){
    Student student=new Student();
    model.addAttribute("student",student);
    return "Success created";
}
    //  http://localhost:8080/savestudent

    @GetMapping("/savestudent")
    public String savestudent(@ModelAttribute("student") Student student){
studentService.savestudent(student);
return "saved";
}
    //  http://localhost:8080/editStudent

    @GetMapping("/editStudent")
    public  String editStudent(@RequestParam long id ,Model model ){
    model.addAttribute("student",studentService.getStudentById(id) );
return " success edit";
    }

    //get Student from database by id

//    http://localhost:8080/Update/{id}
    @GetMapping("/Update/{id}")
    public  String UpdateStudent( @RequestParam ("id") long id ,@RequestParam("name") String newname){
Student student= studentRepository.findById(id).get();
return  "success Update";
}

//handler method to handle delete student request

//    http://localhost:8080/delete student

@GetMapping("/delete student")
    public String deleteStudent(@RequestParam ("id") long id){
    studentRepository.deleteById(id);
    return "Success deleted";
}
 }



