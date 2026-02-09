package controller;

import model.App;
import model.Category;
import model.Game;
import service.ProductService;

public class    StoreController {

    private final ProductService service;

    public StoreController(ProductService service) {
        this.service = service;
    }

    public void run() {
        Category games = new Category(1, "Games");
        Category apps = new Category(2, "Apps");

        service.add(new Game(0L, "CS2", 1.0, games, "Shooter"));
        service.add(new App(2L, "Notion", 5.0, apps));
        service.add(new App(3L, "3Drender", 10.0, apps));
        service.add(new Game(4L, "Minecraft", 15.0, games,"Sandbox"));
        try {
            service.add(new Game(0L, "BrokenGame", -5, games, "RPG"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        service.getAll().forEach(p ->
                System.out.println(p.getDescription())
        );
    }
}
