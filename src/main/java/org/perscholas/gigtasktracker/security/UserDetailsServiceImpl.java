package org.perscholas.gigtasktracker.security;

import org.perscholas.gigtasktracker.Models.User;
import org.perscholas.gigtasktracker.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;
    @Override
    public UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException {
            User user = userRepo.findByUsername(username);

            if(user == null)
                throw new UsernameNotFoundException("User does not exist!");
            return new UserSecurity(user);
    }
}
