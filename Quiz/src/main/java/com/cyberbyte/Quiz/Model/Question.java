package com.cyberbyte.Quiz.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String category;
    private String question;
    private String  op1;
    private String  op2;
    private String  op3;
    private String  op4;
    private String  answer;
    private String  difficulty;
}
