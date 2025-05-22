#!/usr/bin/env sh
# Gera o arquivo de config final, injetando a senha via envsubst
envsubst < /etc/prometheus/prometheus.yml.tpl > /etc/prometheus/prometheus.yml
# Executa o Prometheus com todos os argumentos da linha de comando
exec /bin/prometheus "$@"
