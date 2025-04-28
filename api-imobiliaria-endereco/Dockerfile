# ─── Etapa 1: Build com Maven ─────────────────────────────────────────
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

# 1) Copia o pom e o wrapper para cache
COPY pom.xml mvnw mvnw.cmd ./
COPY .mvn/ .mvn/

# 2) Baixa dependências sem compilar
RUN chmod +x mvnw && ./mvnw dependency:go-offline -B

# 3) Copia o código e empacota
COPY src/ src/
RUN ./mvnw clean package -DskipTests

# ─── Etapa 2: Runtime enxuto ───────────────────────────────────────────
FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

# 4) Traz só o JAR do build anterior
COPY --from=build /app/target/api-imobiliaria-endereco-*.jar app.jar

# 5) Expõe a porta correta
EXPOSE 8088

# 6) Inicializa sua aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
