#!/bin/bash
mvn package -DskipTests
java -cp ./target/kotlin_fuzzer-1.0-SNAPSHOT-jar-with-dependencies.jar ru.au.kotlinfuzzer.experiment.Minimize_verifiedKt
