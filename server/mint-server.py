#!flask/bin/python
from datetime import datetime, timedelta
from flask import Flask, jsonify, abort, make_response, request
from time import sleep
import httplib2
import json
import pymysql
import sys

app = Flask(__name__)

class DateTimeEncoder(json.JSONEncoder):
    def default(self, obj):
        if isinstance(obj, datetime):
            encoded_object = list(obj.timetuple())[0:6]
        else:
            encoded_object =json.JSONEncoder.default(self, obj)
        return encoded_object

@app.route('/')
def index():
    return "Welcome to Job Mint Service!"

@app.route('/login', methods=['GET','POST'])
def login():
    return make_response(jsonify({"login":"success"}), 200)

@app.route('/get_jobs', methods=['GET'])
def get_jobs(ticket_id):

    #Fetch from DB eventually
    #Mock-It
    jobs = { "E-kart":['8-hrs', '4-hrs', 'Single Delivery'],
                "Fancy Kitchen": ['8-hrs Helper', 'Single Food Delivery']
            }
    return make_response(jobs, 200)

if __name__ == '__main__':
    app.debug = True
    app.run(host='0.0.0.0',threaded=True)
