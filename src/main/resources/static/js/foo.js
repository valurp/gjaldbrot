const cat ={
  matur: {
    color:'rgba(250,50,0,0.8)',
    label: 'Matur',
    value: 1500,
    visible: true,
    index: 0
  },
  fatnadur: {
    color:'rgba(24,128,68,0.8)',
    label: 'Fatnaður',
    value: 1500,
    visible: true,
    index: 1
  },
  afengi: {
    color:'rgba(209,131,192,0.8)',
    label: 'Áfengi',
    value: 1500,
    visible: true,
    index: 2
  },
  tobak: {
    color:'rgba(52,236,254,0.8)',
    label: 'Tóbak',
    value: 1500,
    visible: true,
    index: 3
  },
  skemmtun: {
    color:'rgba(238,233,52,0.8)',
    label: 'Skemmtun',
    value: 1500,
    visible: true,
    index: 4
  },
  veitingar: {
    color:
    'rgba(255,51,30,0.8)',
    label: 'Veitingar',
    value: 1500,
    visible: true,
    index: 5
  }
};

function getInputIndex(name) {
  let index = 0;
  //matur kemur alltaf fyrstur
  if (cat[name].index == 0){ return index; }
  index += (cat.matur.visible ? 1 : 0);
  //fatnaður
  if (cat[name].index == 1){ return index; }
  index += (cat.fatnadur.visible ? 1 : 0);
  //afengi
  if (cat[name].index == 2){ return index; }
  index += (cat.afengi.visible ? 1 : 0);
  //tóbak
  if (cat[name].index == 3){ return index; }
  index += (cat.tobak.visible ? 1 : 0);
  //skemmtun
  if (cat[name].index == 4){ return index; }
  index += (cat.fatnadur.visible ? 1 : 0);
  //veitingar
  return index;
}


function changeGraph(checkbox) {
  let category = checkbox.name;
  // true: sýna, false: fela
  let op = checkbox.checked;
  let myBar = window.myBar;
  // sýna
  if (op) {
    let index = getInputIndex(category);
    myBar.data.labels.splice(index, 0, cat[category].label);
    myBar.data.datasets[0].data.splice(index, 0, cat[category].value);
    myBar.data.datasets[0].backgroundColor.splice(index, 0, cat[category].color);
    myBar.update(0);
    cat[category].visible = true;
  }
  else {//fela
    let index = cat[category].index;
    myBar.data.labels.splice(index, 1);
    myBar.data.datasets[0].data.splice(index, 1);
    myBar.data.datasets[0].backgroundColor.splice(index, 1);
    myBar.update();
    cat[category].visible = false;
  }
}


function getData() {
  return {
    labels: [cat.matur.label, cat.fatnadur.label, cat.afengi.label, cat.tobak.label, cat.skemmtun.label, cat.veitingar.label],
    datasets: [
      {
        label: 'Útgjöld',
        backgroundColor: [cat.matur.color, cat.fatnadur.color, cat.afengi.color, cat.tobak.color, cat.skemmtun.color, cat.veitingar.color],
        borderColor: 'rgba(0, 0, 0, 1)',
        borderWidth: 1,
        data: [1000, 1000, 1500, 1500, 1110, 1000],
      }]
  };
}

document.addEventListener('DOMContentLoaded', () => {
  let dataObject = getData();
  let ctx = document.getElementById('myChart').getContext('2d');
  window.myBar = new Chart(ctx, {
    type: 'bar',
    data: getData(),
    options: {
      responsive: true,
      legend: {
        display: false
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
