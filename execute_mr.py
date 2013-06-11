import sys
import re
import os
import thread
import datetime
from datetime import date
import subprocess
import StringIO
from optparse import OptionParser
import time

parser = OptionParser()

runDir = os.path.dirname(os.path.abspath(__file__))
binDir = "%s/build/" % runDir

cloud_inputdir = "zhoujie/input/wordcount/mutil_input_1,zhoujie/input/wordcount1/b"
cloud_output_basedir = "zhoujie/output"

ruleClassNameMap = {"ip_cookie_channel" : "com.allyes.frauddetection.SSPIPCookieTimeintervalChannel",
                    "periodicclick" : "com.allyes.frauddetection.SSPPeriodicClick",
                    "wordcount" : "com.zhoujie.test.WordCount",
                    "multioutput_text" : "com.zhoujie.test.TextMutiMapTest",
                    "multioutput_pb" : "com.zhoujie.test.LzoPBMutiMapTest"
                    }





def exec_cmd(cmd):
    print 'executing: ' + cmd
    p = subprocess.Popen(cmd,stdin = subprocess.PIPE,
                         stdout = subprocess.PIPE,
                         stderr = subprocess.STDOUT,
                         shell = True)

    log = p.communicate()[0]
    return p.returncode, log

def exec_cmds(cmds):
    for cmd in cmds:
        exec_cmd(cmd)

def abort(msg):
     print msg
     sys.exit(1) 

def getClassName(rulename):
    return ruleClassNameMap[rulename]

def execute_mr(db, rulename):
    cloud_outputdir = "%s/%s/%s" % (cloud_output_basedir, db, rulename)
    cmd = "hadoop fs -rmr %s" % cloud_outputdir
    returncode, log = exec_cmd(cmd)
    print log
    cmd = "hadoop jar " + binDir + "fraud_detection.jar " + " " + getClassName(rulename) + " " + "-D mapred.reduce.tasks=10" + " " + cloud_inputdir + " " + cloud_outputdir
    returncode, log = exec_cmd(cmd)
    print log

def execute_regular_job(jobname):
    cloud_outputdir = "%s/%s" % (cloud_output_basedir, jobname)
    cmd = "hadoop fs -rmr %s" % cloud_outputdir
    returncode, log = exec_cmd(cmd)
    print log
    cmd = "hadoop jar " + binDir + "wordcount.jar " + " " + getClassName(jobname) + " " + "-D mapred.reduce.tasks=10" + " " + "--input=" + cloud_inputdir + " " + "--output=" + cloud_outputdir + " " + "--hdfsHost=sm98:9000" + " " + "--jobTrackerHost=sm99:9001"
    returncode, log = exec_cmd(cmd)
    print log

def execute_input_output_job(jobname):
    cloud_outputdir = "%s/%s" % (cloud_output_basedir, jobname)
    cmd = "hadoop fs -rmr %s" % cloud_outputdir
    returncode, log = exec_cmd(cmd)
    print log
    cmd = "hadoop jar " + binDir + "wordcount.jar " + " " + getClassName(jobname) + " " + "-D mapred.reduce.tasks=10" + " " + cloud_inputdir + " " + cloud_outputdir 
    returncode, log = exec_cmd(cmd)
    print log

def main():
    #execute_mr('ssp', 'ip_cookie_channel')
    #execute_mr('ssp', 'periodicclick')
    #execute_regular_job('wordcount')
    #execute_input_output_job('multioutput')
    execute_input_output_job('multioutput_pb')
    

if __name__ == '__main__':
    main()
