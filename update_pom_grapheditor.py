#!bin/python
# -*- coding: utf-8 -*-

import os
import subprocess
import sys
import string
from datetime import *
import re


def git_commit(version):
    subprocess.call(["cmd", "/C git add -u"])
    subprocess.call(["cmd", "/C git commit -m '" + version + "'"])


def update_version_in_file(path, new_version):
    if os.name == 'nt':
        f = open(path, encoding='utf-8')
    else:
        f = open(path)
    arr = []
    for line in f.readlines():
        if line.__contains__("<grapheditor.project.version>") and line.__contains__("</grapheditor.project.version>"):
            arr.append("\t\t<grapheditor.project.version>" + new_version + "</grapheditor.project.version>\n")
        else:
            arr.append(line)
    f.close()

    f = open(path, "w", encoding='utf-8')
    for s in arr:
        f.write(s)
    f.close()


def get_current_version(path):
    if os.name == 'nt':
        f = open(path, encoding='utf-8')
    else:
        f = open(path)
    for line in f.readlines():
        if line.__contains__("<grapheditor.project.version>") and line.__contains__("</grapheditor.project.version>"):
            current_version = line[(line.find("<grapheditor.project.version>") + 29):line.find("</grapheditor.project.version>")]
            break
    f.close()
    return current_version


if __name__ == "__main__":
    if sys.argv.__len__() == 2:
        new_version = sys.argv[1]
    else:
        current_version = get_current_version(os.getcwd() + "/pom.xml")
        
        last_number = current_version[(current_version.rfind(".") + 1):(len(current_version))]
        new_last_number = int(last_number) + 1
        new_version = current_version[0:(current_version.rfind(".") + 1)] + str(new_last_number)
        
    print("New version: " + new_version)

    for subdir, dirs, files in os.walk(os.getcwd()):
        for file in files:
            if 'pom.xml' in file:
                update_version_in_file(subdir + '\\' + file, new_version)
                print('Update version in file: ' + subdir + '\\' + file)

    git_commit(current_version)
