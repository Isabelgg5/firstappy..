package co.edu.umanizales.firstappy.controller;

import co.edu.umanizales.firstappy.model.Location;
import co.edu.umanizales.firstappy.model.Seller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/seller")
public class SellerController {
    @GetMapping
    public Seller getSeller(){
        Location manizales = new Location("17001", "Manizales");
        Location pereira = new Location("66001", "Pereira");

        Seller laura = new Seller("1073858", "laura", "perez", 'f', (byte) 22, manizales);
        Seller juan = new Seller("9376262", "juan", "santana", 'm', (byte) 34, pereira);
        Seller lina = new Seller("7483528", "lina", "giraldo", 'f', (byte) 27, manizales);
        Seller santiago = new Seller("5173683", "santiago", "ramirez", 'm', (byte) 45, pereira);
        Seller pepe = new Seller("4028492", "pepe", "gallego", 'm', (byte) 38, manizales);

        return laura;
    }
}
