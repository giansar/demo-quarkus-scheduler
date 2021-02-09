FROM debian:stable-slim
RUN apt update
RUN apt install openjdk-11-jre-headless -y
RUN apt autoremove -y

