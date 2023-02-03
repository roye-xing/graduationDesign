var cxt=document.getElementById('canvas').getContext("2d")
var evaluateChart=new Chart(cxt,{
    type:"bar",
    data:{
        labels:['自我','HR','领导'],
        datasets:[
            {
                label:"总体评分表",
                backgroundColor:[
                   'rgba(54,162,235,0.2)',
                   'rgba(255,206,86,0.2)',
                   'rgba(255,86,252,0.2)'
                ],
                borderColor:[
                    'rgba(54,162,235,1)',
                    'rgba(255,206,86,1)',
                    'rgba(255,86,252,1)'
                ],
                borderWidth:1,
                data: [selfscore,hrscore,oldscore],
            }
        ]
    },
    options:{
        scales:{
            yAxes:[{
                ticks:{
                    beginAtZero:true
                }
            }]
        }
    }
});