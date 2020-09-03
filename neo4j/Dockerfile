FROM neo4j:4.0.5

COPY apoc-4.0.0.14.jar /plugins/apoc-4.0.0.14.jar
COPY data.dump /data/data.dump
USER neo4j

CMD /var/lib/neo4j/bin/neo4j-admin set-initial-password admin ; /var/lib/neo4j/bin/neo4j-admin load --from=/data/data.dump --database=neo4j --force ; neo4j console
