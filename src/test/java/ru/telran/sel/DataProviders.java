package ru.telran.sel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.DataProvider;

public class DataProviders {

  @DataProvider
  public static Iterator<Object[]> loadUserFromFile() throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(
        DataProviders.class.getResourceAsStream("/user.data")));
    
    List<Object[]> userData = new ArrayList<Object[]>();
    String line = in.readLine();
    while (line != null) {
      userData.add(line.split(";"));
      line = in.readLine();
    }
    
    in.close();
    
    return userData.iterator();
  }
  
  @DataProvider
  public Iterator<Object[]> users() {
    List<Object[]> data = new ArrayList<Object[]>();
    for (int i = 0; i < 10; i++) {
      data.add(new Object[]{
         generateRandomName(), generateRandomPassword() 
      });
    }
    return data.iterator();
  }

  private Object generateRandomPassword() {
    return "password" + new Random().nextInt();
  }

  private Object generateRandomName() {
    return "user" + new Random().nextInt();
  }
  @DataProvider
  public static Iterator<Object[]> usersSimple() {
    List<Object[]> data = new ArrayList<Object[]>();
    data.add(new Object[]{"demo30","1234"});
    data.add(new Object[]{"demo29","1234"});
    return data.iterator();
  }
  
  @DataProvider
  public static Iterator<Object[]> usersSimpleNeg() {
    List<Object[]> data = new ArrayList<Object[]>();
    data.add(new Object[]{" "," "});
    data.add(new Object[]{"admin","admin"});
    return data.iterator();
  }
}
