<template>
  <div>

    <div class="btn-group">
      <button type="button" style="background-color: blue" class="btn btn-dark" @click="getInternshipOfferDiv">Praktika
        pakkumise lisamine
      </button>
      <button type="button" style="background-color: blue" class="btn btn-dark" @click="getAllOffersByUserId">Näita minu
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

      <div class="xxx" v-if="showOffers">
        <div>
          <div id="accordion">
            <div class="card">
              <div class="card-header" id="headingOne">
                <button class="btn btn-link" style="color: black" data-toggle="collapse" data-target="#collapseOne"
                        aria-expanded="false"
                        aria-controls="collapseOne">
                  <strong>OLED SISESTANUD {{ this.arrayLength }} PRAKTIKAPAKKUMIST
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                         class="bi bi-caret-down-square-fill" viewBox="0 0 16 16">
                      <path
                          d="M0 2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2zm4 4a.5.5 0 0 0-.374.832l4 4.5a.5.5 0 0 0 .748 0l4-4.5A.5.5 0 0 0 12 6H4z"/>
                    </svg>
                  </strong>
                </button>
              </div>
              <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordion">
                <div class="card-body">

                  <div>

                    <table class="table table-hover">
                      <thead>
                      <tr>
                        <th scope="col"></th>
                        <th scope="col">Algus kuupäev</th>
                        <th scope="col">Kestvus</th>
                        <th scope="col">Asukoht</th>
                        <th scope="col">Vabad kohad</th>
                        <th scope="col">Kasutusel tehnoloogiad</th>
                        <th scope="col">Töövorm</th>
                        <th scope="col">Tasu</th>
                        <th scope="col">Lisainfo</th>
                      </tr>
                      </thead>
                      <tbody>
                      <tr v-for="offerForm in offerForms" >
                        <th scope="row">
                          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chat-left-fill" viewBox="0 0 16 16">
                          <path d="M2 0a2 2 0 0 0-2 2v12.793a.5.5 0 0 0 .854.353l2.853-2.853A1 1 0 0 1 4.414 12H14a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/></svg>
                        </th>
                        <td>{{ offerForm.startTime }}</td>
                        <td>{{ offerForm.duration }}</td>
                        <td>{{ offerForm.location }}</td>
                        <td>{{ offerForm.numberOfPositions }}</td>
                        <td>{{ offerForm.technology }}</td>
                        <td>{{offerForm.workType }}</td>
                        <td>{{ offerForm.isPayable }}</td>
                        <td>{{ offerForm.comment }}</td>
                        <td>
                          <button type="button" class="btn btn-danger" @click="deleteInternshipOfferByID(offerForm.id)">Kustuta</button>
                        </td>
                      </tr>
                      </tbody>
                    </table>

                  </div>
                </div>


              </div>
            </div>
          </div>
        </div>

      </div>

      <div v-if="addOffer">

        Praktikakoht on tasustatud € <input type="checkbox" v-model="isPayable">
        <br>
        <br>
        <button class="btn btn-primary"  v-on:click="addInternship">Lisa uus pakkumine</button>

      </div>

    </form>

  </div>
</template>

<script>

import axios from "axios";

export default {
  name: "CompanyPageView",
  data: function () {
    return {
      offer: {},
      addOffer: false,
      applications: false,
      showOffers: false,
      isPayable: false,
      offerForms: {},
      arrayLength: '',
      userId: sessionStorage.getItem('userId'),
      id: null,
      answer: ''



    }
  },
  methods: {

    // answerToBoolean: function () {
    //   if(this.isPayable===true){
    //     this.answer = 'jah'
    //   }else{
    //     this.answer = 'ei'
    //   }
    // },


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
        // this.clearFields()
        console.log(response.data)
      }).catch(error => {
        console.log(error)
      })
    },

    getAllOffersByUserId: function () {
      this.$http.get("/company/all", {
            params: {
              userId: this.userId,
            }
          }
      ).then(response => {
        this.getShowOffersDiv()
        this.arrayLength = response.data.length
        this.offerForms = response.data
        console.log(response.data)
      }).catch(error => {
        console.log(error)
      })
    },
    deleteInternshipOfferByID: function (id) {
      this.$http.delete("/company/remove", {
            params: {
              id: id
            }
          }
      ).then(response => {
        this.getAllOffersByUserId()
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