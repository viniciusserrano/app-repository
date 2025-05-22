#!/usr/bin/env sh
# gera o prometheus.yml final, injetando $GRAFANA_REMOTE_WRITE_PASSWORD
envsubst < /etc/prometheus/prometheus.yml.tpl > /etc/prometheus/prometheus.yml
# executa o Prometheus com todos os flags do CMD
exec /bin/prometheus "$@"
