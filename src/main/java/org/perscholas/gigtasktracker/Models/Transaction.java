package org.perscholas.gigtasktracker.Models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Date date;
    BigDecimal total;
    String type;
    String note;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    Category category;

}
