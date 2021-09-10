/**
 *
 * @Model Autor
 *  Representa la logica para la tabla Autor 
 *  de la base de datos leolibros.sql
 * 
 */
package leolibros.modelo;

/**
 *
 * @Author Luis Jose Espinoza Alvarado ing.espinozalj at gmail.com
 *
 */
public class Autor {
    // Declaración de variables atributos del modelo
    int id; 
    String nom; 

    // Contrustor por defecto
    public Autor() {
    }

    /**
    * Creación del constructor.
    * @param id PK Autor
    * @param nom Nombre autor
    **/
    public Autor(int id, String nom) {
        this.id = id;
        this.nom = nom;

    }

    /**
    * Getter Id. Permite obtener el Atributo Id del Autor.
    * @return Id
    **/
    public int getId() { //Metodo para obtener el objeto id
        return id;
    }

    /**
    * Setter Id. Asigna un valor al atributo Id del Autor
    * @param id
    **/
    public void setId(int id) { //Metodo para modificar el objeto id
        this.id = id;
    }

    /**
    * Getter Nom. Permite obtener el Atributo Nom del Autor.
    * @return nom
    **/
    public String getNom() {    //Metodo para obtener el objeto nom
        return nom;
    }

    /**
    * Setter Id. Asigna un valor al atributo Nom del Autor
    * @param nom
    **/
    public void setNom(String nom) {    //Metodo para modificar el objeto nom
        this.nom = nom;
    }   
    
}
