package com.sys.courses.back.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String tittle;
    private String description;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Exam> exams = new LinkedHashSet<>();
}
