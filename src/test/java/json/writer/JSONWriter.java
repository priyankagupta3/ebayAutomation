package com.bulb.json.writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author chandrakant.gupta
 * @Since 4/4/2018.
 */
public class JSONWriter<T> {

  public void write(T obj,String fileName) throws IOException {

    String data = convertJSONToString(obj);
  //  JsonArray jsonArray = new JsonParser().parse(model).getAsJsonArray();
    FileWriter fileWriter = new FileWriter(fileName);
    fileWriter.write(convertJSONToString((T) new JsonParser().parse(data)));
    fileWriter.flush();
    fileWriter.close();
    System.out.println("File has been written successfully on this location - " +fileName);
  }

  private String convertJSONToString(T object) {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    return gson.toJson(object);
  }

  public String getReourceFile(String fileName){
    String filePath = getClass().getClassLoader().getResource("").toString().split("file:/")[1];
    filePath = filePath.replaceAll("%20"," ");
    return filePath+fileName;
  }
}
