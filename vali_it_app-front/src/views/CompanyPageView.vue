<template>
  <div>

    <!--        <CompanyButtons :show-internship="addOffer" :show-profile="applications"/>-->

    <div class="btn-group">
      <button type="button" style="background-color: blue" class="btn btn-dark" @click="getInternshipOfferDiv">Praktika
        pakkumise lisamine
      </button>
      <button type="button" style="background-color: blue" class="btn btn-dark" @click="getShowOffersDiv">Näita minu
        loodud pakkumisi
      </button>
      <button type="button" style="background-color: blue" class="btn btn-dark" @click="getApplicationsDiv">Näita
        kandideerimisi
      </button>
    </div>

    <br>
    <br>
    <form>

      <div class="form-group" v-if="addOffer">

        <label class="label-form">Asukoht</label>
        <input type="text" class="form-control" placeholder="Asukoht" v-model="offer.location">

        <label class="label-form">Algusaeg</label>
        <input type="text" class="form-control" placeholder="Millal praktika algab" v-model="offer.startTime">

        <label class="label-form">Kestvus</label>
        <input type="text" class="form-control" placeholder="Praktika pikkus" v-model="offer.duration">

        <label class="label-form">Vabad kohad</label>
        <input type="text" class="form-control" placeholder="Mitu praktika kohta on" v-model="offer.numberOfPositions">

        <label class="label-form">Tehnoloogiad</label>
        <input type="text" class="form-control" placeholder="Kasutusel tehnoloogiad" v-model="offer.technology">

        <label class="label-form">Töövorm</label>
        <input type="text" class="form-control" placeholder="Kontor, hübriid vm" v-model="offer.workType">

        <label class="label-form">Lisainfo</label>
        <input type="text" class="form-control" placeholder="Täiendav info" v-model="offer.comment">

      </div>

      <div class="form-group" v-if="applications">

        <label class="label-form">Asukoht</label>
        <input type="text" class="form-control" placeholder="Asukoht" v-model="offer.location">

      </div>

      <div class= "xxx" v-if="showOffers">

        <div id="accordion">
          <div class="card">
            <div class="card-header" id="headingOne">
              <h5 class="mb-0">
                <button class="btn btn-link" style="color: black" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true"
                        aria-controls="collapseOne">
                  Praktika pakkumine algusega: [siia peaks kuvama kuupäeva millal algab]
                </button>
              </h5>
            </div>
            <div id="collapseOne" class="collapse show"  aria-labelledby="headingOne" data-parent="#accordion">
              <div class="card-body">
                aaaaaaaaaaaaaaaaaaaaaa qwef weqf qewf few fewqf qewf qwef qwef qwef geqw fqewf g weg fwqefg qewg
              </div>
            </div>
          </div>
          <div class="card">
            <div class="card-header" id="headingTwo">
              <h5 class="mb-0">
                <button class="btn btn-link collapsed" style="color: black" data-toggle="collapse" data-target="#collapseTwo"
                        aria-expanded="false" aria-controls="collapseTwo">
                  Praktika pakkumine algusega: [siia peaks kuvama kuupäeva millal algab]
                </button>
              </h5>
            </div>
            <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
              <div class="card-body">
                aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa f wef qwef qwe feqw fqewf qewfwqegffffffffffffffwqee f qwef wqef wgqf e
              </div>
            </div>
          </div>
          <div class="card">
            <div class="card-header" id="headingThree">
              <h5 class="mb-0">
                <button class="btn btn-link collapsed" style="color: black" data-toggle="collapse" data-target="#collapseThree"
                        aria-expanded="false" aria-controls="collapseThree">
                  Praktika pakkumine algusega: [siia peaks kuvama kuupäeva millal algab]
                </button>
              </h5>
            </div>
            <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordion">
              <div class="card-body">
                aaaa weqf qewf qwef aaaaaaaaaaaaqewf ewqf qewf aaaaaaaaaaaaewqgf qwef weqf qewgf ewg qewg qewg ewg ewg ewg ewrg rehg erg ewg werg qwreg qewrg qweg qewg qweg qewg qewg werrg ewg ewqg  aaaaaaaaewf fewq fqewfq weffqwef qef wqef
              </div>
            </div>
          </div>
        </div>

      </div>

      <div v-if="addOffer">

        Praktikakoht on tasustatud € <input type="checkbox" v-model="isPayable">
        <br>
        <br>
        <button class="btn btn-primary" v-on:click="addInternship">Lisa uus pakkumine</button>

      </div>

    </form>

  </div>
</template>

<script>
// import CompanyButtons from "@/components/CompanyButtons";
import axios from "axios";

export default {
  name: "CompanyPageView",
  // components: {CompanyButtons},
  data: function () {
    return {
      offer: {},
      addOffer: false,
      applications: false,
      showOffers: false,
      isPayable: false,
      userId: sessionStorage.getItem('userId')


    }
  },
  methods: {

    getInternshipOfferDiv: function () {
      this.addOffer = true
      this.applications = false
      this.showOffers = false
    },

    getApplicationsDiv: function () {
      this.applications = true
      this.addOffer = false
      this.showOffers = false
    },

    getShowOffersDiv: function () {
      this.showOffers = true
      this.applications = false
      this.addOffer = false
    },

    addInternship: function () {
      this.$http.post("/company/new-internship", this.offer, {
            params: {
              userId: this.userId,
              isPayable: this.isPayable
            }
          }
      ).then(response => {
        console.log(response.data)
      }).catch(error => {
        console.log(error)
      })
    },

    getAllOffersByUserId: function () {
      this.$http.get("/company/new-internship", {
            params: {
              userId: this.userId,
            }
          }
      ).then(response => {
        console.log(response.data)
      }).catch(error => {
        console.log(error)
      })
    },
  }
}
</script>
<style scoped>
/*body {*/
/*  text-align: center;*/
/*}*/

/*.label-form{*/
/*  padding-top: 10px;*/
/*  margin-right: 100px;*/
/*}*/

form {
  display: inline-block;
  margin-right: 100px;
}

div.form-group {
  display: grid;
  grid-template-columns: max-content max-content;
  grid-gap: 10px;
}

div.form-group label {
  text-align: right;
  margin-top: 10px
}

div.form-group label:after {
  content: ":";
}

.card {
  width: 80vw;
  background-color: azure;
  color: black;
  border-color: black;
  left: 4%;
}

.card-header {
  color: black;
}



</style>