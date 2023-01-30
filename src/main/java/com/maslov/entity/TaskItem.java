package com.maslov.entity;

import jakarta.persistence.*;



@Entity
@Table(name = "task_item")
public class TaskItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Авто заполнение значениц в БД
    private Long id;
    @Column(nullable = false) // Поле не может быть пустым
    private String name;

    public TaskItem() {
    }

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

}
