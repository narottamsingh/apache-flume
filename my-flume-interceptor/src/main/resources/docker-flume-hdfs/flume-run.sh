#!/bin/sh
echo "Hello world"
/opt/flume/bin/flume-ng agent --conf /opt/flume/conf --conf-file /var/tmp/flume-timeinterxeptor.conf --name agent
