package org.perscholas.gigtasktracker.Repositories;

import org.perscholas.gigtasktracker.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
   User findByUsername(String username);
}
