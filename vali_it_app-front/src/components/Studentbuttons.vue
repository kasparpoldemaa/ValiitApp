<template>
  <div class="btn-group btn-group-toggle" data-toggle="buttons">
    <label class="btn btn-info active">
      <input type="radio" name="options" id="option1" autocomplete="off" checked v-on:="showProfile"> Minu profiil
    </label>
    <label class="btn btn-info">
      <input type="radio" name="options" id="option2" autocomplete="off" v-on:click="showInternship"> Minu praktika
    </label>
    <label class="btn btn-info ">
      <input type="radio" name="options" id="option3" autocomplete="off"> Minu kursus
    </label>
  </div>
</template>
<script>
export default {
  name: 'Studentbuttons',
  props: {
    showInternship: {},
    showProfile: {}
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

div.form-group label {
  text-align: right;
  margin-top: 10px
}

div.form-group label:after {
  content: ":";
}
</style>