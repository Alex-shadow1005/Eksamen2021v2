package com.example.eksamen2021.domain.services;

import java.util.List;

public class ProjectService {
  private WishRepository wishRepository = new WishRepository();

  public String addWish(Wish wish, User user) {
    int addWishSuccess = wishRepository.addWish(wish, user);
    if (addWishSuccess == 1) {
      return "redirect:/show";
    } else {
      System.out.println("sut :c");
      return "redirect:/addWish";
    }
  }

  public List<Wish> showAll(int id) {
    return wishRepository.showAll(id);
  }

}
