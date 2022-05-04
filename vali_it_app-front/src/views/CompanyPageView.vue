<template>
  <div>

    <CompanyButtons :show-internship="addOffer" :show-profile="applications"/>
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
        Praktikakoht on tasustatud €  <input class="p-switch" type="checkbox">
      </div>

    </form>


  </div>
</template>

<script>
import CompanyButtons from "@/components/CompanyButtons";

export default {
  name: "CompanyPageView",
  components: {CompanyButtons},
  data: function () {
    return {
      addOffer: false,
      applications: false,
      offer: {},
      options: {}


    }
  },
  methods: {

    getAllWorkOptions: function () {
      this.$http.get("/work-option/all")
          .then(response => {
            this.options = response.data
            console.log(response.data)
          }).catch(error => {
        console.log(error)
      })
    },
  },

  // addNewOffer: function () {
  //
  //     this.$http.post("/internship-opportunity/new", this.offer
  //     ).then(response => {
  //
  //     }).catch(error => {
  //
  //       console.log(error.response.data)
  //     });
  //
  // },

  mounted() {
    this.getAllWorkOptions()
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
  margin-right: 130px;
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