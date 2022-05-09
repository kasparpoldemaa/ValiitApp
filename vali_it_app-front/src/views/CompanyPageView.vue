<template>
  <div>

    <div>
      <h2>SISESTA PRAKTIKA PAKKUMINE :</h2>
    </div>
    <form>
      <div class="form-group">
        <label class="label-form"></label>
        <input type="text" class="form-control" id="name" placeholder="Asukoht" v-model="offer.location">

        <label class="label-form"></label>
        <input type="text" class="form-control" placeholder="Millal praktika algab" v-model="offer.startTime">

        <label class="label-form"></label>
        <input type="text" class="form-control" placeholder="Praktika pikkus" v-model="offer.duration">

        <label class="label-form"></label>
        <input type="text" class="form-control" placeholder="Mitu praktika kohta on" v-model="offer.numberOfPositions">

        <label class="label-form"></label>
        <input type="text" class="form-control" placeholder="Kasutusel tehnoloogiad" v-model="offer.technology">

        <label class="label-form"></label>
        <input type="text" class="form-control" placeholder="Kontor, hübriid vm" v-model="offer.workType">

        <label class="label-form"></label>
        <input type="text" class="form-control" placeholder="Täiendav info" v-model="offer.comment">

      </div>

      <div>

        Praktikakoht on tasustatud € <input type="checkbox" v-model="isPayable">
        <br>
        <br>
        <button class="btn btn-primary" v-on:click="addInternship">Lisa uus pakkumine</button>

      </div>

      <br>
      <br>

      <div class="xxx">
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
                      <tr v-for="offerForm in offerForms">
                        <th scope="row">
                          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                               class="bi bi-chat-left-fill" viewBox="0 0 16 16">
                            <path
                                d="M2 0a2 2 0 0 0-2 2v12.793a.5.5 0 0 0 .854.353l2.853-2.853A1 1 0 0 1 4.414 12H14a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
                          </svg>
                        </th>
                        <td>{{ offerForm.startTime }}</td>
                        <td>{{ offerForm.duration }}</td>
                        <td>{{ offerForm.location }}</td>
                        <td>{{ offerForm.numberOfPositions }}</td>
                        <td>{{ offerForm.technology }}</td>
                        <td>{{ offerForm.workType }}</td>
                        <td id="wrapthisthing" style="word-wrap: break-word;">{{ offerForm.isPayable ? 'jah' : 'ei' }}</td>
                        <td>{{ offerForm.comment }}</td>
                        <td>
                          <button type="button" class="btn btn-danger" @click="deleteInternshipOfferByID(offerForm.id)">
                            Kustuta
                          </button>
                        </td>

                        <td>
                          <button type="button" class="btn btn-primary">
                            Huvilised <span class="badge badge-light">{{'siia on vaja counti'}}</span>
                            <span class="sr-only">how many applicants</span>
                          </button>

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
      answer: '',
      count: 0,
      internshipOppurtunityId: null,
      studentIds: {}


    }
  },
  methods: {

    // getApplicationsDiv: function () {
    //   this.applications = true
    //   this.addOffer = false
    //   this.showOffers = false
    // },

    // getShowOffersDiv: function () {
    //   this.showOffers = true
    //   this.applications = false
    //   this.addOffer = false
    // },

    refreshPage: function () {
      window.location.reload();
    },

    addInternship: function () {
      this.$http.post("/company/new-internship", this.offer, {
            params: {
              userId: this.userId,
              isPayable: this.isPayable
            }
          }
      ).then(response => {
        this.refreshPage()
        this.getAllOffersByUserId()
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

    getAllApplicants: function (internshipOppurtunityId) {
      this.$http.get("/applicant/all", {
            params: {
              internshipOppurtunityId: internshipOppurtunityId
            }
          }
      ).then(response => {
        this.count = response.data.studentCount
        this.studentIds = response.data.studentId
        console.log(response.data)
      }).catch(error => {
        console.log(error)
      })
    },
  },


  mounted() {
    this.addInternship()
    this.getAllOffersByUserId()
    this.getAllApplicants()

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

}

div.form-group {
  display: inline-list-item;
  margin: 10px;

}

/*div.form-group label {*/
/*  text-align: right;*/
/*  margin-top: 1px*/
/*}*/

/*div.form-group label:after {*/
/*  content: ":";*/
/*}*/

.card {
  width: 80vw;
  background-color: azure;
  color: black;
  border-color: black;
}

.card-header {
  color: black;
}

#wrapthisthing{
  max-width: 300vw;
}


</style>