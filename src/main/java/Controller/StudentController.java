package Controller;

import Services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
     private StudentService studentService;

    public StudentController(StudentService studentService) {
       super();
        this.studentService = studentService;
    }
@GetMapping("/studens")
    public String listStudent(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "students";

    }
}
