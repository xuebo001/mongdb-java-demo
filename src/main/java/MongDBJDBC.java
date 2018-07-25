import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

/**
 * MongDBJDBC
 * Created by fxb on 2018/7/24.
 */
public class MongDBJDBC {


    public static final String MONGO_IP = "127.0.0.1";
    public static final int MONGO_PORT = 27017;

    /** 获取MongoCollection对象
     * @param databaseName
     * @param collectionName
     * @return
     */
    public static MongoCollection getMongoDatabase(String databaseName, String collectionName) {

        MongoClient mongoClient = new MongoClient(MONGO_IP, MONGO_PORT);
        MongoDatabase mongoDatabase = mongoClient.getDatabase(databaseName);
        MongoCollection mongoCollection = mongoDatabase.getCollection(collectionName);
        return mongoCollection;
    }

    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient("127.0.0.1",27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("fxb");
        System.out.println("connect to database successfully");

        MongoCollection mongoCollection = mongoDatabase.getCollection("fxb");
        System.out.println("集合选择成功");


        /**
         * 文档插入
         */
      /*  Document document = new Document("title","MongoDB")
                .append("description","database");

        List<Document> documents = new ArrayList<Document>();
        documents.add(document);

        mongoCollection.insertMany(documents);
        System.out.println("文档插入成功");*/

        /**
         * 检索文档
         */
        /*FindIterable<Document> findIterable = mongoCollection.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while (mongoCursor.hasNext()){
            System.out.println(mongoCursor.next());
        }*/

        /**
         * 更新文档   将文档中likes=100的文档修改为likes=200
         */
       /* mongoCollection.updateMany(Filters.eq("likes",100),new Document("$set",new Document("likes",200)));
        //查看结果
        FindIterable<Document> findIterable = mongoCollection.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while (mongoCursor.hasNext()){
            System.out.println(mongoCursor.next());
        }*/

        /**
         * 删除文档
         */

        mongoCollection.deleteOne(Filters.eq("likes",200));
        //查看结果
        FindIterable<Document> findIterable = mongoCollection.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while (mongoCursor.hasNext()){
            System.out.println(mongoCursor.next());
        }

    }

}
