FROM probablyfine/flume
ADD my-flume-interceptor-1.0-SNAPSHOT.jar /opt/flume/lib/
#ADD flume.conf /var/tmp/flume.conf
ADD flume-timeinterxeptor.conf /var/tmp/flume-timeinterxeptor.conf
#ADD flume.conf /opt/flume/conf/flume.conf
ADD flume.log /opt/flume/flume.log

EXPOSE 44444

ENTRYPOINT [ "flume-ng", "agent", "-c", "/opt/flume/conf", "-f", "/var/tmp/flume-timeinterxeptor.conf", "-n", "agent", "-Dflume.root.logger=INFO,console" ]
