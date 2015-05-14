package com.weather

import grails.transaction.Transactional

@Transactional
class ReportService {

    def getMinMax( def jsonResponse,def date) {
        
       def arr =  jsonResponse.list
       //def minTemp = arr.get(0).main.temp_min
      // def maxTemp = arr.get(0).main.temp_max
       def newArr =[]
           
         if((dt.getDateString()).equals(new Date().getDateString())) {
        //sort this array based on temp.
       
       for(int i = 1 ; i <arr.size() ; i= i++){
         def dt = new Date((arr.get(i).dt)* 1000L)
           
        if((dt.getDateString()).equals(new Date().getDateString())) {
            
             def map = {}
              map["minTemp"]= arr.get(i).main.temp_min
              map["time"] = dt.getTimeString()
              newArr.add(map)
            
            }  
      
         }  
       }

        
    }
}
