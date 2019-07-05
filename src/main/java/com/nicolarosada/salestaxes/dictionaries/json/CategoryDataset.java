package com.nicolarosada.salestaxes.dictionaries.json;

import java.util.List;

public class CategoryDataset {

  private List<String> books;
  private List<String> food;
  private List<String> drugs;

  public List<String> getBooks() {
    return books;
  }

  public void setBooks(List<String> books) {
    this.books = books;
  }

  public List<String> getFood() {
    return food;
  }

  public void setFood(List<String> food) {
    this.food = food;
  }

  public List<String> getDrugs() {
    return drugs;
  }

  public void setDrugs(List<String> drugs) {
    this.drugs = drugs;
  }
}
