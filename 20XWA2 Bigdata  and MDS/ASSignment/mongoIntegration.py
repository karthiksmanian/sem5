# -*- coding: utf-8 -*-
"""
Created on Wed Sep  7 11:52:07 2022

@author: 20pw16
"""
from pymongo import MongoClient
client = MongoClient("mongodb+srv://karthikmsd:26032002@cluster0.bvjf8zm.mongodb.net/?retryWrites=true&w=majority")

# db = client.test
mongoClient = MongoClient()

mydb = client["mydatabase"]
mycol = mydb["customers"]


import csv

header = ['country','capital','type']

file = open('Z:/SEM 5/20XWA2 Bigdata  and MDS/ASSignment/country-list.csv')

reader = csv.DictReader(file) 

for each in reader:
    row = {}
    for field in header:
        row[field] = each[field]
        
    print(row)
    mycol.insert_one(row)