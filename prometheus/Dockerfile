FROM prom/prometheus:latest

COPY prometheus.yml.tpl /etc/prometheus/prometheus.yml.tpl

USER root
RUN apt-get update \
 && apt-get install -y --no-install-recommends gettext-base \
 && rm -rf /var/lib/apt/lists/*

EXPOSE 9090

ENTRYPOINT ["/bin/sh","-c", "\
  envsubst < /etc/prometheus/prometheus.yml.tpl > /etc/prometheus/prometheus.yml && \
  exec /bin/prometheus --config.file=/etc/prometheus/prometheus.yml \
"]
