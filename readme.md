#Java Agent
autor: Jakub Karolczak

Agent "wstrzykuj¹cy" operacje mierzenia czasu wykonywania operacji Thread.sleep() na serwerze.

##Przygotowanie projektu

Do poprawnego podpiêcia agenta pod serwer jetty potrzebne jest wczeœniejsze ustawienie zmiennej systemowej MAVEN_OPTS prowadz¹cej do agenta, np:

```
set MAVEN_OPTS=-javaagent:D:\myagent.jar
```

Teraz agent powinien uruchamiaæ siê przed ka¿dym wywo³aniem komendy

```
mvn jetty:run
```