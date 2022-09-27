package backendDev.project.dao;


import lombok.Data;


@Data
public class ProductDetailDAO {
    private String id;
    private String name;
    private Number price;
    private Boolean availability;

}
