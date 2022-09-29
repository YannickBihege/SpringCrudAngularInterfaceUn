package com.bihege.springAngular.crudfirst.com.bihege.springAngular.crudfirst.api.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="USER_REGISTRATION_TABLE")
public class User {

    // @GeneratedValue
    @Id
    private int user_id;
    private String password;
    private String name;
    private String email;
    private int experience;
    private String domain;

    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
