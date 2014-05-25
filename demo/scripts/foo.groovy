@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7.1' )

import groovyx.net.http.HTTPBuilder
import groovyx.net.http.HttpResponseException
import static groovyx.net.http.ContentType.*
import java.util.Random

class DemoCaller {
    
    def random = new Random()

    def makeRandomCall(def apiVersion, def limit){
        try {
        def http = new HTTPBuilder('http://localhost:8080/')
        http.handler.'404' = { println "API Not Deployed"}
        http.handler.'400' = { println "To High"}
        http.get( path : "/services/${apiVersion}/fizzbuzz/${limit}", contentType : JSON ) {
            resp, reader ->
            println "/services/${apiVersion}/fizzbuzz/${limit} --> response status: ${resp.statusLine}"
        }
        } catch (HttpResponseException ex){
            println "Unexpected response error: ${ex.statusCode}"
        }
    }

    def getApiVersion(){
        this.random.nextInt(4)+1
    }

    def getLimit(){
        random.nextInt(11000)
    }
    def getSleeptime(){
        random.nextInt(1000)+1
    }

    def makeSomeTraffic(){
        while(true){
            makeRandomCall(apiVersion, limit)
            sleep(sleeptime)
        }
    }
}

def caller = new DemoCaller()
caller.makeSomeTraffic()
