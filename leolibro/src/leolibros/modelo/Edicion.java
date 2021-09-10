/**
 *
 * @Model Edicion
 *  Representa la logica para la tabla Edicion
 *  de la base de datos leolibros.sql
 * 
 */
package leolibros.modelo;

/**
 *
 * @Author Luis Jose Espinoza Alvarado ing.espinozalj at gmail.com
 *
 */
public class Edicion {
    // Declaracion de variables atributos del modelo
    int id;
    String annio;
    String idioma;
    String copias;

    // Contrustor por defecto
    public Edicion() {
    }

    /**
    * Creación del constructor.
    * @param id PK ISBN de la edicion
    * @param annio Annio de la edicion
    * @param idioma Idioma de la edicion
    * @param copias Copias de la edicion
    **/
    public Edicion(int id, String nom, String annio, String idioma, String copias) {
        this.id = id;
        this.annio = annio;
        this.idioma = idioma;
        this.copias = copias;

    }

    /**
    * Getter Id. Permite obtener el Atributo ISBN de la Edicion.
    * @return Id
    **/
    public int getId() {
        return id;
    }

    /**
    * Setter Id. Asigna un valor al atributo ISBN de la Edicion
    * @param id
    **/
    public void setId(int id) {
        this.id = id;
    }

    /**
    * Getter Annio. Permite obtener el Atributo Annio de la Edicion.
    * @return Id
    **/
    public String getAnnio() {
        return annio;
    }

    /**
    * Setter Annio. Asigna un valor al atributo Annio de la Edicion
    * @param annio
    **/
    public void setAnnio(String annio) {
        this.annio = annio;
    }   
    
    /**
    * Getter Idioma. Permite obtener el Atributo idioma de la Edicion.
    * @return idioma
    **/
    public String getIdioma() {
        return idioma;
    }

    /**
    * Setter Idioma. Asigna un valor al atributo Idioma de la Edicion
    * @param idioma
    **/
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }  
    
    /**
    * Getter Copias. Permite obtener el Atributo Copias de la Edicion.
    * @return copias
    **/
    public String getCopias() {
        return copias;
    }

    /**
    * Setter Copias Asigna un valor al atributo Copias de la Edicion
    * @param copias
    **/
    public void setCopias(String copias) {
        this.copias = copias;
    }  
}
