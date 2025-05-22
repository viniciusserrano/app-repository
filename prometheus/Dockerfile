FROM prom/prometheus:latest AS prometheus

# (suas etapas de cópia do prometheus.yml.tpl e do binário aqui...)

FROM alpine:3.18
RUN apk add --no-cache gettext
COPY --from=prometheus /bin/prometheus /bin/prometheus
COPY prometheus.yml.tpl /etc/prometheus/prometheus.yml.tpl

EXPOSE 9090

ENTRYPOINT ["/bin/sh","-c", "\
  envsubst < /etc/prometheus/prometheus.yml.tpl > /etc/prometheus/prometheus.yml && \
  echo '--- BEGIN CONFIG ---'; cat /etc/prometheus/prometheus.yml; echo '--- END CONFIG ---'; \
  exec /bin/prometheus --config.file=/etc/prometheus/prometheus.yml \
"]
