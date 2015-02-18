Geotrellis-Cassandra
========================

This is a spike for integrating Spark + Apache Cassandra support into GeoTrellis.

# Installation

## Spark Cluster

Install Spark and launch a standalone master server using `$SPARK_HOME/sbin/start-master.sh`. This will print out the `spark:://HOST:PORT` URL used to connect workers.

Then, start a worker using `./bin/spark-class org.apache.spark.deploy.worker.Worker spark://IP:PORT`. Check that it is connected at the master's portal, default `http://localhost:8080/`.

## Cassandra Cluster

Install Cassandra and launch a local cluster using `sudo service cassandra start`. Check that it is running using `nodetool status`.

## Version Compatibility

Note the version compatibility requirements between Spark, Cassandra, and Datastax's Connector.

| Connector | Spark         | Cassandra |
| --------- | ------------- | --------- |
| 1.2       | 1.2           | 2.1, 2.0  |
| 1.1       | 1.1, 1.0      | 2.1, 2.0  |
| 1.0       | 1.0, 0.9      | 2.0       |

# Running

After setting up your Spark and Cassandra clusters, edit `Main.scala` to point to your clusters. Run `sbt run` to execute the `main` function, which provides an example of interacting with RDDs in your Cassandra tables.