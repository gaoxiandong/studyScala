name := "scalaStudy"

version := "1.0"

scalaVersion := "2.12.5"

libraryDependencies += "commons-codec" % "commons-codec" % "1.10"
//zip
libraryDependencies += "org.zeroturnaround" % "zt-zip" % "1.12"
libraryDependencies += "com.rm.ai" % "detect-thrift" % "0.2"

//guice
libraryDependencies += "net.codingwell" % "scala-guice_2.12" % "4.1.0"
libraryDependencies += "com.google.inject" % "guice" % "4.0"

//log
libraryDependencies += "org.slf4j" % "jul-to-slf4j" % "1.7.7"
libraryDependencies += "org.slf4j" % "log4j-over-slf4j" % "1.7.7"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.3"

//test
libraryDependencies += "junit" % "junit" % "4.12" % Test

//scala test
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % "test"


