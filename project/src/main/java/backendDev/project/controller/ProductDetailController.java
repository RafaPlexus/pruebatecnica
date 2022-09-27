package backendDev.project.controller;

import backendDev.project.dao.ProductDetailDAO;
import backendDev.project.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;

@RestController
public class ProductDetailController {

    @Autowired
    ProductDetailService productDetailService;

@GetMapping("/product/{productId}/similar")
    public List<ProductDetailDAO> similarProduct(@PathVariable("productId") String productId ){
try {
    return productDetailService.GetProductDetailList(productId);
} catch (Exception e){
    throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "Product not found"
    );
}
}





}
