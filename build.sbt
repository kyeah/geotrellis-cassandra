name := "geotrellis-cassandra"
version := "0.1"
scalaVersion := "2.10.4"
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "1.2.1",
  "com.datastax.spark" %% "spark-cassandra-connector" % "1.1.0"
)
