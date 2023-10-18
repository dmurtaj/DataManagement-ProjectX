package ch.zhaw;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;

import org.bson.Document;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws IOException {
        // Logging ausschalten
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        lc.getLogger("org.mongodb.driver").setLevel(Level.OFF);

        ConnectionString connectionString = new ConnectionString(
                "mongodb+srv://admin:0406DmurWIN@cluster0.sduagzu.mongodb.net/?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .serverApi(ServerApi.builder()
                        .version(ServerApiVersion.V1)
                        .build())
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("proejctx");
        MongoCollection<Document> col = database.getCollection("product");
        MongoCollection<Document> col2 = database.getCollection("documentation");

        // Nodes
        AggregateIterable<Document> query1 = col.aggregate(Arrays.asList(new Document("$project", // Felder anzeigen oder ausblenden
                new Document("id", 1L) // anzeigen
                        .append("name", 1L) // anzeigen 
                        .append("_id", 0L)))); // ausblenden

        ArrayList<Document> nodesList = query1.into(new ArrayList<Document>());

        // Edges
        AggregateIterable<Document> query2 = col2.aggregate(Arrays.asList(new Document("$lookup", // Liest Daten aus einer anderen Collection in die aktuelle Collection (Join zwischen zwei Collections)
                new Document("from", "documentation") // "andere" Collection
                        .append("localField", "content") // Daten aus der "originalen" Collection
                        .append("foreignField", "content") // Daten aus der "anderen" Collection
                        .append("as", "result")), // Objekte mit Übereinstimmungen im content werden in result gespeichert
                new Document("$unwind",
                        new Document("path", "$result")), // Zerlegt result, da product und content mehrere Documentations haben können.
                new Document("$project",
                        new Document("product.id", 1L)
                                .append("result.product.id", 1L)
                                .append("_id", 0L))));

        ArrayList<Document> edgesList = query2.into(new ArrayList<Document>());

        // Export
        // Nodes
        ArrayList<String> nodes = new ArrayList<>();

        for (int i = 0; i < nodesList.size(); i++) {
            String row = nodesList.get(i).get("id").toString() + ","
                    + nodesList.get(i).get("name").toString();
            nodes.add(row);
        }

        FileWriter writer1 = new FileWriter("C:/VisualStudioProjects/DataManagement/ProjectX/mongodb/demo/nodes.csv");

        writer1.append("id,name\n");

        for (String row : nodes) {
            writer1.append(row);
            writer1.append("\n");
        }

        // Edges
        ArrayList<String> edges = new ArrayList<>();

        for (int i = 0; i < edgesList.size(); i++) {
            Integer product1 = edgesList.get(i).get("result", Document.class).get("product", Document.class)
                    .getInteger("id");
            Integer product2 = edgesList.get(i).get("product", Document.class).getInteger("id");

            if (product1 < product2) { // Es wird gecheckt, ob die ID von product2 grösser ist, damit man keine doppelte Einträge hat (1 zeigt auf 2, 2 zeigt auf 1 = ist dasselbe)
                edges.add(product1.toString() + "," + product2.toString());
            }
        }

        FileWriter writer2 = new FileWriter("C:/VisualStudioProjects/DataManagement/ProjectX/mongodb/demo/edges.csv");

        writer2.append("lhs,rhs\n");

        for (String products : edges) {
            writer2.append(products);
            writer2.append("\n");
        }

        writer1.close();
        writer2.close();
    }
}