package com.sys.courses.back.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;
    @Column(length = 5000)
    private String content;
    private String image;
    private String firstOption;
    private String secondOption;
    private String thirdOption;
    private String fourthOption;
    @Transient
    private String givenAnswer;
    private String answer;
    @ManyToOne(fetch = FetchType.EAGER)
    private Exam exam;
}
