package backendDev.project.serviceImpl;

import backendDev.project.dao.ProductDetailDAO;
import backendDev.project.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import javax.management.ServiceNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {

    @Autowired
    private RestTemplate restTemplate;

    private final String similarIdURl = "http://localhost:3001/product/{productId}/similarids";

    private final String productDetailUrl = "http://localhost:3001/product/{productId}";

    public List<ProductDetailDAO> GetProductDetailList(String productId) throws ServiceNotFoundException {

        Map<String, String> params = new HashMap<String, String>();
        params.put("productId", productId);

        List similarIdsList = restTemplate.getForObject(similarIdURl,List.class,params);

        List<ProductDetailDAO> ListDetails = productDetails(similarIdsList);

        if(ListDetails.isEmpty()){
            throw new ServiceNotFoundException();
        }
        return ListDetails;
    }

    private List<ProductDetailDAO> productDetails( List similarIdsList){

        List<ProductDetailDAO> productDetailsList = new ArrayList<>();

        int index = 0;


        while( index < similarIdsList.size()){

            String elementId = similarIdsList.get(index).toString();

            Map<String, String> paramsDetails = new HashMap<String, String>();
            paramsDetails.put("productId", elementId);

            try {
                ProductDetailDAO detailsById = restTemplate.getForObject(productDetailUrl, ProductDetailDAO.class, paramsDetails);

                productDetailsList.add(detailsById);
            }catch (Exception e){
                //ignored
            }

            index++;
        }


        return productDetailsList;
    }
}
