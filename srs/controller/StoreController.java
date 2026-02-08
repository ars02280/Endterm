package controller;

import model.App;
import model.Category;
import model.Game;
import service.ProductService;

public class StoreController {

    private final ProductService service;

    public StoreController(ProductService service) {
        this.service = service;
    }

    public void run() {
        Category games = new Category(1, "Games");
        Category apps = new Category(2, "Apps");

        service.add(new Game(0, "CS2", 1.0, games, "Shooter"));
        service.add(new App(0, "Notion", 5.0, apps, true));
        try {
            service.add(new Game(0, "BrokenGame", -5, games, "RPG"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        service.getAll().forEach(p ->
                System.out.println(p.getDescription())
        );
    }
}
