package com.nicolarosada.salestaxes.dictionaries.json;

import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class JsonReader {

  private static final String DATASET_NAME = "dataset.json";

  public static CategoryDataset read() {
    CategoryDataset dataset = null;

    try {
      FileReader fileReader = new FileReader(JsonReader.class.getClassLoader().getResource(DATASET_NAME).getFile());
      dataset = new Gson().fromJson(fileReader, CategoryDataset.class);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    return dataset;
  }

}
