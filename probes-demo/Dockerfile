FROM maven:latest as builder
COPY . /usr/src/build
WORKDIR /usr/src/build
RUN mvn clean package -DskipTests -f /usr/src/build && mkdir /usr/src/wars/
RUN find /usr/src/build/ -iname 'spring-boot-maven-plugin.war' -exec cp {} /usr/src/wars/ \;

FROM tomcat:latest
RUN rm -rf $CATALINA_HOME/webapps/ROOT
COPY --from=builder /usr/src/wars/spring-boot-maven-plugin.war $CATALINA_HOME/webapps/ROOT.war

# allows tomcat to create ROOT dir when launching
RUN chgrp -R 0 $CATALINA_HOME/webapps $CATALINA_HOME/temp && \
    chmod -R g=u $CATALINA_HOME/webapps $CATALINA_HOME/temp

COPY ./agent/jmx.yaml /data/jmx.yaml

EXPOSE 8080
EXPOSE 8181
CMD ["catalina.sh", "run"]
