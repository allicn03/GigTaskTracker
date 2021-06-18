package org.perscholas.gigtasktracker.Models;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String username;
    String password;
    @Transient
    String confirmPassword;

    @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="users")
    Set<Budget> budgets = new TreeSet<>();

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="user")
    Set<Authority> authorities = new HashSet<>();

}