package stitchr.stitcher2mvc.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import stitchr.stitcher2mvc.models.Yarn;
import stitchr.stitcher2mvc.models.YarnData;

@Controller
@RequestMapping("stash")
public class StashController {

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("yarns", YarnData.getAll());
        model.addAttribute("title", "Yarn");

        return "stitchr/stash/stashlist";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddYarnForm(Model model) {
        model.addAttribute("title", "Add Yarn To Stash");
        return "stitchr/stash/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddYarnForm(@ModelAttribute Yarn newYarn) {
        YarnData.add(newYarn);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveYarnForm(Model model) {
        model.addAttribute("yarns", YarnData.getAll());
        model.addAttribute("title", "Remove Yarn");
        return "stitchr/stash/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveYarnForm(@RequestParam int[] yarnIDs) {

        for(int yarnID : yarnIDs) {
            YarnData.remove(yarnID);
        }

        return "redirect:";
    }

}
