package Services;

import Dao.Student;
import Dao.Student;
import Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class StudentServiceImpl implements  StudentService {
@Autowired
private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        super();
this.studentRepository=studentRepository;
    }


    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }
    @Override
    public  Student savestudent(Student student){
        return  studentRepository.save(student);
    }
}