FROM openjdk:17
WORKDIR /app

COPY src/main/java /app

CMD ["/bin/bash"]
