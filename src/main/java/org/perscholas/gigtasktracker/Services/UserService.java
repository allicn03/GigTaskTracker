package org.perscholas.gigtasktracker.Services;

import org.perscholas.gigtasktracker.Models.Authority;
import org.perscholas.gigtasktracker.Models.User;
import org.perscholas.gigtasktracker.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public User saveUser(User user) {
        Authority authority = new Authority();
        authority.setAuthority("ROLE_USER");
        authority.setUser(user);

        Set<Authority> authorities = new HashSet<>();
        authorities.add(authority);

        user.setAuthorities(authorities);
        user = userRepo.save(user);

        return user;
    }
}
