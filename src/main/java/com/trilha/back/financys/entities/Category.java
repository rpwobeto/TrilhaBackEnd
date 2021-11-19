package com.trilha.back.financys.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "tb_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (nullable = false)
    private String name;
    private String description;

    @OneToMany(mappedBy = "category", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Entry> entry;

    @Deprecated
    public Category(){}

    public Category(int id, String name, String description){

        this.id = id;
        this.name = name;
        this.description = description;
    }


    public long getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

}