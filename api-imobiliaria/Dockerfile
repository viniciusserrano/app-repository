# 📦 Etapa 1: Build com Maven
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

# Copia apenas o POM primeiro para aproveitar cache de dependências
COPY pom.xml .

# Baixa dependências sem compilar (melhora cache)
RUN mvn dependency:go-offline -B

# Agora copia o código-fonte
COPY src ./src

# Compila o projeto (sem testes)
RUN mvn clean package -DskipTests

# 🏃 Etapa 2: Imagem final mais leve
FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

# Copia apenas o JAR final da etapa anterior
COPY --from=build /app/target/api-imobiliaria-0.0.1-SNAPSHOT.jar app.jar

# Porta padrão
EXPOSE 8080

# Executa o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
