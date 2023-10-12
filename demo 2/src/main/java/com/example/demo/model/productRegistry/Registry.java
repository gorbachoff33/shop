package com.example.demo.model.productRegistry;

import com.example.demo.model.products.shellProduct;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

//при запуске приложения надо зарегистрировать все классы через апликейшен
public class Registry {
  private static Registry instance = null;
  private static final Map<String, Class<? extends shellProduct>> classMap = new HashMap<>();
  private Registry() {
  }
  public static Registry getInstance() {
    if (instance == null) {
      instance = new Registry();
    }
    return instance;
  }

  public static void registerClass(String className, Class<? extends shellProduct> clas) {
    classMap.put(className, clas);
  }

  public static shellProduct createInstance(String className) throws IllegalAccessException, InstantiationException {
    Class<? extends shellProduct> clazz = classMap.get(className);
    if (clazz != null) {
      try {
        return clazz.getDeclaredConstructor().newInstance();
      } catch (NoSuchMethodException | InvocationTargetException e) {
        e.printStackTrace();
        throw new IllegalArgumentException("Failed to create an instance of class: " + className, e);
      }
    } else {
      throw new IllegalArgumentException("Class not found: " + className);
    }
  }
}


