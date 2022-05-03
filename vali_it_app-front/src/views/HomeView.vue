<template>
  <div>

    <div class="logo">
      <img alt="BCS logo" src="../assets/Vali_IT_logo.png">
    </div>
    <br>

    <div class="introduction">

      <h2> Siin kodulehel on võimalik kokku viia IT-ettevõtted ja Vali-IT ümberõppe programmis osalevad õppurid.</h2>

    </div>

    <div>

      <div class="companyandstudent">
        <div class="card" id="student" >
          <img src="../assets/IT-companyold.jpg" class="card-img-top" alt="Student picture">
          <div class="card-body">
            <h5 class="card-title">Õpilane saab:</h5>
            <p class="card-text">
            <h5>
            <li>lisada enda profiilile uusima informatsiooni.</li>
            <li>kandideerida praktikakohtadele, mis ettevõtted on lisanud.</li>
            <li>vaadata eelolevate sündmuste kalendrit.</li>
            <li>märkida, kas oled praktikakoha juba leidnud või oled veel otsimas ja avatud pakkumistele.</li> </h5>
          </div>
        </div>

        <div>
          <div class="card" id="company" >
            <img src="../assets/IT-companyold.jpg" class="card-img-top" alt="Company picture">
            <div class="card-body">
              <h5 class="card-title">Ettevõte saab:</h5>
              <p class="card-text">
              <h5>
              <li>tutvuda viimase Vali-IT lennu õpilastega ja vaadata nende profiile.</li>
              <li>lisada praktikavõimalusi enda ettevõttes.</li>
              <li>lisada kalendrisse kohtumisi kogu lennuga klassiruumis või veebi vahendusel.</li>
              <li>kuvada ainult praktikakohta otsivaid õpilasi.</li> </h5>
            </div>
          </div>
        </div>

      </div>



      <div class="text">
        <p>
          „Vali IT!“ on täiskasvanute ümberõppeprogramm, mille eesmärgiks on anda osalejatele tarkvaraarendaja
          algoskused.
          Programmis osalejad läbivad 6-nädalase täismahus õppe (5 päeva nädalas, kuni 8 tundi päevas). Sellele järgneb
          8-nädalane (40 tööpäeva, kuni 8 tundi päevas) praktika ettevõtetes.
          Kandideerimine on avatud pidevalt. Andke teada oma huvist ja täitke kandideerimisankeet!

        </p>
      </div>

      <br>
      <h3>BCS koolituse koduleht</h3>
      <p><a href="https://www.bcskoolitus.ee/" target="_blank" rel="noopener">Vajuta siia</a></p>

      <h3>Vali-IT koduleht</h3>
      <p><a href="http://vali-it.ee/" target="_blank" rel="noopener">Vajuta siia</a></p>


    </div>
    <h5>Loading New Students</h5>
    <div class="spinner-border text-primary" role="status">
      <span class="visually-hidden">Loading...</span>
    </div>

  </div>

</template>

<script>
import LogOutView from "@/views/LogOutView";
export default {
  components: {LogOutView},
  data: function () {
    return {}
  }
}
</script>

<style>

.logo{
  margin-top: 1vh;
  margin-bottom: 1vh;
}

img {
  width: 25vw;
  height: auto;
}

.introduction {
  margin-top: 5vh;
  margin-bottom: 10vh;
  /*border: 2px solid red;*/
}
.companyandstudent{
  width:70%;
  height: auto;
  margin: auto auto 10vh;
}
#student{
  float: left;
  width: 47%;
  margin-right: 6%;

}
#company{
  width: 47%;
  /*margin-bottom: 10vh;*/
}

.text{
  margin-top: 5vh;
  margin-bottom: 5vh;
}
.spinner-border text-primary{
  margin-top: 5vh;
  margin-bottom: 5vh;
}




</style>
