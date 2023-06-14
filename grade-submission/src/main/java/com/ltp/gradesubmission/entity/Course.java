package com.ltp.gradesubmission.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Course")
@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class Course {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

     @NonNull
    @Column(name = "code", nullable = false)
    private String code;

    @NonNull
    @Column(name = "subject", nullable = false)
    private String subject;

    @NonNull
    @Column(name = "description", nullable = false)
    private String description;

}
