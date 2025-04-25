package co.edu.umanizales.firstappy.service;

import co.edu.umanizales.firstappy.model.Location;
import co.edu.umanizales.firstappy.model.State;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class LocationService {

    @Getter
    private List<Location> locations;
    private List<State> states;

    @Value( "${locations_filename}" )
    private String locationsFilename;

    @PostConstruct
    public void readLocationsFromCSV() throws IOException, URISyntaxException {
        locations = new ArrayList<>();
        states = new ArrayList<>();

        Path pathFile = Paths.get(ClassLoader.getSystemResource(locationsFilename).toURI());

        try (CSVReader csvReader = new CSVReader(new FileReader(pathFile.toString()))) {
            String[] line;
            csvReader.skip(1);

            //32 departamentos
            locations.add(new Location("17","CALDAS"));
            locations.add(new Location("05","ANTIOQUIA"));
            locations.add(new Location("66","RISARALDA"));
            locations.add(new Location("91","AMAZONAS"));
            locations.add(new Location("81","ARAUCA"));
            locations.add(new Location("13","ATLANTICO"));
            locations.add(new Location("11","BOLIVAR"));
            locations.add(new Location("15","BOYACA"));
            locations.add(new Location("18","CAQUETA"));
            locations.add(new Location("66","CASANARE"));
            locations.add(new Location("19","CAUCA"));
            locations.add(new Location("20","CESAR"));
            locations.add(new Location("11","CUNDINAMARCA"));
            locations.add(new Location("68","CHOCO"));
            locations.add(new Location("27","CORDOBA"));
            locations.add(new Location("94","GUAINIA"));
            locations.add(new Location("95","GUAVIARE"));
            locations.add(new Location("41","HUILA"));
            locations.add(new Location("50","LA GUAJIRA"));
            locations.add(new Location("14","MAGDALENA"));
            locations.add(new Location("52","META"));
            locations.add(new Location("73","NARIÑO"));
            locations.add(new Location("54","NORTE DE SANTANDER"));
            locations.add(new Location("82","PUTUMAYO"));
            locations.add(new Location("63","QUINDIO"));
            locations.add(new Location("88","SAN ANDRES Y PROVIDENCIA"));
            locations.add(new Location("60","SANTANDER"));
            locations.add(new Location("74","TOLIMA"));
            locations.add(new Location("76","VALLE DEL CAUCA"));
            locations.add(new Location("84","SUCRE"));
            locations.add(new Location("97","VAUPES"));
            locations.add(new Location("99","VICHADA"));


            // Leer todas las filas del CSV
            while ((line = csvReader.readNext()) != null) {

                // Crear un nuevo objeto Location y agregarlo a la lista
                locations.add(new Location(line[2],line[3]));
                boolean exists = false;
                for (State state : states) {
                    if (state.getCode().equals(line[0])) {
                        exists = true;
                        break;
                    }
                }
                if(exists == false){
                    states.add(new State(line[0],line[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;  // Lanza la excepción para que pueda manejarse en la capa superior si es necesario
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    public Location getLocationByCode(String code) {
        for (Location location : locations) {
            if (location.getCode().equals(code)) {
                return location;
            }
        }
        return null;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public Location getLocationByName(String name) {
        for (Location location : locations) {
            if((location.getDescription().toLowerCase()).equals(name.toLowerCase())){
                return location;
            }
        }
        return null;
    }

    public List<Location> getLocationByInitialLetter(Character letter) {
        List<Location> initialLetters = new ArrayList<>();
        for (Location location : locations) {
            System.out.println(location.getDescription().charAt(0));
            if(location.getDescription().charAt(0) == letter){
                initialLetters.add(location);
            }
        }
        return initialLetters;
    }

    public List<Location> getLocationsByStateCode(String stateCode) {
        List<Location> states = new ArrayList<>();
        for (Location location : locations) {
            if(location.getCode().equals(stateCode)){
                states.add(location);
            }
        }
        return states;
    }

    public List<State> getByStates() {
        return states;
    }

    public State getStateByCode(String code) {
        for (State state : states) {
            if (state.getCode().equals(code)) {
                return state;
            }
        }
        return null;
    }

    public List<Location> getStates() {
        List<Location> states = new ArrayList<>();
        for (Location location : locations) {
            if(location.getCode().length() ==2){
                states.add(location);
                states.add(getLocationByCode(location.getCode()+"001"));

            }
        }
        return states;
    }

}