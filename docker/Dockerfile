FROM sforzando-dockerv2-local.jfrog.io/java-atomist:0.11.2-20190708225156

MAINTAINER Jim Clark <jim@atomist.com>

RUN mkdir -p /usr/src/app \
    && mkdir -p /usr/src/app/bin \
    && mkdir -p /usr/src/app/lib

WORKDIR /usr/src/app

COPY target/lib /usr/src/app/lib

COPY target/metajar/server.jar /usr/src/app/

CMD ["-Djava.net.preferIPv4Stack=true", "-Xmx2048m", "-jar", "/usr/src/app/server.jar", "-Dclojure.core.async.pool-size=20", "-Datomist.kafka-client.pool-size=20"]

EXPOSE 3000
