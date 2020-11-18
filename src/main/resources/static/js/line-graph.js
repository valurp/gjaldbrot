// Static upplýsingar um graf
const cat = {
  matur: {
    color:'rgba(250,50,0,0.8)',
    label: 'Matur',
  },
  fatnadur: {
    color:'rgba(24,128,68,0.8)',
    label: 'Fatnaður',
  },
  afengi: {
    color:'rgba(209,131,192,0.8)',
    label: 'Áfengi',
  },
  tobak: {
    color:'rgba(52,236,254,0.8)',
    label: 'Tóbak',
  },
  skemmtun: {
    color:'rgba(238,233,52,0.8)',
    label: 'Skemmtun',
  },
  veitingar: {
    color: 'rgba(255,51,30,0.8)',
    label: 'Veitingar',
  }
};

// object sem er fyllt af data-attribute úr html
const values = {
  start: "",
  end: "",
  matur: [],
  fatnadur: [],
  afengi: [],
  tobak: [],
  skemmtun: [],
  veitingar: []
}

// Month manipulating helper functions

/*
* Bætir við mánuðum við dagsetninguna date
* @param date dagsetning á forminu yyyy-MM
* @param diff heiltala sem táknar fjölda mánaða sem á að bæta við
*
* returns Streng á forminu yyyy-MM sem er diff-mánuðum á eftir date.
*/
function addMonth(date, diff) {
    let month = Number(date[5]+date[6]);
    let year = Number(date[0]+date[1]+date[2]+date[3]);
    month += diff;

    if (month > 12) {
        month = month%12;
        year += 1;
    }
    if (month < 10) { //tryggir að formið verði yyyy-MM
        month = "0"+month;
    }
    return year+"-"+month;
}

/*
* Dregur mánuði frá dagsetningu
* @param date dagsetning á forminu yyyy-MM
* @param diff heiltala sem táknar fjölda mánaða sem á að draga frá
*
* returns Streng á forminu yyyy-MM sem er diff-mánuðum á undan date
*/
function subMonth(date, diff) {
    let month = Number(date[5]+date[6]);
    let year = Number(date[0]+date[1]+date[2]+date[3]);
    month -= diff;

    if (month <= 0) {
        month = (12 + month) % 12;
        year -= 1;
    }
    if (month < 10) { //tryggir að formið verði yyyy-MM
        month = "0"+month;
    }
    return year+"-"+month;
}

/*
* Reiknar mismun á tveimur dagsetningum í mánuðum
*
* @param a Dagsetning á forminu yyyy-MM
* @param b Dagsetning á forminu yyyy-MM
* Gerir ráð fyrir að a < b
* returns b - a
*/
function diff(a, b) {
  let year_a = Number(a[0]+a[1]+a[2]+a[3]);
  let year_b = Number(b[0]+b[1]+b[2]+b[3]);

  let month_a = Number(a[5]+a[6]);
  let month_b = Number(b[5]+b[6]);

  return 12*(year_b-year_a) - (month_a-month_b);
}

/*
* Hjálparfall sem að býr til lista af þeim mánuðum sem á eiga að vera
* á línugrafinu.
* Bætir við values.labels = [...]
*/
function generateLabels() {
    const monthNames = ["Jan", "Feb", "Mars", "Apr", "Maí", "Jún", "Júl", "Ágú", "Sept", "Okt", "Nóv", "Des"];
    let labels = [];
    let curr = values.start;
    let month = 0;
    while (curr !== values.end){
        month = Number(curr[5]+curr[6]);
        if(month === 1){
            labels.push(monthNames[0]+"-"+curr[0]+curr[1]+curr[2]+curr[3]);
        }
        else{
            labels.push(monthNames[month-1]);
        }
        curr = addMonth(curr, 1);
    }
    labels.push(monthNames[Number(curr[5]+curr[6])-1]);
    values.labels = labels;
}

/*
* Breytir x-ás línugrafsins þannig að hann sé [a; b]
*/
function setGraphAxis(a, b) {
  let myLine = window.myLine;
  let labels = [];
  values.labels.forEach(d => {
    labels.push(d);
  });
  labels.splice(0, a);
  labels.splice(b-a+1, 100);
  myLine.data.labels = labels;

  let matur = [];
  values.matur.forEach(d => {
    matur.push(d);
  });
  matur.splice(0,a);
  matur.splice(b-a+1,100);
  myLine.data.datasets[0].data = matur;

  let fatnadur = [];
  values.fatnadur.forEach(d => {
    fatnadur.push(d);
  });
  fatnadur.splice(0,a);
  fatnadur.splice(b-a+1,100);
  myLine.data.datasets[1].data = fatnadur;

  let afengi = [];
  values.afengi.forEach(d => {
    afengi.push(d);
  });
  afengi.splice(0,a);
  afengi.splice(b-a+1,100);
  myLine.data.datasets[2].data = afengi;

  let tobak = [];
  values.tobak.forEach(d => {
    tobak.push(d);
  });
  tobak.splice(0,a);
  tobak.splice(b-a+1,100);
  myLine.data.datasets[3].data = tobak;

  let skemmtun = [];
  values.skemmtun.forEach(d => {
    skemmtun.push(d);
  });
  skemmtun.splice(0,a);
  skemmtun.splice(b-a+1,100);
  myLine.data.datasets[4].data = skemmtun;

  let veitingar = [];
  values.veitingar.forEach(d => {
    veitingar.push(d);
  });
  veitingar.splice(0,a);
  veitingar.splice(b-a+1,100);
  myLine.data.datasets[5].data = veitingar;

  myLine.update();
}


/*
* Setur skorður á mánaðar veljarann svo að bara sé hægt að velja mánuði þar
* sem gögn eru til staðar.
* Setur atburðarHlustun á mánaðar veljarana sem tryggja að from<to og uppfæra
* línugrafið.
*/
function setUpDates() {
  const from = document.getElementById('from')
  const to = document.getElementById('to');

  //initialize to and from with values
  from.setAttribute('min', values.start);
  from.setAttribute('max', subMonth(values.end, 1));
  to.setAttribute('max', values.end);
  to.setAttribute('min', addMonth(values.start, 1))
  from.setAttribute('value', values.start);
  to.setAttribute('value', values.end);

  from.addEventListener('change', () => {
    if (to.value == "" || to.value <= from.value){
      to.value = addMonth(from.value, 1);
    }
    setGraphAxis(diff(values.start, from.value), diff(values.start, to.value));
  });

  to.addEventListener('change', () => {
    if(from.value == "" || from.value >= to.value){
      from.value = subMonth(to.value, 1);
    }
    setGraphAxis(diff(values.start, from.value), diff(values.start, to.value));
  });
}

/*
* Býr til data object fyrir línugrafið.
* ATH: Það má bara kalla einu sinni í þetta fall í hverjum glugga.
*/
function getData() {
  let data = JSON.parse(document.getElementById('receive_data').getAttribute('data-receipts'));
  values.matur = data.matur;
  values.fatnadur = data.fatnadur;
  values.afengi = data.afengi;
  values.tobak = data.tobak;
  values.skemmtun = data.skemmtun;
  values.veitingar = data.veitingar;
  values.start = data.start;
  values.end = data.end;

  generateLabels();
  return {
    labels: values.labels,
    datasets: [
      {
        label: cat.matur.label,
        backgroundColor: cat.matur.color,
        borderColor: cat.matur.color,
        borderWidth: 3,
        data: values.matur,
        fill: false,
      },
      {
        label: cat.fatnadur.label,
        backgroundColor: cat.fatnadur.color,
        borderColor: cat.fatnadur.color,
        borderWidth: 3,
        data: values.fatnadur,
        fill: false,
      },
      {
        label: cat.afengi.label,
        backgroundColor: cat.afengi.color,
        borderColor: cat.afengi.color,
        borderWidth: 3,
        data: values.afengi,
        fill: false,
      },
      {
        label: cat.tobak.label,
        backgroundColor: cat.tobak.color,
        borderColor: cat.tobak.color,
        borderWidth: 3,
        data: values.tobak,
        fill: false,
      },
      {
        label: cat.skemmtun.label,
        backgroundColor: cat.skemmtun.color,
        borderColor: cat.skemmtun.color,
        borderWidth: 3,
        data: values.skemmtun,
        fill: false,
      },
      {
        label: cat.veitingar.label,
        backgroundColor: cat.veitingar.color,
        borderColor: cat.veitingar.color,
        borderWidth: 3,
        data: values.veitingar,
        fill: false,
      }],
  };
}

document.addEventListener('DOMContentLoaded', () => {
  let dataObject = getData();
  setUpDates();
  let ctx = document.getElementById('myChart').getContext('2d');
  window.myLine = new Chart(ctx, {
    type: 'line',
    data: dataObject,
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
