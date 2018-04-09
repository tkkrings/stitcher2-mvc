package stitchr.stitcher2mvc.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import stitchr.stitcher2mvc.models.Yarn;
import stitchr.stitcher2mvc.models.data.YarnDao;

import javax.validation.Valid;

@Controller
@RequestMapping("stash")
public class StashController {

    @Autowired
    private YarnDao yarnDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("yarns", yarnDao.findAll());
        model.addAttribute("title", "Your Yarn Stash");

        return "stitchr/stash/stashlist";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddYarnForm(Model model) {
        model.addAttribute("title", "Add Yarn To Stash");
        return "stitchr/stash/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddYarnForm(@ModelAttribute @Valid Yarn newYarn, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Yarn");
            return "stitchr/stash/add";
        }

        yarnDao.save(newYarn);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveYarnForm(Model model) {
        model.addAttribute("yarns", yarnDao.findAll());
        model.addAttribute("title", "Remove Yarn");
        return "stitchr/stash/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveYarnForm(@RequestParam int[] yarnIds) {

        for (int yarnId : yarnIds) {
            yarnDao.deleteById(yarnId);
        }

        return "redirect:";
    }

}
