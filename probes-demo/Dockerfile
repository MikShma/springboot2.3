FROM maven:3-jdk-11 as builder
VOLUME /tmp/m2 /root/.m2
COPY . /usr/src/build
WORKDIR /usr/src/build
RUN mvn clean package -DskipTests -f /usr/src/build && mkdir /usr/src/wars/
RUN find /usr/src/build/ -iname 'probes-demo-0.0.1-SNAPSHOT.war' -exec cp {} /usr/src/wars/ \;


FROM tomcat:9-jdk11-openjdk
#FROM tomcat:latest
#FROM tomcat@sha256:50a1949ec76b949e91770b41a739bfb3553e5abb33b2c8110bd05f18ad4755ea
RUN rm -rf $CATALINA_HOME/webapps/ROOT
COPY --from=builder /usr/src/wars/probes-demo-0.0.1-SNAPSHOT.war $CATALINA_HOME/webapps/ROOT.war

# allows tomcat to create ROOT dir when launching
RUN chgrp -R 0 $CATALINA_HOME/webapps $CATALINA_HOME/temp && \
    chmod -R g=u $CATALINA_HOME/webapps $CATALINA_HOME/temp

EXPOSE 8080
EXPOSE 8181
CMD ["catalina.sh", "run"]
