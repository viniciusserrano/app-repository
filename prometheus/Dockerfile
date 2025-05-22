# prometheus/Dockerfile

# Usa a imagem oficial do Prometheus
FROM prom/prometheus:latest

# Troca para root para instalar o envsubst
USER root

# Instala apenas o envsubst (faz parte do pacote gettext-base no Debian)
RUN apt-get update \
 && apt-get install -y --no-install-recommends gettext-base \
 && rm -rf /var/lib/apt/lists/*

# Copia o template e o entrypoint script
COPY prometheus.yml.tpl /etc/prometheus/prometheus.yml.tpl
COPY entrypoint.sh         /usr/local/bin/entrypoint.sh

# Dá permissão de execução
RUN chmod +x /usr/local/bin/entrypoint.sh

EXPOSE 9090

# Ao iniciar, gera o prometheus.yml a partir do .tpl substituindo
# a variável $GRAFANA_REMOTE_WRITE_PASSWORD e depois executa o Prometheus
ENTRYPOINT ["/usr/local/bin/entrypoint.sh"]
CMD ["--config.file=/etc/prometheus/prometheus.yml","--storage.tsdb.path=/prometheus","--web.listen-address=:9090"]
