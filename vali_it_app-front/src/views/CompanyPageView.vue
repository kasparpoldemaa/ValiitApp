<template>
  <div>

<!--        <CompanyButtons :show-internship="addOffer" :show-profile="applications"/>-->
    <br>
    <form>

      <div class="form-group">

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

      <div>
        Praktikakoht on tasustatud € <input class="p-switch" type="checkbox" v-on:click="paid">
      </div>

      <button class="btn btn-primary" v-on:click="addInternship">Lisa uus pakkumine</button>

    </form>


  </div>
</template>

<script>
import CompanyButtons from "@/components/CompanyButtons";
import axios from "axios";

export default {
  name: "CompanyPageView",
  components: {CompanyButtons},
  data: function () {
    return {
      offer: {},
      addOffer: false,
      applications: false,
      isPayable: false,
      userId: sessionStorage.getItem('userId')


    }
  },
  methods: {

    paid: function () {
      this.isPayable = true
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
    }
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
</style>