package org.perscholas.gigtasktracker.Models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Getter
@Setter
public class Authority implements GrantedAuthority {

    private static final long serialVersionUID = 7750762537576434670L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String authority;
    @ManyToOne
    User user;
}
