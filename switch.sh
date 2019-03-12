#! /bin/bash

if [ -e build_1.xml ]
then
    echo "switching to project 1"
    mv build.xml build_2.xml
    mv build_1.xml build.xml
else
    echo "switching to project 2"
    mv build.xml build_1.xml
    mv build_2.xml build.xml
fi