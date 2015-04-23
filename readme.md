#Java Agent
autor: Jakub Karolczak

Agent "wstrzykuj�cy" operacje mierzenia czasu wykonywania operacji Thread.sleep() na serwerze.

##Przygotowanie projektu

Do poprawnego podpi�cia agenta pod serwer jetty potrzebne jest wcze�niejsze ustawienie zmiennej systemowej MAVEN_OPTS prowadz�cej do agenta, np:

```
set MAVEN_OPTS=-javaagent:D:\myagent.jar
```

Teraz agent powinien uruchamia� si� przed ka�dym wywo�aniem komendy

```
mvn jetty:run
```