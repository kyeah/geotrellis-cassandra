import org.apache.spark.{SparkConf, SparkContext}
import com.datastax.spark.connector._

object Main {
  def main(args: Array[String]) {
    val conf = new SparkConf(true)
      .set("spark.cassandra.connection.host", "127.0.0.1")
    
    conf.setJars(Seq(
      "lib/spark-cassandra-connector-assembly-1.2.0-SNAPSHOT.jar",
      "target/scala-2.10/geotrellis-cassandra-assembly-0.1.jar"))

    val sc = new SparkContext("spark://kyeh-yoga:7077", "test", conf)
    val rdd = sc.cassandraTable("test", "kv")

    println(rdd.count)
    println(rdd.first) // Not serializable error
    //println(rdd.map(_.getInt("value")).sum)  // Anon function missing error
    
    //val collection = sc.parallelize(Seq(("key3", 3), ("key4", 4)))
    //collection.saveToCassandra("test", "kv", SomeColumns("key", "value"))  // Classdefnotfound ..spark.streaming.Duration
  }
}
