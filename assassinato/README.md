# ASSASSINATO

## COMO RODAR

### Sem debug

```./mvnw spring-boot:run```

Para sair pressione ```CTRL+C``` ou ```COMMAND+C```

### Com debug

```./mvnw clean package
java -jar target/assassinato-0.0.1-SNAPSHOT.jar -d```

Para sair pressione ```CTRL+C``` ou ```COMMAND+C```

## WISHLIST

* Refatorar o HypothesisUtils para uma classe enum com seus respectivos objetos.
* Melhorar o Banner
* Fazer uma versão WEB usando rest tipo: http://localhost/assasinato/{suspeito}/{arma}/{local}