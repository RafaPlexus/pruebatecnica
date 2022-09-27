package backendDev.project.service;

import backendDev.project.dao.ProductDetailDAO;

import javax.management.ServiceNotFoundException;
import java.util.List;

public interface ProductDetailService {

    List<ProductDetailDAO> GetProductDetailList(String productId) throws ServiceNotFoundException;
}
