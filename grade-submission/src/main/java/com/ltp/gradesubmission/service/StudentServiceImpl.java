package com.ltp.gradesubmission.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ltp.gradesubmission.Exception.StudentNotFoundException;
import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student getStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()){
            return student.get();
        }else {
            throw  new StudentNotFoundException(id);
        }
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getStudents() {
        List<Student> list = new ArrayList<>();
        Iterable<Student> s = studentRepository.findAll();
        for (Student i : s){
            list.add(i);
        }
        return list;

    }

}