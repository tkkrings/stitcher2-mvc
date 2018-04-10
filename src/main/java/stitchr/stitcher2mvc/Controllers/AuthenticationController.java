package stitchr.stitcher2mvc.Controllers;

import stitchr.stitcher2mvc.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import stitchr.stitcher2mvc.models.forms.LoginForm;
import stitchr.stitcher2mvc.models.forms.RegisterForm;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("register")
public class AuthenticationController extends AbstractController {

    @RequestMapping(value = "register")
    public String registerForm(Model model) {
        model.addAttribute(new RegisterForm());
        model.addAttribute("title", "Register");
        return "stitcher/user/register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String add(@ModelAttribute @Valid RegisterForm form, Errors errors, HttpServletRequest request) {

        if (errors.hasErrors()) {
            return "stitchr/user/register";
        }

        User existingUser = userDao.findByUsername(form.getUsername());

        if (existingUser != null) {
            errors.rejectValue("username", "username.alreadyexists", "That username is already taken");
            return "stitchr/user/register";
        }

        User newUser = new User(form.getUsername(), form.getPassword());
        userDao.save(newUser);
        setUserInSession(request.getSession(), newUser);

        return "redirect:";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute(new LoginForm());
        model.addAttribute("title", "Log In");
        return "stitchr/user/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@ModelAttribute @Valid LoginForm form, Errors errors, HttpServletRequest request) {

        if (errors.hasErrors()) {
            return "stitchr/user/login";
        }

        User theUser = userDao.findByUsername(form.getUsername());
        String password = form.getPassword();

        if (theUser == null) {
            errors.rejectValue("username", "user.invalid", "That username does not exist");
            return "stitchr/user/login";
        }

        setUserInSession(request.getSession(), theUser);

        return "redirect:";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login";
    }

}