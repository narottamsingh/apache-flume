FROM probablyfine/flume
ADD my-flume-interceptor-1.0-SNAPSHOT.jar /opt/flume/lib/
ADD flume.conf /var/tmp/flume.conf
ADD flume-timeinterxeptor.conf /var/tmp/flume-timeinterxeptor.conf
ADD flume.conf /opt/flume/conf/flume.conf
#ADD flume.log /opt/flume/flume.log
ADD  flume-run.sh /opt/flume/bin/flume-run.sh
RUN chmod 777 -R /opt/flume/bin/flume-run.sh
EXPOSE 44444

ENTRYPOINT ["/opt/flume/bin/flume-run.sh"]

#ENTRYPOINT [ "flume-ng", "agent", "-c", "/opt/flume/conf", "-f", "/var/tmp/flume-timeinterxeptor.conf", "-n", "agent", "-Dflume.root.logger=INFO,console" ]
