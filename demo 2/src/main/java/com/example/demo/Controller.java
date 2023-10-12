package com.example.demo;

import com.example.demo.model.dao.TableDAO;
import com.example.demo.model.products.productDescription;
import com.example.demo.model.products.shellProduct;
import com.example.demo.model.productRegistry.Registry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Table;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@org.springframework.stereotype.Controller
public class Controller {
    private final TableDAO tableDAO;

    @Autowired
    public Controller(TableDAO tableDAO) {
        this.tableDAO = tableDAO;
    }

    @GetMapping("/")
    public String sayHello(){
        return "homePage";
    }

    @GetMapping("/admin")
    public String adminPage(){
        return "adminPages/admin";
    }

    @GetMapping("/newProductPage")
    public String getNewProductPage(@ModelAttribute("productDescription") productDescription product) {
        return "adminPages/newProductPage";
    }

    @PostMapping("/newProductPage")
    public String uploadFile(@RequestParam("file") MultipartFile file, @ModelAttribute("productDescription") productDescription product) {
        System.out.println("HERE WE ARE");
        if (product.getCategory() != null) {
            shellProduct instance;
            try {
                instance = Registry.createInstance(product.getCategory());
            } catch (IllegalAccessException | InstantiationException e) {
                throw new RuntimeException(e);
            }
            instance.setQuantity(Integer.parseInt(product.getQuantity()));
            instance.setPrice(Double.parseDouble(product.getPrice()));
            instance.setBrand(product.getBrand());
            instance.setDescription(product.getDescription());
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    String fileName = file.getOriginalFilename();
                    String filePath = "src/main/resources/" + product.getCategory() + "/" + fileName;
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
                    stream.write(bytes);
                    stream.close();
                    instance.setPhoto(filePath);
                    System.out.println("Death comes along the way");
                    tableDAO.create(instance);
                    System.out.println(instance.toString());
                    return "redirect:/newProductPage";
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    return "redirect:/newProductPage";
                }
            } else {
                System.out.println("HERE WE ARE 6");
                return "redirect:/newProductPage";
            }
        } else {
            System.out.println("HERE WE ARE 7");
            return "redirect:/newProductPage";
        }
    }

}
