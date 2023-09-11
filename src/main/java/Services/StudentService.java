package Services;

import Dao.Student;
import Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student>getAllStudent();

    Student savestudent (Student student);
    Student Updatestudent (Student student);
    Student getStudentById(long id);
    void deleteStudent (long id);



}
