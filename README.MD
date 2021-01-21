# How to build
To build this application you only need to run below command in root of project

`gradlew build`

# How to run
To run application you can use 2 ways. First open source code in your IDE and run application there 
second use gradle to run it. To use gradle to run application please execute below command in root of project

`gradlew run -q --console=plain`

to exit the application just type `exit` and hit the enter button, application will take care of the rest. Cloudn't be 
easier than this :)

# Build docker image 
This application also support docker, and you can build a docker image for this application .
to create a docker image please execute below command in root folder

`docker builder -t calculator:latest .`

# Run docker image
After you successfully build docker image, you can now run docker image through below command

`docker run -i -t calculator:latest`