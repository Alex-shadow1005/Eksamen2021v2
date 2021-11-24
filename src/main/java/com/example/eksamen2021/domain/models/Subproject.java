package com.example.eksamen2021.domain.models;

public class Subproject {

private int subproject_id;
private String subproject_name;
private String subproject_description;
private int subproject_price;

  /*
  private User user;
  private String projectlistName;
  */


  public Subproject(int subproject_id, String subproject_name, String subproject_description, int subproject_price) {
    this.subproject_id = subproject_id;
    this.subproject_name = subproject_name;
    this.subproject_description = subproject_description;
    this.subproject_price = subproject_price;
  }

  public Subproject(int subproject_id, String subproject_name, String subproject_description) {
    this.subproject_id = subproject_id;
    this.subproject_name = subproject_name;
    this.subproject_description = subproject_description;
  }

  public Subproject() {
  }

  public int getSubproject_id() {
    return subproject_id;
  }

  public void setSubproject_id(int subproject_id) {
    this.subproject_id = subproject_id;
  }

  public String getSubproject_name() {
    return subproject_name;
  }

  public void setSubproject_name(String subproject_name) {
    this.subproject_name = subproject_name;
  }

  public String getSubproject_description() {
    return subproject_description;
  }

  public void setSubproject_description(String subproject_description) {
    this.subproject_description = subproject_description;
  }

  public int getSubproject_price() {
    return subproject_price;
  }

  public void setSubproject_price(int subproject_price) {
    this.subproject_price = subproject_price;
  }

}
