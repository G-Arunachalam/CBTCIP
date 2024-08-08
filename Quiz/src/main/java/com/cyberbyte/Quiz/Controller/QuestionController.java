package com.cyberbyte.Quiz.Controller;

import com.cyberbyte.Quiz.Model.Question;
import com.cyberbyte.Quiz.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
     QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{lang}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String lang){
        return questionService.getQuestionsByCategory(lang);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question q){
        return questionService.addQuestion(q);
    }

    @DeleteMapping("remove/{n}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int n){
        return questionService.deleteQuestion(n);
    }

}
