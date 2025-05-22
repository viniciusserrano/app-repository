# prometheus/Dockerfile

# 1) Puxa o binário oficial do Prometheus
FROM prom/prometheus:latest AS prom_base

# 2) Imagem final usando Alpine, para poder ter envsubst
FROM alpine:3.18

# instala apenas o envsubst (faz parte do pacote gettext)
RUN apk add --no-cache gettext

# copia o binário do Prometheus da stage anterior
COPY --from=prom_base /bin/prometheus /bin/prometheus

# copia o template e o entrypoint script
COPY prometheus.yml.tpl       /etc/prometheus/prometheus.yml.tpl
COPY entrypoint.sh            /entrypoint.sh

# dá permissão de execução
RUN chmod +x /bin/prometheus /entrypoint.sh

EXPOSE 9090

# no startup: gera o prometheus.yml e roda o prometheus
ENTRYPOINT ["/entrypoint.sh"]
CMD ["--config.file=/etc/prometheus/prometheus.yml","--storage.tsdb.path=/prometheus","--web.listen-address=:9090"]
