package dambi.accessingmongoumeak.model;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface UmeaRepository {
    List<Umea> findAll();
    Umea findById(String id);
    Umea save(Umea person);
    long delete(String izena);
    long umearen_OpariKopurua(String izena);
    List<String> umearen_OpariZerrenda(String izena);
    // String umeGuztien_Opariak(List<Umea> umeak);
    StringBuffer opari_Guztiak();
}
