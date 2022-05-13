<template>
  <div>

    <div id="companyName" >
      {{companyName}}
    </div>

    <br>

    <div v-if="showOffers">
      <h2>SISESTA PRAKTIKA PAKKUMINE :</h2>
    </div>

    <div id="inputDiv" class="form-group" v-if="showOffers">
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

    <div v-if="showOffers">

      <label>Praktikakoht on tasustatud € </label>
      <input type="checkbox" v-model="isPayable">
      <br>
      <br>
      <button class="btn btn-primary" v-on:click="addInternship">Lisa uus pakkumine</button>

    </div>

    <br>
    <br>

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
                    <tr v-for="offerForm in offerForms">
                      <th scope="row">
                        <OfferIcon/>
                      </th>
                      <td>{{ offerForm.startTime }}</td>
                      <td>{{ offerForm.duration }}</td>
                      <td>{{ offerForm.location }}</td>
                      <td>{{ offerForm.numberOfPositions }}</td>
                      <td>{{ offerForm.technology }}</td>
                      <td>{{ offerForm.workType }}</td>
                      <td id="wrapthisthing" style="word-wrap: break-word;">{{
                          offerForm.isPayable ? 'jah' : 'ei'
                        }}
                      </td>
                      <td>{{ offerForm.comment }}</td>
                      <td>
                        <button type="button" class="btn btn-danger" @click="deleteInternshipOfferByID(offerForm.id)">
                          Kustuta
                        </button>
                      </td>
                      <td>
                        <button type="button" class="btn btn-primary" @click="getAllApplicants(offerForm.id)">
                          Huvilised <span class="badge badge-light">{{ offerForm.interestedCount }}</span>
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


    <!--    <div v-if="showApplicants">-->
    <!--      <button id="backButton" type="button" class="btn btn-warning" @click="pushToCompanyPage">Tagasi</button>-->
    <!--    </div>-->


    <div id="applicantTable" v-if="showApplicants">
      <h2 id="headline">KANDIDAADID </h2>
      <br>
      <table class="table">
        <thead>
        <tr>
          <th scope="col"></th>
          <th scope="col">Eesnimi</th>
          <th scope="col">Perekonnanimi</th>
          <th scope="col"></th>
        </tr>
        </thead>
        <tbody v-for="applicantRespons in applicantResponse">
        <tr>
          <td>
            <img class="ui-menu-icons" alt="email" src="../assets/user.png">
          </td>
          <td>{{ applicantRespons.firstName }}</td>
          <td>{{ applicantRespons.lastName }}</td>
          <td>
            <button type="button" class="btn btn-primary"
                    @click="getApplicantProfile(applicantRespons.studentId, opportunityId)">
              Profiil
            </button>
          </td>
        </tr>

        </tbody>
      </table>

    </div>


  </div>
</template>

<script>

import OfferIcon from "@/components/OfferIcon";

export default {
  name: "CompanyPageView",
  components: {OfferIcon},
  data: function () {
    return {
      offer: {},
      showOffers: false,
      showApplicants: true,
      isPayable: false,
      offerForms: {},
      arrayLength: '',
      userId: sessionStorage.getItem('userId'),
      id: null,
      studentIds: {},
      applicantResponse: {},
      opportunityId: this.$route.query.opportunityId,
      companyName: ''

    }
  },
  methods: {

    getApplicantProfile: function (studentId, opportunityId) {
      this.$router.push({name: 'student', query: {studentId: studentId, opportunityId: opportunityId}})
    },


    closeDivs: function () {
      this.showOffers = false
      this.showApplicants = true

    },
    openFirstDiv: function () {
      this.showApplicants = false
      this.showOffers = true
    },

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

    getAllApplicants: function (opportunityId) {
      this.$http.get("/profile/all-applicants", {
            params: {
              opportunityId: this.opportunityId
            }
          }
      ).then(response => {
        this.closeDivs()
        this.applicantResponse = response.data
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
    getCompanyName: function () {
      this.$http.get("/contact/company-name", {
            params: {
              userId: this.userId,
            }
          }
      ).then(response => {
        this.companyName = response.data
        console.log(response.data)
      }).catch(error => {
        console.log(error)
      })
    },

  },

  mounted() {
    this.getAllApplicants()
    this.getAllOffersByUserId()
    this.getCompanyName()


  }
}
</script>
<style scoped>

form {
  display: inline-block;

}

div.form-group {
  display: inline-list-item;
  margin: 10px;

}

.card {
  width: 80vw;
  margin-left: auto;
  margin-right: auto;
  background-color: azure;
  color: black;
  border-color: black;
}

.card-header {
  color: black;
}

#wrapthisthing {
  max-width: 300vw;
}

#backButton {
  float: left;
  margin-bottom: 50px;
  margin-left: 30px;
}

#inputDiv {
  width: 80vw;
  margin-left: auto;
  margin-right: auto;
}

#applicantTable {
  width: 25vw;
  margin-left: auto;
  margin-right: auto;

}

.xxx {
  margin-bottom: 25vh;
}

#companyName{
  float: right;
  margin-right: 30px;
  font-weight: bold;
}

img {
  width: 18px;
  height: auto;
}


/*input{*/
/*  width: 80vw;*/
/*  margin-left: auto;*/
/*  margin-right: auto;*/
/*}*/


</style>