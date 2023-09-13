package com.example.Student_Management_System.Controller;

import com.example.Student_Management_System.Dao.Student;
import com.example.Student_Management_System.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    // http://localhost:9090/students
@GetMapping("/students")
    public String Student(Model model){
        model.addAttribute("student" ,studentService.allStudent());
        return "Student";
    }


    //  http://localhost:9090/new_student

    @GetMapping("/new_student")
    public String createstudent(Model model){
        model.addAttribute("student", new Student());
        return "addedStudent";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.savestudent(student);
        return "redirect:/students";
    }

    //  http://localhost:8080/getStudent

    @GetMapping("/getStudent")
    public  String getStudent(@RequestParam("playerId") long id , Model model ){
        model.addAttribute("student",studentService.getStudent(id) );
        return "addedStudent";
    }

    //    http://localhost:8080/removeStudent
    @GetMapping("/removeStudent")
    public  String removeStudent( @RequestParam ("playerId") long id ){
        studentService.deleteStudent(id);
        return "redirect:/students";

    }
}
