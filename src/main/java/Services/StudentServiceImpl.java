package Services;

import Entity.Student;
import Repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService{
    private StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
      super();
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }
}
