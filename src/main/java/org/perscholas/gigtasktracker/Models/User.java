package org.perscholas.gigtasktracker.Models;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
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

    @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="users")
    Set<Budget> budgets = new TreeSet<>();



}