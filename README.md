# SpringBootApacheCassandra
SpringBootApacheCassandra

Initial Commit

docker-compose up -d

docker run -it --network dc1ring--rm cassandra cqlsh resources_DC1N1_1

docker exec -it dc1ring bash
docker exec -it resources_DC1N1_1 bash

docker run --rm -v D:/var/lib/container_data:/data alpine ls /data
docker run --rm -v c:/Users:/data alpine ls /data

docker exec casandraLocal nodetool status

docker run --name casandraLocal cassandra:3.11.4

docker run -e DS_LICENSE=accept --memory 4g --name casandraLocal -d cassandra:3.11.4 -g -s -k

http://localhost:4041/swagger-ui.html

Develop To Master