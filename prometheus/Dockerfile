# ── Etapa 1: base Alpine com envsubst ───────────────────────────
FROM alpine:3.18 AS renderer

RUN apk add --no-cache gettext

WORKDIR /etc/prometheus
COPY prometheus.yml.tpl .

# ── Etapa 2: container final ────────────────────────────────────
FROM prom/prometheus:latest

# Copia o template e o script de entrypoint
COPY --from=renderer /etc/prometheus/prometheus.yml.tpl /etc/prometheus/prometheus.yml.tpl
COPY entrypoint.sh /entrypoint.sh

RUN chmod +x /entrypoint.sh

EXPOSE 9090

ENTRYPOINT ["/entrypoint.sh"]
CMD ["--config.file=/etc/prometheus/prometheus.yml",
     "--storage.tsdb.path=/prometheus",
     "--web.listen-address=:9090"]
