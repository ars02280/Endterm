package patterns.builder;

import model.BaseEntity;
import model.Category;
import model.Product;
import patterns.factory.ProductFactory;

public class ProductBuilder {

    private Long id;
    private String name;
    private String type;
    private double value;
    private Category category;
    private String extra; // например size / weight

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

    public ProductBuilder category(Category category) {
        this.category = category;
        return this;
    }

    public ProductBuilder extra(String extra) {
        this.extra = extra;
        return this;
    }

    public Product build() {
        return ProductFactory.create(
                type,
                id,
                name,
                value,
                category,
                extra
        );
    }
}
