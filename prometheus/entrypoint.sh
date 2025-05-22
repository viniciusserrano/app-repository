#!/usr/bin/env sh
# gera o prometheus.yml em runtime, com a senha disponível
envsubst < /etc/prometheus/prometheus.yml.tpl > /etc/prometheus/prometheus.yml
# executa o Prometheus
exec /bin/prometheus "$@"
