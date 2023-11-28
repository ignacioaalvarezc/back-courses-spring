package com.sys.courses.back.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "exams")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examId;
    private String tittle;
    private String description;
    private String maxScore;
    private String questionsAmount;
    private boolean enabled = true;
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;
}
