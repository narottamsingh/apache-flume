FROM adoptopenjdk/openjdk11:latest


#RUN apk add --update bash && rm -rf /var/cache/apk/*
RUN  apt-get update \
  && apt-get install -y wget \
  && rm -rf /var/lib/apt/lists/*

ENV FLUME_VERSION 1.11.0
ENV FLUME_HOME /opt/lib/flume
 
RUN mkdir -p /opt/lib && \
    wget -q https://dlcdn.apache.org/flume/1.11.0/apache-flume-$FLUME_VERSION-bin.tar.gz -O /opt/lib/apache-flume-$FLUME_VERSION-bin.tar.gz && \
    tar xzf /opt/lib/apache-flume-$FLUME_VERSION-bin.tar.gz -C /opt/lib && \
    mv /opt/lib/apache-flume-$FLUME_VERSION-bin /opt/lib/flume && \
    rm /opt/lib/apache-flume-$FLUME_VERSION-bin.tar.gz && \
    mv $FLUME_HOME/conf/flume-conf.properties.template $FLUME_HOME/conf/flume-conf.properties

VOLUME [ "/opt/lib/flume/conf" ]

COPY docker-entrypoint.sh /docker-entrypoint.sh

#ENV HADOOP_VERSION=2.3.6
#ENV HADOOP_HOME=/opt/lib/hadoop-$HADOOP_VERSION

#RUN wget -q http://www.eu.apache.org/dist/hadoop/core/hadoop-$HADOOP_VERSION/hadoop-$HADOOP_VERSION.tar.gz -O /opt/lib/hadoop-$HADOOP_VERSION.tar.gz && \
#    tar xzf /opt/lib/hadoop-$HADOOP_VERSION.tar.gz -C /opt/lib && \
#    rm /opt/lib/hadoop-$HADOOP_VERSION.tar.gz


ADD my-flume-interceptor-1.0-SNAPSHOT.jar /opt/lib/flume/lib/
ADD flume.conf /opt/lib/flume/conf/flume.conf
ADD flume-timeinterxeptor.conf /opt/lib/flume/conf/flume-timeinterxeptor.conf
#ADD flume.log /opt/flume/flume.log
EXPOSE 44444

ENTRYPOINT [ "/docker-entrypoint.sh" ]
