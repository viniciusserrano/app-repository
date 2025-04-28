# ─── Etapa 1: Build com Maven ─────────────────────────────────────────
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

# 1) Copia o POM e o wrapper (se você usar mvnw) para cache de dependências
COPY pom.xml mvnw mvnw.cmd ./
COPY .mvn/ .mvn/

# 2) Baixa todas as dependências sem compilar
RUN chmod +x mvnw && \
    ./mvnw dependency:go-offline -B

# 3) Copia o restante do código e empacota sem testes
COPY src/ src/
RUN ./mvnw clean package -DskipTests

# ─── Etapa 2: Imagem final mais leve ───────────────────────────────────
FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

# Copia só o JAR gerado na stage "build"
COPY --from=build /app/target/api-imobiliaria-endereco-*.jar app.jar

# Expõe a porta que seu serviço usa
EXPOSE 8088

# Comando padrão para iniciar sua aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
