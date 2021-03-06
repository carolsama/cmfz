<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/9
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>统计图</title>



</head>
<body>
<script type="text/javascript">
    var chart = echarts.init(document.getElementById('statistics_china'),"vintage");

    function randomData() {
        return Math.round(Math.random()*1000);
    }

    option = {
        title:{
            text:'持名法州APP用户分布图',
            subtext:'2017年6月15日 最新数据',
            left:'center'

        },
        tooltip:{
            trigger:'item'
        },
        legend:{
            orient:'vertical',
            left:'left',
            data:['男','女']
        },
        visualMap:{
            min:0,
            max:2500,
            left:'left',
            top:'bottom',
            text:['高','低'],
            calculable:true
        },
        //工具箱
        toolbox:{
            show:true,
            orient:'vertical',
            left:'right',
            top:'center',
            feature:{
                dataView:{readOnly:false},
                restore:{},
                saveAsImage:{}
            }

        },
        series:[
            {
                name:'男',
                type:'map',
                mapType:'china',
                roam:false,
                label:{
                    normal:{
                        show:true
                    },
                    emphasis:{
                        show:true
                    }
                },
                data:[
                    {name: '北京',value: '100' },{name: '天津',value: randomData() },
                    {name: '上海',value: randomData() },{name: '重庆',value: randomData() },
                    {name: '河北',value: randomData() },{name: '河南',value: randomData() },
                    {name: '云南',value: randomData() },{name: '辽宁',value: randomData() },
                    {name: '黑龙江',value: randomData() },{name: '湖南',value: randomData() },
                    {name: '安徽',value: randomData() },{name: '山东',value: randomData() },
                    {name: '新疆',value: randomData() },{name: '江苏',value: randomData() },
                    {name: '浙江',value: randomData() },{name: '江西',value: randomData() },
                    {name: '湖北',value: randomData() },{name: '广西',value: randomData() },
                    {name: '甘肃',value: randomData() },{name: '山西',value: randomData() },
                    {name: '内蒙古',value: randomData() },{name: '陕西',value: randomData() },
                    {name: '吉林',value: randomData() },{name: '福建',value: randomData() },
                    {name: '贵州',value: randomData() },{name: '广东',value: randomData() },
                    {name: '青海',value: randomData() },{name: '西藏',value: randomData() },
                    {name: '四川',value: randomData() },{name: '宁夏',value: randomData() },
                    {name: '海南',value: randomData() },{name: '台湾',value: randomData() },
                    {name: '香港',value: randomData() },{name: '澳门',value: randomData() }
                ]
            },
            {
                name:'女',
                type:'map',
                mapType:'china',
                label:{
                    normal:{
                        show:true
                    },
                    emphasis:{
                        show:true
                    }
                },
                data:[
                    {name: '北京',value: '100' },{name: '天津',value: randomData() },
                    {name: '上海',value: randomData() },{name: '重庆',value: randomData() },
                    {name: '河北',value: randomData() },{name: '河南',value: randomData() },
                    {name: '云南',value: randomData() },{name: '辽宁',value: randomData() },
                    {name: '黑龙江',value: randomData() },{name: '湖南',value: randomData() },
                    {name: '安徽',value: randomData() },{name: '山东',value: randomData() },
                    {name: '新疆',value: randomData() },{name: '江苏',value: randomData() },
                    {name: '浙江',value: randomData() },{name: '江西',value: randomData() },
                    {name: '湖北',value: randomData() },{name: '广西',value: randomData() },
                    {name: '甘肃',value: randomData() },{name: '山西',value: randomData() },
                    {name: '内蒙古',value: randomData() },{name: '陕西',value: randomData() },
                    {name: '吉林',value: randomData() },{name: '福建',value: randomData() },
                    {name: '贵州',value: randomData() },{name: '广东',value: randomData() },
                    {name: '青海',value: randomData() },{name: '西藏',value: randomData() },
                    {name: '四川',value: randomData() },{name: '宁夏',value: randomData() },
                    {name: '海南',value: randomData() },{name: '台湾',value: randomData() },
                    {name: '香港',value: randomData() },{name: '澳门',value: randomData() }
                ]
            }
        ]
    };

    chart.setOption(option);
</script>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="statistics_china" style="width: 99%;height: 99%;margin-top: 2px;margin-left: 2px">

</div>

</body>
</html>
