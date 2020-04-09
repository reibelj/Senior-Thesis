#!/bin/bash

# Dropbox Testing

echo Testing Dropbox Upload
start=`date +%s%N`

cd src/Blowfish/
javac Blowfish_Enc.java
java Blowfish_Enc
end=`date +%s%N`

echo Execution time was `expr $end - $start` nanoseconds.
echo Finshed Testing Dropbox Upload

echo Testing Dropbox Download
start=`date +%s%N`

cd src/Blowfish/
javac Blowfish_Enc.java
java Blowfish_Enc
end=`date +%s%N`

echo Execution time was `expr $end - $start` nanoseconds.
echo Finshed Testing Dropbox Download

# Google Drive Testing

echo Testing Google Drive Upload
start=`date +%s%N`

cd src/Blowfish/
javac Blowfish_Enc.java
java Blowfish_Enc
end=`date +%s%N`

echo Execution time was `expr $end - $start` nanoseconds.
echo Finshed Testing Google Drive Upload

echo Testing Google Drive Download
start=`date +%s%N`

cd src/Blowfish/
javac Blowfish_Enc.java
java Blowfish_Enc
end=`date +%s%N`

echo Execution time was `expr $end - $start` nanoseconds.
echo Finshed Testing Dropbox Upload
