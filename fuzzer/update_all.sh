#!/bin/bash
mvn package -DskipTests
cd ./fuzzing_output
./copy_from_remote.sh
cd -
time java -cp ./target/kotlin_fuzzer-1.0-SNAPSHOT-jar-with-dependencies.jar ru.au.kotlinfuzzer.fuzzing.Filter_duplicate_crashingKt
time java -cp ./target/kotlin_fuzzer-1.0-SNAPSHOT-jar-with-dependencies.jar ru.au.kotlinfuzzer.experiment.Get_exc_root_causesKt
time java -cp ./target/kotlin_fuzzer-1.0-SNAPSHOT-jar-with-dependencies.jar ru.au.kotlinfuzzer.experiment.Group_files_by_root_causesKt | tee ./logs/current_grouping.txt
