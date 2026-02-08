package patterns.builder;


import model.BaseEntity;
import patterns.factory.ProductFactory;

public class ProductBuilder {
    private Long id;
    private String name;
    private String type;
    private double value;

    public ProductBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public ProductBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder type(String type) {
        this.type = type;
        return this;
    }

    public ProductBuilder value(double value) {
        this.value = value;
        return this;
    }

    public BaseEntity build() {
        return ProductFactory.create(type, id, name, value);
    }
}
