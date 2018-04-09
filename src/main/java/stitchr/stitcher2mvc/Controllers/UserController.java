package stitchr.stitcher2mvc.Controllers;

import stitchr.stitcher2mvc.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("register")
public class UserController {

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {

        model.addAttribute(new User());
        model.addAttribute("title", "Register");
        return "stitchr/user/newuser";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid User user,
                      Errors errors) {

        model.addAttribute(user);

        if (!errors.hasErrors()) {
            return "stitchr/user/newuser";
        }

        return "stitchr/user/welcome";

    }

}