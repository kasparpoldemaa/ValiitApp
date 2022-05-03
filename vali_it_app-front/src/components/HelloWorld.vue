<template>

  <div class="hello">
    <h1>{{ msg }}</h1>
    <br>
    <p>
      Siin kodulehel on võimalik viia kokku IT-ettevõtted ja Vali-IT ümberõppe programmis osalevad õppurid.
      Kui sa oled ettevõtja siis saad:
      *Tutvuda uusima Vali-IT lennu õpilastega ja vaadata nende profiile.
      *Saad lisada praktikavõimalusi enda ettevõttes.
      *Saad lisada kalendrisse kohtumisi kogu lennuga klassiruumis või veebi vahendusel.
      *Saad kuvada ainult praktikakohta otsivaid õpilasi.

      Kui sa oled üpilane siis saad:
      *Lisada enda  profiilile uusima informatsiooni.
      *Kandideerida praktikakohtadele, mis ettevõtted on lisanud.
      *Vaadata eelolevate sündmuste kalendrit.
      *Märkida, kas oled praktikakoha juba leidnud või oled veel otsimas.

    </p>
    <p>
      „Vali IT!“ on täiskasvanute ümberõppeprogramm, mille eesmärgiks on anda osalejatele tarkvaraarendaja algoskused. Programmis osalejad läbivad 6-nädalase täismahus õppe (5 päeva nädalas, kuni 8 tundi päevas). Sellele järgneb 8-nädalane (40 tööpäeva, kuni 8 tundi päevas) praktika ettevõtetes.
      Kandideerimine on avatud pidevalt. Andke teada oma huvist ja täitke kandideerimisankeet!

    </p>
    <h3>BCS koolituse koduleht</h3>
    <ul>
      <li><a href="https://www.bcskoolitus.ee/" target="_blank" rel="noopener">Vajuta siia</a></li>
    </ul>
    <h3>Vali-IT koduleht</h3>
    <ul>
      <li><a href="http://vali-it.ee/" target="_blank" rel="noopener">Vajuta siia</a></li>
    </ul>


  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
