<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <g:javascript src="jquery-1.8.0.min.js"/>
    <script src="http://code.highcharts.com/highcharts.js"></script>
     <script src="http://code.highcharts.com/modules/exporting.js"></script>
     
     <script type="text/javascript">
     $(function () {
    $('#container').highcharts({
    
    yAxis: {
    title: {
        enabled: true,
        text: 'Hours of the Day'
    },
    type: 'datetime',

    dateTimeLabelFormats : {
        hour: '%I %p'
    }
   },
        title: {
            text: 'Weather report',
            x: -20 //center
        },
        subtitle: {
            text: 'Source: WorldClimate.com',
            x: -20
        },
        series: [{
            data :${lineChartData}
           
         }]
    });
});

           
</script>
    <title>Today's weather report</title>
  </head>
  <body>
    <h1>Today's weather report</h1>
    <div class="profile">
    <p>
        <span class="label">Date: </span>
        <span class="value">${currDate}</span>
    </p>
    <p>
        <span class="label">Minimum temperature :</span>
        <span class="value">${minTemp}</span>
    </p>
    <p>
        <span class="label"> Minimum temperature occurred at:</span>
        <span class="value">${minTempTime}</span>
    </p>
    <p>
        <span class="label">Maximum temperature :</span>
        <span class="value">${maxTemp}</span>
    </p>
    <p>
        <span class="label">Maximum temperature occurred at :</span>
        <span class="value">${maxTempTime}</span>
    </p>
</div>
    <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
  </body>
</html>


