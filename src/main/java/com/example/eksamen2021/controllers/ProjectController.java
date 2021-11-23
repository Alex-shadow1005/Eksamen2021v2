package com.example.eksamen2021.controllers;

import com.example.eksamen2021.domain.services.ProjectService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class ProjectController {
  private ProjectService projectService = new ProjectService();


  @GetMapping("/add-project")
  public String addWish(@ModelAttribute Wish wish, Model model) {
    model.addAttribute("wish", wish);
    model.addAttribute("sessionID", UserController.session.getUser_id());
    System.out.println(wish.getWishName() + wish.getWishDescription() + wish.getWishPrice());
    return "addwish";
  }

  @GetMapping("/show/{id}")
  public String showWishes(@PathVariable("id") int id, Model model) {
    List<Wish> wishes = projectService.showAll(id);
    model.addAttribute("wishes", wishes);
    return "show-wishes2";
  }

  @PostMapping("/save")
  public String saveWish(@ModelAttribute Wish wish, User user) {
    projectService.addWish(wish, user);
    return "redirect:/show-wishes";
  }

  @PostMapping("/addwish")
  public String addWishPost(@ModelAttribute Wish wish, User user, Model model) {
    model.addAttribute("wish", wish);
    //System.out.println(wish.getWishName() + wish.getWishDescription() + wish.getWishPrice());
    user.setUser_id(UserController.session.getUser_id());
    projectService.addWish(wish, user);
    return "redirect:/show/" + UserController.session.getUser_id();
  }

}
