package com.springBootLearning.spring_boot_0_1.collegeManagement;



import com.springBootLearning.spring_boot_0_1.collegeManagement.Repository.ProfessorRepository;
import com.springBootLearning.spring_boot_0_1.collegeManagement.Repository.StudentRepository;
import com.springBootLearning.spring_boot_0_1.collegeManagement.Repository.SubjectRepository;
import com.springBootLearning.spring_boot_0_1.collegeManagement.Model.Professor;
import com.springBootLearning.spring_boot_0_1.collegeManagement.Model.Student;
import com.springBootLearning.spring_boot_0_1.collegeManagement.Model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/collegeManagement")
public class CollegeManagementController {


   @Autowired
   private CollegeManagementService collegeManagementService;

   @Autowired
    private ProfessorRepository professorRepository;

   @Autowired
   private StudentRepository studentRepository;

   @Autowired
   private SubjectRepository subjectRepository;



        @PostMapping("/createStudent")
        public ResponseEntity<Student> createStudent(@RequestBody Student student){
            return new ResponseEntity<>(collegeManagementService.createStudent(student),HttpStatus.CREATED);
        }

        @PostMapping("/createSubject")
        public ResponseEntity<Subject> createSubject(@RequestBody Subject subject){
            return new ResponseEntity<>(collegeManagementService.createSubject(subject),HttpStatus.CREATED);
        }

        @PostMapping("/createProfessor")
        public ResponseEntity<Professor> createProfessor(@RequestBody Professor professor){
            return new ResponseEntity<>(collegeManagementService.createProfessor(professor),HttpStatus.CREATED);
        }

        @GetMapping("/assignSubjectToProfessor/{subjectId}/{professorId}")
        public ResponseEntity<Professor> assignSubjectToProfessor(@PathVariable Long subjectId,@PathVariable  Long professorId){
            return new ResponseEntity<>(collegeManagementService.assignSubjectToProfessor(professorId,subjectId),HttpStatus.CREATED);
        }

        @GetMapping("/assignStudentToProfessor/{studentId}/{professorId}")
        public ResponseEntity<Professor> assignStudentToProfessor(@PathVariable Long studentId ,@PathVariable  Long professorId){
            return new ResponseEntity<>(collegeManagementService.assignSubjectToProfessor(professorId,studentId),HttpStatus.CREATED);
        }

    @GetMapping("/getProfessor/{professorId}")
    public ResponseEntity<Professor> getProfessor(@PathVariable Long professorId){
        return new ResponseEntity<>(professorRepository.findById(professorId).get(),HttpStatus.CREATED);
    }
    @GetMapping("/getStudent/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable Long studentId){
        return new ResponseEntity<>(studentRepository.findById(studentId).get(),HttpStatus.CREATED);
    }

    @GetMapping("/getSubject/{subjectId}")
    public ResponseEntity<Subject> getSubject(@PathVariable Long subjectId){
        return new ResponseEntity<>(subjectRepository.findById(subjectId).get(),HttpStatus.CREATED);
    }

}
