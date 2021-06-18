package org.perscholas.gigtasktracker.Controllers;

import org.perscholas.gigtasktracker.Models.User;
import org.perscholas.gigtasktracker.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController
{
    @Autowired
    private UserService userService;

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String getLogin (ModelMap model)
    {
        User user = new User();
        model.put("user", user);
        return "login";
    }

    @RequestMapping(value="/register", method=RequestMethod.GET)
    public String getRegister (ModelMap model) {
        User user = new User();
        model.put("user", user);
        return "register";
    }

    @RequestMapping(value="/register", method=RequestMethod.POST)
    public String postRegister (@ModelAttribute User user, ModelMap model) {
        // Some problem here that needs to be fixed... StringUtils is deprecated find another way besides isEmpty
        if(!user.getPassword().isEmpty() && !user.getConfirmPassword().isEmpty() ) {
            if (!user.getPassword().equals(user.getConfirmPassword())) {
                model.put("error", "Passwords don't match");
                return "register";
            }
        }
        if(user.getPassword().isEmpty() || user.getConfirmPassword().isEmpty()) {
            model.put("error", "You must choose a password");
            return "register";
        }
        user = userService.saveUser(user);
        Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
        return "redirect:/budget";
    }

}
