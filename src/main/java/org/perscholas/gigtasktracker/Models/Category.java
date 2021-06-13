package org.perscholas.gigtasktracker.Models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    BigDecimal budget;
    String name;
    Date startdate;
    Date enddate;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Group group;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy="category")
    Set<Transaction> transactions = new TreeSet<>();
}
