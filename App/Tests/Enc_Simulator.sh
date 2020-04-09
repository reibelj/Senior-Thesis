#!/bin/bash

# AES Testing Script

echo Testing encryption with AES
start=`date +%s%N`

cd ..
cd DPE/AES/
javac AES_Enc.java
java AES_Enc
end=`date +%s%N`

echo Execution time was `expr $end - $start` nanoseconds.
echo Finshed AES encryption testing

echo Testing decryption with AES
start=`date +%s%N`

javac AES_DEC.java
java AES_Dec
end=`date +%s%N`

echo Execution time was `expr $end - $start` nanoseconds.
echo Finshed AES decryption testing

# Blowfish Testing Script

echo Testing encryption with Blowfish
start=`date +%s%N`

cd src/Blowfish/
javac Blowfish_Enc.java
java Blowfish_Enc
end=`date +%s%N`

echo Execution time was `expr $end - $start` nanoseconds.
echo Finshed Blowfish encryption testing

echo Testing decryption with Blowfish
start=`date +%s%N`

javac Blowfish_Dec.java
java Blowfish_Dec
end=`date +%s%N`

echo Execution time was `expr $end - $start` nanoseconds.
echo Finshed Blowfish decryption testing

# Caesar Cipher Testing Script

echo Testing encryption with Caesar
start=`date +%s%N`

cd src/Caesar/
javac Caesar_Enc.java
java Caesar_Enc
end=`date +%s%N`

echo Execution time was `expr $end - $start` nanoseconds.
echo Finished Caesar encryption testing

echo Testing decryption with Caesar
start=`date +%s%N`

javac Caesar_Dec.java
java Caesar_Dec
end=`date +%s%N`

echo Execution time was `expr $end - $start` nanoseconds.
echo Finished Caesar decryption testing

# MDS Testing Script
echo Testing encryption with MD5
start=`date +%s%N`

cd src/MD5/
javac MD5.java
java MD5
end=`date +%s%N`

echo Execution time was `expr $end - $start` nanoseconds.
echo Finshed MD5 encryption testing
