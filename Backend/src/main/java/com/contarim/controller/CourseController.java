package com.contarim.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.contarim.repository.CourseRepository;

// import lombok.AllArgsConstructor;
// @AllArgsConstructor //método do lombok para gerar um construtor com todos os atributos da classe, ou seja, nesse caso, o construtor irá receber um CourseRepository como parâmetro e irá atribuí-lo ao atributo courseRepository

import com.contarim.model.Course;

@RestController //indica que a classe é um controlador de requisições REST, ou seja, ela irá receber as requisições HTTP e retornar as respostas em formato JSON

@RequestMapping("/api/courses") //indica o caminho base para acessar os endpoints desse controlador, ou seja, todas as requisições para esse controlador deverão começar com /api/courses


public class CourseController {
    
    private final CourseRepository courseRepository; 
    
    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    
    // @RequestMapping(method = RequestMethod.GET) -- método para mapear as requisições GET para o endpoint /api/courses
    @GetMapping //método para mapear as requisições GET para o endpoint /api/courses
    public List<Course> list () {
        return courseRepository.findAll();
    }

}
