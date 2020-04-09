#!/bin/bash
echo "welcome message"
echo "Do you wish to utilize (Dropbox) or (GoogleDrive) for your storage?"
read platform

if [[ $platform -eq "Dropbox" ]]; then

# specify user intentions for Dropbox platform
echo "Are you (uploading) or (downloading) a file?"
read intentions

if [[ $intentions -eq "uploading" ]]; then

echo "Listing all available files for uploading:"
# list files within input directory

# ask users if they want file encrypted
echo "Do you want to encrypt the file before uploading?"
read enc

if [[ $enc -eq "Yes" ]]; then

cd DPE/
javac AES_Encrypt.java
java AES_Encrypt

cd ..
cd Dropbox/Upload/src/
javac -d ../classes/ -cp .:/home/jon/Desktop/cs600-610/Senior-Thesis/App/Dropbox/Upload/jar/* *.java
cd ../classes
java -cp .:/home/jon/Desktop/cs600-610/Senior-Thesis/App/Dropbox/Upload/jar/* DropboxDriver KJgT6FOvpzAAAAAAAAAAc4AjTOsEeDZwFBt6hrMNO-6kXm6B3wN4lxtAUXp-uCa6
echo "Process complete"

elif [[ $enc -eq "No" ]]; then

cd Dropbox/Upload/src/
javac -d ../classes/ -cp .:/home/jon/Desktop/cs600-610/Senior-Thesis/App/Dropbox/Upload/jar/* *.java
cd ../classes
java -cp .:/home/jon/Desktop/cs600-610/Senior-Thesis/App/Dropbox/Upload/jar/* DropboxDriver KJgT6FOvpzAAAAAAAAAAc4AjTOsEeDZwFBt6hrMNO-6kXm6B3wN4lxtAUXp-uCa6
echo "Process complete"

elif [[ $intentions -eq "downloading" ]]; then

cd Dropbox/Download/src/
javac -d ../../../Output/ -cp .:/home/jon/Desktop/cs600-610/Senior-Thesis/App/Dropbox/Download/jar/* *.java
cd ../../../Output/
java -cp .:/home/jon/Desktop/cs600-610/Senior-Thesis/App/Dropbox/Download/jar/* DropboxDriver KJgT6FOvpzAAAAAAAAAAc4AjTOsEeDZwFBt6hrMNO-6kXm6B3wN4lxtAUXp-uCa6
echo "Process complete"



fi
fi
fi
