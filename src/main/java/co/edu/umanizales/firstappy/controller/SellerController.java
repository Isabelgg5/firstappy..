package co.edu.umanizales.firstappy.controller;

import co.edu.umanizales.firstappy.model.Seller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/seller")
public class SellerController {
    @GetMapping
    public String getSeller(){
        String sellers = "Seller{id=10889283, name='lina', lastname='Hernandez', gender='Female', age=22, location='Manizales'}\n" +
                "Seller{id=10889284, name='Carlos', lastname='Ramirez', gender='Male', age=30, location='Bogotá'}\n" +
                "Seller{id=10889285, name='Ana', lastname='Martinez', gender='Female', age=27, location='Medellín'}\n" +
                "Seller{id=10889286, name='Luis', lastname='Gomez', gender='Male', age=35, location='Cali'}\n" +
                "Seller{id=10889287, name='Sofia', lastname='Lopez', gender='Female', age=24, location='Barranquilla'}";
        return"Seller";

    }
}
