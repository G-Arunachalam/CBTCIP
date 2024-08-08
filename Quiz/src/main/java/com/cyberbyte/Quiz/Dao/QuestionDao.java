package com.cyberbyte.Quiz.Dao;

import com.cyberbyte.Quiz.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {
    public List<Question> findByCategory(String lang);

    public List<Question> findByDifficulty(String lang);


}
