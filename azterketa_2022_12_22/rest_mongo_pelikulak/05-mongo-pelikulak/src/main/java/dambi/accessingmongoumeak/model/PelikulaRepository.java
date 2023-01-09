package dambi.accessingmongoumeak.model;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface PelikulaRepository {

    //GET
    List<Pelikula> peliGuztiak();   //todas las peliculas
    Pelikula peliById(int id);  //buscar película por id

    List<Pelikula> aktorearenak(String izena);  //peliculas de X actor
    List<Pelikula> berriagoak(int urtea);   //peliculas de X año en adelante
    List<Pelikula> zuzendariarenak(String zuzendaria);    //peliculas de X director
    List<Director> zuzendariak(); //lista de todos los directores (sin repetir)

    //POST
    Pelikula peliBerria(Pelikula peli); //insertar una nueva pelicula en la base de datos

    //PUT
    Pelikula kastinaOsatzen(Pelikula peli);  //nuevo actor en una película

    //DELETE
    long delete(int id);    //eliminar pelicula por id
}
