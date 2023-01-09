package dambi.accessingmongoumeak.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

import static com.mongodb.client.model.Filters.eq;

@Repository
public class MongoDBPelikulaRepository implements PelikulaRepository {

    private static final TransactionOptions txnOptions = TransactionOptions.builder()
            .readPreference(ReadPreference.primary())
            .readConcern(ReadConcern.MAJORITY)
            .writeConcern(WriteConcern.MAJORITY)
            .build();
    @Autowired
    private MongoClient client;
    private MongoCollection<Pelikula> pelikulaCollection;

    @PostConstruct
    void init() {
        pelikulaCollection = client.getDatabase("pelikulak").getCollection("filmoteka", Pelikula.class);
    }  

    // -----------------------
    // peliGuztiak
    @Override
    public List<Pelikula> peliGuztiak() {
        return pelikulaCollection.find().into(new ArrayList<>());
    }

    // peliById
    @Override
    public Pelikula peliById(int id) {
        // return pelikulaCollection.find(eq("_id", new ObjectId())).first();
        return pelikulaCollection.find(eq("_id", id)).first();
        // return pelikulaCollection.findById(id);
    }

    // aktorearen_Pelikulak
    @Override
    public List<Pelikula> aktorearenak(String izena) {

        List<Pelikula> pelikulak = pelikulaCollection.find().into(new ArrayList<>());
        List<Pelikula> aktorearen_Pelikulak = new ArrayList<>();

        for (int i = 0; i < pelikulak.size(); ++i) {

            for (int j = 0; j < pelikulak.get(i).getCast().size(); i++) {
                if (pelikulak.get(i).getCast().get(j).equals(izena)) {
                    aktorearen_Pelikulak.add(pelikulak.get(i));
                }
            }   
        }
        return aktorearen_Pelikulak;
    }

    //dataBatetikAurrerako_Pelikulak
    @Override
    public List<Pelikula> berriagoak(int urtea) {

        List<Pelikula> pelikulak = pelikulaCollection.find().into(new ArrayList<>());
        List<Pelikula> pelikulak_Urtetik_Aurrera = new ArrayList<>();

        for (int i = 0; i < pelikulak.size(); ++i) {

            if (pelikulak.get(i).getYear() > urtea) {
                pelikulak_Urtetik_Aurrera.add(pelikulak.get(i));
            }
        }
        return pelikulak_Urtetik_Aurrera;
    }


    //zuzendariaren_Pelikulak
    @Override
    public List<Pelikula> zuzendariarenak(String zuzendaria) {
        //List<Pelikula> pelikulak = pelikulaCollection.find(eq("Director{name}", zuzendaria_izena)).into(new ArrayList<>());

        List<Pelikula> pelikulak = pelikulaCollection.find().into(new ArrayList<>());
        List<Pelikula> zuzendariak_Egindakoak = new ArrayList<>();

        for (int i = 0; i < pelikulak.size(); ++i) {

            if (pelikulak.get(i).getDirector().getName().equals(zuzendaria)) {
                zuzendariak_Egindakoak.add(pelikulak.get(i));
            }
        }
        return zuzendariak_Egindakoak;
    }
    

    @Override
    public List<Director> zuzendariak() {
        // TODO Auto-generated method stub
        List<Pelikula> pelikulak = pelikulaCollection.find().into(new ArrayList<>());
        List<Director> zuzendariak_Desberdinak = new ArrayList<>();

        for (int i = 0; i < pelikulak.size(); ++i) {

            for (int j = 0; j < zuzendariak_Desberdinak.size(); j++) {
                if (!zuzendariak_Desberdinak.contains(pelikulak.get(i).getDirector())) {
                    zuzendariak_Desberdinak.add(pelikulak.get(i).getDirector());
                }
            }
        }

        return zuzendariak_Desberdinak;
    }



    @Override
    public Pelikula peliBerria(Pelikula peli) {
        // TODO Auto-generated method stub
        peli.setId(new ObjectId());
        pelikulaCollection.insertOne(peli);
        return peli;
    }


    @Override
    public Pelikula kastinaOsatzen(Pelikula peli) {
        // TODO Auto-generated method stub
        peli.setId(new ObjectId());
        pelikulaCollection.insertOne(peli);
        return peli;
    }


    @Override
    public long delete(int id) {
        return pelikulaCollection.deleteMany(eq("_id", id)).getDeletedCount();
    }


}


