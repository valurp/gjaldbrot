const cat ={
  matur: {
    color:'rgba(250,50,0,0.8)',
    label: 'Matur',
    value: [1500,1000,900,1000,800],
    visible: true,
    index: 0
  },
  fatnadur: {
    color:'rgba(24,128,68,0.8)',
    label: 'Fatnaður',
    value: [1600,1600,1600,1600,1700],
    visible: true,
    index: 1
  },
  afengi: {
    color:'rgba(209,131,192,0.8)',
    label: 'Áfengi',
    value: [1400,500,1900,100,8000],
    visible: true,
    index: 2
  },
  tobak: {
    color:'rgba(52,236,254,0.8)',
    label: 'Tóbak',
    value: [1800,6000,5500,1000,850],
    visible: true,
    index: 3
  },
  skemmtun: {
    color:'rgba(238,233,52,0.8)',
    label: 'Skemmtun',
    value: [2500, 3000, 3500, 4000, 4500],
    visible: true,
    index: 4
  },
  veitingar: {
    color:
    'rgba(255,51,30,0.8)',
    label: 'Veitingar',
    value: [100, 300, 900, 500, 400],
    visible: true,
    index: 5
  }
};


function getData() {
  return {
    labels: ['Jan', 'Feb', 'Mars', 'Apr', 'Maí'],
    datasets: [
      {
        label: cat.matur.label,
        backgroundColor: cat.matur.color,
        borderColor: cat.matur.color,
        borderWidth: 3,
        data: cat.matur.value,
        fill: false,
      },
      {
        label: cat.fatnadur.label,
        backgroundColor: cat.fatnadur.color,
        borderColor: cat.fatnadur.color,
        borderWidth: 3,
        data: cat.fatnadur.value,
        fill: false,
      },
      {
        label: cat.afengi.label,
        backgroundColor: cat.afengi.color,
        borderColor: cat.afengi.color,
        borderWidth: 3,
        data: cat.afengi.value,
        fill: false,
      },
      {
        label: cat.tobak.label,
        backgroundColor: cat.tobak.color,
        borderColor: cat.tobak.color,
        borderWidth: 3,
        data: cat.tobak.value,
        fill: false,
      },
      {
        label: cat.skemmtun.label,
        backgroundColor: cat.skemmtun.color,
        borderColor: cat.skemmtun.color,
        borderWidth: 3,
        data: cat.skemmtun.value,
        fill: false,
      },
      {
        label: cat.veitingar.label,
        backgroundColor: cat.veitingar.color,
        borderColor: cat.veitingar.color,
        borderWidth: 3,
        data: cat.veitingar.value,
        fill: false,
      }],
  };
}



document.addEventListener('DOMContentLoaded', () => {
  let dataObject = getData();
  let ctx = document.getElementById('myChart').getContext('2d');
  window.myBar = new Chart(ctx, {
    type: 'line',
    data: getData(),
    options: {
      responsive: true,
      legend: {
        position: 'right',
        labels: {
          boxWidth: 16,
          fontSize: 16
        },
      },
      scales: {
        yAxes: [{
          ticks: {
            beginAtZero: true,
          }
        }]
      },
      title: {
        display: true,
        text: 'Yfirlit',
      }
    }
  });
});
