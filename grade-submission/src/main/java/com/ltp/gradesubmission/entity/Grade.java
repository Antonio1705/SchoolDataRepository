package com.ltp.gradesubmission.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Grade")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name = "score", nullable = false)
    private String score;


    @ManyToOne(optional = false)
    @JoinColumn(name = "Student_id", referencedColumnName = "id", nullable = false)
    private Student student;
}
