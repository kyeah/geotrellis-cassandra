name := "geotrellis-cassandra"
version := "0.1"
scalaVersion := "2.10.4"
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "1.2.1",
  "org.apache.spark" %% "spark-streaming" % "1.2.1",
  "com.datastax.spark" %% "spark-cassandra-connector" % "1.2.0-alpha2"
)

mergeStrategy in assembly <<= (mergeStrategy in assembly) {
  old => {
    case PathList("META-INF", "MANIFEST.MF") => MergeStrategy.discard
    case x => MergeStrategy.last
  }
}
