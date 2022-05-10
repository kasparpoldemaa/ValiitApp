<template>
  <div class="form-group" id="formGroup">
    <label class="label-form">Sünniaeg</label>
    <input type="date" class="form-control" placeholder="Sünniaeg" v-model="profile.dateOfBirth">
    <label class="label-form">Linn, kus soovid töötada</label>
    <input type="text" class="form-control" placeholder="Linn" v-model="profile.location">
    <label class="label-form">Sinu oskused</label>
    <input type="text" class="form-control" placeholder="Kirjelda oma oskusi" v-model="profile.competence">
    <label class="label-form">Tugevused</label>
    <input type="text" class="form-control" placeholder="Kirjelda oma tugevusi" v-model="profile.strength">
    <label class="label-form">Minust</label>
    <input type="text" class="form-control" placeholder="Räägi natuke endast" v-model="profile.aboutMe">
    <label class="label-form">LinkedIn</label>
    <input type="text" class="form-control" placeholder="Sinu LinkedIn aadress" v-model="profile.linkedin">
    <label class="label-form">GitHub</label>
    <input type="text" class="form-control" placeholder="Sinu GitHub aadress" v-model="profile.githubLink">
    <label class="label-form">Olen saadaval alates</label>
    <input type="text" class="form-control" placeholder="Millal sooviksid praktikaga alustada?"
           v-model="profile.availableFrom">
  </div>
</template>
<script>
export default {
  name: 'StudentProfile',
  props: {
    profile: {}
  }
}
</script>
<style scoped>


body {
  text-align: center;
}

.label-form{
  padding-top: 10px;
  /*border: 2px solid red;*/
}

.form-control{
  width: 20vw;
}

input{
  margin-top: 3%;
  margin-bottom: 3%;

  /*padding: 0.2em;*/
  /*box-sizing: border-box;*/
  /*width: 100%*/
}


/*form {*/
/*  float: left;*/

/*}*/

div.form-group {
  display: grid;
  grid-template-columns: max-content max-content;
  grid-gap: 10px;


}


div.form-group label {
  text-align: right;
  margin-top: 10px;

}

div.form-group label:after {
  content: ":";
}

img {

  width: auto;
  height: auto;


}

/*.card-text {*/
/*  height: ;*/
/*  */
/*}*/


/*.text{*/
/*  margin-top: 5vh;*/
/*  margin-bottom: 5vh;*/
/*}*/

</style>