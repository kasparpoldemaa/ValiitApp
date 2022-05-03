<template>
<div>

  <CompanyButtons :show-internship="addOffer" :show-profile="applications"/>
  <br>





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

    }
  },
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
  display:grid;
  grid-template-columns: max-content max-content;
  grid-gap:10px;
}
div.form-group label       { text-align:right;
  margin-top: 10px}
div.form-group label:after { content: ":"; }
</style>