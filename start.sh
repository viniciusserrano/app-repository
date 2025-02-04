#!/bin/bash
# Aborta o script caso algum comando retorne erro
set -e

echo "Encerrando os containers e removendo redes..."
docker-compose down

echo "Construindo a imagem do backend..."
docker-compose build

echo "Iniciando os containers em segundo plano..."
docker-compose up -d

echo "Ambiente iniciado com sucesso!"
