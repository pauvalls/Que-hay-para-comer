FROM openjdk:11

ARG APPNAME_BACK_VERSION

COPY build/libs/appname-back.infrastructure-${APPNAME_BACK_VERSION}.jar appname_back.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=test", "-jar", "appname_back.jar"]
