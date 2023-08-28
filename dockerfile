FROM tomcat
WORKDIR /usr/local/tomcat/webapps
COPY ./hotelms*.jar .
EXPORT 8080
CMD ["catalina.sh" "run"]