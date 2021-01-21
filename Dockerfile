FROM gradle:6.8.0-jdk11
MAINTAINER  Reza Nojavan <reza.nojavan@email.com>
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

ENTRYPOINT ["gradle", "run", "-q", "--console=plain"]