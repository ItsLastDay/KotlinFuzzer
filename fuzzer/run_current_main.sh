#!/bin/bash
mvn package -DskipTests
while true
do
timeout -k 2h 2h ./subrun.sh
done


