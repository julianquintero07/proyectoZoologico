FROM amazoncorretto:17-alpine
VOLUME /tmp
COPY *.jar zoologico.jar
RUN adduser -D -g '' appuser && chown appuser: /zoologico.jar
USER appuser
RUN sh -c 'touch \zoologico.jar'
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=70 -Djava.security.egd=file:/dev/./urandom"
# Replace with a non-root user to avoid running the container with excessive privileges
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS  -jar zoologico.jar" ]
