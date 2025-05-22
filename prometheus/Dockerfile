FROM prom/prometheus:latest

# traz o tpl
COPY prometheus.yml.tpl /etc/prometheus/prometheus.yml.tpl

# instala envsubst (via gettext)
USER root
RUN apk add --no-cache gettext

# expõe a porta
EXPOSE 9090

# entrypoint: faz envsubst e sobe o prometheus
ENTRYPOINT ["/bin/sh","-c","envsubst < /etc/prometheus/prometheus.yml.tpl > /etc/prometheus/prometheus.yml && exec /bin/prometheus --config.file=/etc/prometheus/prometheus.yml"]
