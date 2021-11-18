package com.trilha.back.financys.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (nullable = false, unique = true)
    private String name;
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Entry> entry;

    @Deprecated
    public Category(){}

    public Category(int id, String name, String description){

        this.id = id;
        this.name = name;
        this.description = description;
    }


    public void setId(long id){
        this.id = id;
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

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}