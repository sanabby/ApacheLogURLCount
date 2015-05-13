LinksReader is a freely distributed source code that will count the URLs in apache log file and gives the maximum number of hits

It uses the https://github.com/nielsbasjes/logparser for Apache log parsing based on the LOG FORMAT

Pre-Req
=======
Maven - 3.0.3
Java - 1.7

Setup
======

1-> git clone https://github.com/nielsbasjes/logparser
2-> mvn package
3-> Install the jar files in the maven repo using the command:
    "mvn install:install-file -Dfile=<jar file> -DgroupId=<group> -DartifactId=<artiface> -Dversion=<version> -Dpackaging=jar"
4-> Note the dependencies in pom.xml and download and install those in the repo
5-> from linksreader-app, run mvn clean;mvn package
6-> Update run.sh to point to the right JAR location for the required jars
7-> There is a file called urllinks.txt that has data from /var/log/apache2/error.log, you can add entries to this file for testing scalability 
8-> Run ./run.sh





