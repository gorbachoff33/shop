package com.example.demo.model.dao;

import com.example.demo.model.productRegistry.Registry;
import com.example.demo.model.products.shellProduct;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class TableDAO {

  private  final SessionFactory sessionFactory;

  @Autowired
  public TableDAO(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Transactional
  public List<shellProduct> index(){
    String name = "Phone";
    Session session = sessionFactory.getCurrentSession();
    return session.createQuery("select p from Phone p", shellProduct.class)
            .getResultList();
  }

  @Transactional
  public shellProduct get(String table, int index) throws IllegalAccessException, InstantiationException {
    shellProduct instance = Registry.createInstance(table);
    return sessionFactory.getCurrentSession().get(instance.getClass(), index);
  }

  @Transactional
  public void create(shellProduct instance) {
    sessionFactory.getCurrentSession().save(instance);
    System.out.printf(this.index().toString());
  }


  @Transactional
  public void update(shellProduct instance, int quantity, double price, String brand,  String description, String photo_path){
    instance.setQuantity(quantity);
    instance.setPrice(price);
    instance.setBrand(brand);
    instance.setDescription(description);
    instance.setPhoto(photo_path);
    sessionFactory.getCurrentSession().save(instance);
  }

  @Transactional
  public void delete(int index){
    Session session = sessionFactory.getCurrentSession();
    shellProduct instance = session.get(shellProduct.class, index);
    if (instance != null) {
      session.delete(instance);
    }
    sessionFactory.getCurrentSession().save(instance);
  }
}
