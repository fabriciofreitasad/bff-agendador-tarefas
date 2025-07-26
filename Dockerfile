FROM ubuntu:latest
LABEL authors="garra"

ENTRYPOINT ["top", "-b"]