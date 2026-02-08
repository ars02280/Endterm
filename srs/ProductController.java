import model.BaseEntity;
import patterns.builder.ProductBuilder;
import service.ProductService;

import java.util.List;

public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public BaseEntity create(@RequestBody ProductDTO dto) {
        BaseEntity product = new ProductBuilder()
                .name(dto.name())
                .type(dto.type())
                .value(dto.value())
                .build();

        return service.create(product);
    }

    @GetMapping
    public List<BaseEntity> all() {
        return service.findAll();
    }
}
