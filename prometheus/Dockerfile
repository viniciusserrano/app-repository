FROM prom/prometheus:latest

# traz o tpl
COPY prometheus.yml.tpl /etc/prometheus/prometheus.yml.tpl

# instala envsubst (via gettext)
USER root
RUN apk add --no-cache gettext

# entrypoint: substitui vars e sobe o Prometheus
ENTRYPOINT [ "/bin/sh", "-c",
  "envsubst < /etc/prometheus/prometheus.yml.tpl > /etc/prometheus/prometheus.yml && exec /bin/prometheus --config.file=/etc/prometheus/prometheus.yml"
]

EXPOSE 9090
