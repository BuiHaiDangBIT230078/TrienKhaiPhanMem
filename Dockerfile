# Dùng image Tomcat chính thức
FROM tomcat:10.1.41-jdk17

# Gỡ ứng dụng mặc định (nếu có)
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy file WAR từ build ra container
COPY target/CarRental2-0.0.1-SNAPSHOT-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Expose cổng
EXPOSE 8089
