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

# (a imagem oficial já tem ENTRYPOINT=/bin/prometheus e CMD="--config.file=..."),
# mas, caso queira, você pode explicitar:
# ENTRYPOINT [ "/bin/prometheus" ]
# CMD [ "--config.file=/etc/prometheus/prometheus.yml",
#       "--storage.tsdb.path=/prometheus",
#       "--web.listen-address=:9090" ]
