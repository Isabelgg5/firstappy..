package co.edu.umanizales.firstappy.service;

import co.edu.umanizales.firstappy.model.Store;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class StoreService {

    private List<Store> stores = new ArrayList<>();

    @PostConstruct
    public void cargarStoresDesdeCsv() {
        System.out.println("Cargando tiendas desde el CSV...");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                getClass().getClassLoader().getResourceAsStream("stores.csv")))) {

            String linea;
            boolean esPrimera = true;

            while ((linea = br.readLine()) != null) {
                if (esPrimera) {
                    esPrimera = false;
                    continue;
                }

                String[] datos = linea.split(",");
                if (datos.length >= 4) {
                    Store store = new Store(
                            Integer.parseInt(datos[0].trim()),
                            datos[2].trim(),
                            datos[1].trim(),
                            datos[3].trim()
                    );
                    stores.add(store);
                    System.out.println("Tienda cargada: " + store.getNombre());
                }
            }
        } catch (Exception e) {
            System.out.println("Error cargando el CSV:");
            e.printStackTrace();
        }
    }

    public List<Store> obtenerTodosLosStores() {
        return stores;
    }
}


