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
public class MongoDBUmeaRepository implements UmeaRepository {

    private static final TransactionOptions txnOptions = TransactionOptions.builder()
            .readPreference(ReadPreference.primary())
            .readConcern(ReadConcern.MAJORITY)
            .writeConcern(WriteConcern.MAJORITY)
            .build();
    @Autowired
    private MongoClient client;
    private MongoCollection<Umea> umeaCollection;

    @PostConstruct
    void init() {
        umeaCollection = client.getDatabase("gabonak").getCollection("umeak", Umea.class);
    }

    @Override
    public List<Umea> findAll() {
        return umeaCollection.find().into(new ArrayList<>());
    }

    @Override
    public Umea findById(String id) {
        return umeaCollection.find(eq("_id", new ObjectId(id))).first();
    }

    @Override
    public Umea save(Umea umea) {
        umea.setId(new ObjectId());
        umeaCollection.insertOne(umea);
        return umea;
    }

    @Override
    public long delete(String izena) {
        return umeaCollection.deleteMany(eq("izena", izena)).getDeletedCount();
    }

    @Override
    public long umearen_OpariKopurua(String izena) {
        // Umea umea= umeaRepository.findById(izena);
        Umea umea = umeaCollection.find(eq("izena", izena)).first();
        return umea.getOpariak().size();
    }

    @Override
    public List<String> umearen_OpariZerrenda(String izena) {
        // Umea umea= umeaRepository.findById(izena);
        Umea umea = umeaCollection.find(eq("izena", izena)).first();
        List<String> opariak = umea.getOpariak();
        return opariak;
        // return umea.getOpariak();
    }


    @Override
    public List<Umea> findByOparia(String oparia) {
        // Umea umea= umeaRepository.findById(izena);
        List<Umea> umeak = umeaCollection.find(eq("opariak", oparia)).into(new ArrayList<>());
        return umeak;
        // return umea.getOpariak();
    }


    @Override
    public List<Umea> hiru_Opari_BainoGehiago() {

        List<Umea> umeak = umeaCollection.find().into(new ArrayList<>());
        List<Umea> umeak_Opari_Asko = new ArrayList<>();

        for (int i = 0; i < umeak.size(); ++i) {

            if (umeak.get(i).getOpariak().size() >= 3) {
                umeak_Opari_Asko.add(umeak.get(i));
            }
        }
        
        return umeak_Opari_Asko;
        // return umea.getOpariak();
    }

    // List<Umea> umeak

    @Override
    public StringBuffer opari_Guztiak() {
        
        StringBuffer emaitza = new StringBuffer();
        List<Umea> umeak = umeaCollection.find().into(new ArrayList<>());

        for (int i = 0; i < umeak.size(); ++i) {
            for (int j = 0; j < umeak.get(i).getOpariak().size(); ++j) {
                String opari_bakoitza = umeak.get(i).getOpariak().get(j).toString();
                emaitza.append(opari_bakoitza + "\n");
            }
        }

        return emaitza;
    }

}

// https://www.mongodb.com/docs/manual/reference/method/db.collection.find/#mongodb-method-db.collection.find
//https://stackoverflow.com/questions/7811163/query-for-documents-where-array-size-is-greater-than-1

// List<Umea> umeak = umeaCollection.find().into(new ArrayList<>());
// StringBuffer emaitza = new StringBuffer();