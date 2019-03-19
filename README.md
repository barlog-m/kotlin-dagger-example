Kotlin + Dagger 2 minimal example
=====================

[Dagger 2](https://google.github.io/dagger)
[kapt](https://kotlinlang.org/docs/reference/kapt.html)

### Generate dagger classes
```
gradle kaptKotlin
```

### Run
```
gradle run
```

### Create executable jar with dependencies
```
gradle clean shadowJar
```
