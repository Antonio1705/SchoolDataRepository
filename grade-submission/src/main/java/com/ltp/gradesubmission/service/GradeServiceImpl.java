package com.ltp.gradesubmission.service;

import java.util.List;
import java.util.Optional;

import com.ltp.gradesubmission.Exception.GradeNotFoundException;
import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.entity.Grade;
import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.repository.CourseRepository;
import com.ltp.gradesubmission.repository.GradeRepository;
import com.ltp.gradesubmission.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    GradeRepository gradeRepository;

    @Autowired
    CourseRepository courseRepository;

    @Override
    public Grade getGrade(Long studentId, Long courseId) {
        System.out.println(gradeRepository.findByStudentIdAndCourseId(studentId,courseId) + "<<<<<<<<<<<<<<<<<<<<<<");
        Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId,courseId);
        if (grade.isPresent()){
            Grade unwrappedGrade = grade.get();
            return unwrappedGrade;
        }else {
            throw new GradeNotFoundException(studentId,courseId);
        }
    }

    @Override
    public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).get();
        Course course = courseRepository.findById(courseId).get();
        grade.setStudent(student);
        grade.setScore(grade.getScore());
        grade.setCourse(course);
        return gradeRepository.save(grade);
    }

    @Override
    public Grade updateGrade(String score, Long studentId, Long courseId) {
        Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId,courseId);
        if (grade.isPresent()){
            Grade unwrappedGrade = grade.get();
            unwrappedGrade.setScore(score);
            return gradeRepository.save(unwrappedGrade);
        }else {
            throw new GradeNotFoundException(studentId,courseId);
        }
    }

    @Override
    public void deleteGrade(Long studentId, Long courseId) {
        Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId,courseId);
        if (grade.isPresent()){
            Grade unwrappedGrade = grade.get();
            gradeRepository.delete(unwrappedGrade);
        }

        //gradeRepository.deleteByStudentIdAndCourseId(studentId,courseId);
    }

    @Override
    public List<Grade> getStudentGrades(Long studentId) {
        return null;
    }

    @Override
    public List<Grade> getCourseGrades(Long courseId) {
        return null;
    }

    @Override
    public List<Grade> getAllGrades() {
        return null;
    }
}