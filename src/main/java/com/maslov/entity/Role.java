package com.maslov.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "role_users")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role() {
    }

    public Long getId() {
        return Id;
    }

    public Role(Long id, String name) {
        this.Id = id;
        this.name = name;
    }

    public void setId(Long id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "Role{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", users=" + users +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
