package pl.mwo2017.dziekanat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/index")
public class IndexController {

    private IUserService userService;


    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("index");
        model.addObject("list", userService.listAllUsers());
        return model;
    }


    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public ModelAndView deleteUsers(@PathVariable long id) {
        userService.deleteUser(id);
        return new ModelAndView("redirect:/index");
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView userRegister(@ModelAttribute("user") User user) {
        ModelAndView model = new ModelAndView("index");
        if (user != null) {
            userService.saveUser(user);
            model.addObject("warning", "User Registration Success");

        } else {
            model.addObject("danger", "Something Going Bad");

        }
        return new ModelAndView("redirect:/index");
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") long id) {
        ModelAndView model = new ModelAndView("edit");
        User user = userService.getUserById(id);
        model.addObject("user", user);
        return model;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(@RequestParam("id") long id, @RequestParam("name") String name, @RequestParam("surname") String surname,
            @RequestParam("adress") String adress) {
        User user = userService.getUserById(id);
        user.setName(name);
        user.setSurname(surname);
        user.setAdress(adress);
        userService.saveUser(user);
        return new ModelAndView("redirect:/index");
    }

}
