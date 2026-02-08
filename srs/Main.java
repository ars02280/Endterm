import controller.StoreController;
import repository.ProductRepository;
import service.ProductService;
import service.ProductServiceImpl;

public class Main {
    public static void main(String[] args) {

        ProductService service =
                new ProductServiceImpl(new ProductRepository());

        StoreController controller =
                new StoreController(service);

        controller.run();
    }
}
