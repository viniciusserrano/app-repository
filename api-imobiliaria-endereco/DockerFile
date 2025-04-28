# Imagem base do Java 17
FROM openjdk:17-jdk-slim

# Diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo .jar gerado pelo build
COPY target/api-imobiliaria-endereco-*.jar app.jar

# Expõe a porta 8088 (mesma definida no docker-compose.yml)
EXPOSE 8088

# Comando de inicialização do container
ENTRYPOINT ["java", "-jar", "app.jar"]
