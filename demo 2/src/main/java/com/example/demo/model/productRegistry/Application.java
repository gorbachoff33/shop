package com.example.demo.model.productRegistry;


import com.example.demo.model.products.Notebook;
import com.example.demo.model.products.Phone;
import com.example.demo.model.products.Televizors;

//тут надо перечислить все классы
public class Application {
  static {
    Registry.registerClass("Phone", Phone.class);
    Registry.registerClass("Notebook", Notebook.class);
    Registry.registerClass("Televizors", Televizors.class);
  }
}
