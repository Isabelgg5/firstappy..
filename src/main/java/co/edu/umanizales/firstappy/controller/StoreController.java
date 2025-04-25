package co.edu.umanizales.firstappy.controller;

import co.edu.umanizales.firstappy.model.Store;
import co.edu.umanizales.firstappy.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping
    public List<Store> listarTiendas() {
        return storeService.obtenerTodosLosStores();

    }
}
