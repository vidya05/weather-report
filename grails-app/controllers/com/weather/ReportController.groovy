package com.weather


import groovyx.net.http.HTTPBuilder
import groovyx.net.http.RESTClient

import groovyx.net.http.*
import static groovyx.net.http.ContentType.*
import static groovyx.net.http.Method.*
import  grails.converters.JSON
import org.codehaus.groovy.grails.web.json.JSONObject



class ReportController {

    def index() { }
       
    
    def getReport(){
        try{
            def http = new HTTPBuilder( 'http://api.openweathermap.org/data/2.5/forecast/city');
            http.request( GET, ContentType.JSON ) {
                uri.query = [ id:'1277333', APPID: '1111111111' ]
                response.success = { resp, jsonResponse ->
                    def resultList =  jsonResponse.list
                    def dataArray =[],entryDate
                    def currDate = new Date()
                    def map = [:]
                    def minTemp,maxTemp,minTempTime,maxTempTime
                    minTemp = resultList.get(0).main.temp_min
                    maxTemp = resultList.get(0).main.temp_max
                    minTempTime = maxTempTime = resultList.get(0).dt_txt.split(" ")[1]
       
                    for(def entry :resultList) {
                        entryDate = new Date((entry.dt)* 1000L)
           
                        if((currDate.getDateString()).equals(entryDate.getDateString())) {
                            map=  ['minTemp' :  entry.main.temp_min, 'time' :  entryDate.getTime()]
                            dataArray.add(map)
                
                            if( entry.main.temp_min < minTemp ){
                                minTemp = entry.main.temp_min
                                minTempTime = entryDate.getTimeString()
                            }
                            if(entry.main.temp_max>maxTemp){
                                maxTemp = entry.main.temp_max
                                maxTempTime = entryDate.getTimeString()
                            }
                        }
                        else if(currDate < entryDate ){
                            break
                        }
      
                    }
            
                    dataArray = dataArray.sort{it.minTemp}
         
                    def chartData =[]
                    for(def e : dataArray){
                        chartData.push([e.minTemp,e.time])
               
                    }
         
         
                    ["lineChartData": chartData , "currDate" : currDate.getDateString() , "minTemp": minTemp
                        ,"maxTemp": maxTemp,"minTempTime" : minTempTime ,"maxTempTime" :maxTempTime] 
                }
                response.failure = { resp ->
                    log.info "Unexpected error: "+ resp.status+"  " +resp.statusLine.reasonPhrase
                    render (view :"error.gsp", model : ["exception" : resp.statusLine.reasonPhrase])
                }
            }
       
        } catch(Exception e){
            log.info("Error ------->"+e.getMessage())
            render (view :"error.gsp", model : ["exception" : e.getMessage()])
        }
        
    }
}

