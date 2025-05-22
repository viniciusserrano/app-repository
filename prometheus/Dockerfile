# ── Etapa 1: gera o prometheus.yml com envsubst ───────────────────
FROM alpine:3.18 AS renderer

# instala apenas o gettext (que contém envsubst)
RUN apk add --no-cache gettext

# traz só o tpl
WORKDIR /etc/prometheus
COPY prometheus.yml.tpl .

# substitui variáveis de ambiente no template e gera o arquivo final
RUN envsubst < prometheus.yml.tpl > prometheus.yml

# ── Etapa 2: imagem oficial do Prometheus ─────────────────────────
FROM prom/prometheus:latest

# copia o prometheus.yml já processado
COPY --from=renderer /etc/prometheus/prometheus.yml /etc/prometheus/prometheus.yml

# expõe a porta (opcional, pois a imagem já expõe 9090)
EXPOSE 9090

ENTRYPOINT ["/bin/sh","-c", "\
  envsubst < /etc/prometheus/prometheus.yml.tpl > /etc/prometheus/prometheus.yml && \
  echo '--- prometheus.yml gerado ---' && \
  sed -n '1,20p' /etc/prometheus/prometheus.yml && \
  exec /bin/prometheus --config.file=/etc/prometheus/prometheus.yml \
"]
