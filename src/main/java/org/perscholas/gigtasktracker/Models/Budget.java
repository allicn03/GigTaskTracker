package org.perscholas.gigtasktracker.Models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Getter
@Setter
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name="budget_id")
    Long id;
    String name;
    @ManyToMany
    @JoinTable(inverseJoinColumns = @JoinColumn(name="user_id"), joinColumns=@JoinColumn(name="budget_id"))
    Set<User> users = new HashSet<>();
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="budget")
    Set<Group> groups = new TreeSet<>();

}
