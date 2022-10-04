package homework5;

import homework5.entity.Student;
import homework5.serviceDao.StudentService;

import java.util.Random;

public class StartApp {
    public static void main(String[] args) {
        homeworkMethod();
    }

    public static void homeworkMethod () {
        StudentService studentService = new StudentService();
        Student student = new Student();
        Random random = new Random();
        for (int i = 1; i <= 1000; i++) {
            student.setName("Name" + i);
            student.setMark(random.nextInt(5));
            studentService.saveStudent(student);
        }
        System.out.println(studentService.findAllStudent());
        student = studentService.findStudent(1);
        student.setName("Aleksey");
        studentService.updateStudent(student);
        System.out.println(studentService.findStudent(1));
        studentService.deleteStudent(student);
        System.out.println(studentService.findAllStudent());
    }
}
