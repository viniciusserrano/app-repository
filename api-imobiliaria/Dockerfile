# Etapa de build: utiliza openjdk:21-slim e instala o Maven
FROM openjdk:21-slim AS build

# Atualiza os pacotes e instala o Maven (a versão instalada pode não ser a mais nova,
# mas normalmente é suficiente para compilar seu projeto)
RUN apt-get update && apt-get install -y maven

WORKDIR /app

# Copia o arquivo de configuração do Maven e o código-fonte
COPY pom.xml .
COPY src ./src

# Compila a aplicação e gera o JAR
RUN mvn clean package -DskipTests

# Etapa de runtime: utiliza uma imagem mais leve do OpenJDK 21
FROM openjdk:21-slim
WORKDIR /app

# Copia o JAR gerado na etapa de build para o container.
# Certifique-se de que o nome "api-imobiliaria-0.0.1-SNAPSHOT.jar" corresponde ao gerado.
COPY --from=build /app/target/api-imobiliaria-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
