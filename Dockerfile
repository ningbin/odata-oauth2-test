FROM java:8
MAINTAINER ningbin 
WORKDIR /
ADD target/odata-oauth2-test-1.0.0.RELEASE.jar odata-oauth2-test-1.0.0.RELEASE.jar
EXPOSE 8080
CMD ["java","-jar","/odata-oauth2-test-1.0.0.RELEASE.jar"]