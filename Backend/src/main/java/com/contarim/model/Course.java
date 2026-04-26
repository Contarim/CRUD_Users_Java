package com.contarim.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// import lombok.Data;
// @Data //método do lombok para gerar os getters e setters automaticamente

// @Table(name = "Cursos") -- > para vincular o nome da classe com o nome da tabela no banco de dados caso sejam diferentes

@Entity //indica que a classe é uma entidade/tabela do banco de dados
public class Course {
    
    @Id //indica que o atributo é a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.AUTO) //indica que o valor do id será gerado automaticamente pelo banco de dados
    private Long id;

    // @Column(name = "nome") -- > para vincular o nome do atributo com o nome da coluna no banco de dados caso sejam diferentes
    @Column(length = 200, nullable = false) //indica que a coluna terá um tamanho máximo de 200 caracteres e não poderá ser nula
    private String name;

    @Column(length = 50, nullable = false)
    private String category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
