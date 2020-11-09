FROM java:8
MAINTAINER lijianlong <2137450576@qq.com>
VOLUME /tmp 
ADD ./target/splay-0.0.1-SNAPSHOT.jar splay.jar 
ENTRYPOINT ["java","-jar","/splay.jar","--spring.profiles.active=prod"]