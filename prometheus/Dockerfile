FROM prom/prometheus:latest AS prometheus

# (suas etapas de cópia do prometheus.yml.tpl e do binário aqui...)

FROM alpine:3.18
RUN apk add --no-cache gettext
COPY --from=prometheus /bin/prometheus /bin/prometheus
COPY prometheus.yml.tpl /etc/prometheus/prometheus.yml.tpl

EXPOSE 9090

ENTRYPOINT ["/bin/sh","-c", "\
    echo '=== gerando /etc/prometheus/prometheus.yml ==='; \
    envsubst < /etc/prometheus/prometheus.yml.tpl > /etc/prometheus/prometheus.yml; \
    head -n 20 /etc/prometheus/prometheus.yml; \
    echo '============================================'; \
    exec /bin/prometheus --config.file=/etc/prometheus/prometheus.yml \
"]
