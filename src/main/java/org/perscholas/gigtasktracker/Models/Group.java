package org.perscholas.gigtasktracker.Models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name="groups")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Getter
@Setter
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    User user;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "group")
    Set<Category> categories = new TreeSet<>();
}
