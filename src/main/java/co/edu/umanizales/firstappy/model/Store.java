package co.edu.umanizales.firstappy.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Store {
    private int idTienda;
    private String nombre;
    private String ciudad;
    private String codigoCiudad;

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombreTienda) {
        this.nombre = nombreTienda;
    }

    public String getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(String CodigoCiudad) {
        this.codigoCiudad = CodigoCiudad;
    }

    public Store(int idTienda, String ciudad, String nombreTienda, String codigoCiudad) {
        this.idTienda = idTienda;
        this.nombre = nombreTienda;
        this.ciudad = ciudad;
        this.codigoCiudad = codigoCiudad;
    }
}
