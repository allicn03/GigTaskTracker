package org.perscholas.gigtasktracker.Controllers;

import org.perscholas.gigtasktracker.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController
{
//    @Autowired
//    private UserService userService;

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String getLogin (ModelMap model)
    {
        User user = new User();
        model.put("user", user);

        return "login";
    }

}
