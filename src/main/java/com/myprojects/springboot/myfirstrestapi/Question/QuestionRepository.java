package com.myprojects.springboot.myfirstrestapi.Question;

import com.myprojects.springboot.myfirstrestapi.Option.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {
}
