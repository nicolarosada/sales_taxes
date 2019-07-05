package com.nicolarosada.salestaxes.dictionaries.utils;

public class StringGroup {
  private final String[] name;
  private final int groupSize;
  private int newIdx = 0;

  public StringGroup(String[] name, int groupSize) {
    this.name = name;
    this.groupSize = groupSize;
  }

  public String next() {
    if (newIdx + groupSize > name.length) {
      newIdx = 0;
      return null;
    }

    String output = "";
    for (int idx = newIdx; idx < newIdx + groupSize; idx++) {
      output += name[idx] + " ";
    }

    newIdx++;
    return output.trim();
  }
}
