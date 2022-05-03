<template>
  <div>
    <div class="btn-group btn-group-toggle" data-toggle="buttons">
      <label class="btn btn-info active">
        <input type="radio" name="options" id="option1" autocomplete="off" checked v-on:click="showProfile"> Minu profiil
      </label>
      <label class="btn btn-info">
        <input type="radio" name="options" id="option2" autocomplete="off" v-on:click="showInternship"> Minu praktika
      </label>
      <label class="btn btn-info ">
        <input type="radio" name="options" id="option3" autocomplete="off"> Minu kursus
      </label>
    </div>
    <br>
    <br>
    <form>

      <div class="form-group">
        <label class="label-form">Sünniaeg</label>
        <input type="date" class="form-control" placeholder="Sünniaeg" v-model="request.dateOfBirth">
        <label class="label-form">Linn, kus soovid töötada</label>
        <input type="text" class="form-control" placeholder="Linn" v-model="request.location">
        <label class="label-form">Sinu oskused</label>
        <input type="text" class="form-control" placeholder="Kirjelda oma oskusi" v-model="request.competence">
        <label class="label-form">Tugevused</label>
        <input type="text" class="form-control" placeholder="Kirjelda oma tugevusi" v-model="request.strength">
        <label class="label-form">Minust</label>
        <input type="text" class="form-control" placeholder="Räägi natuke endast" v-model="request.aboutMe">
        <label class="label-form">LinkedIn</label>
        <input type="text" class="form-control" placeholder="Sinu LinkedIn aadress" v-model="request.linkedin">
        <label class="label-form">GitHub</label>
        <input type="text" class="form-control" placeholder="Sinu GitHub aadress" v-model="request.githubLink">
        <label class="label-form">Olen saadaval alates</label>
        <input type="text" class="form-control" placeholder="Millal sooviksid praktikaga alustada?" v-model="request.availableFrom">
        <label class="label-form">Profiili ID</label>
      </div>
      <div>
      <div class="form-group form-check">
        <label class="form-check-label">
          <input class="form-check-input" type="checkbox"> Otsin praktikakohta
        </label>
      </div>
      </div>
      <button class="btn btn-primary" v-on:click="updateStudentProfile">Submit</button>
    </form>



    <div>{{'this is session roleID: ' + roleId}}</div>
    <div>{{'this is session userID: ' +userId}}</div>
    <di>{{'this is session profileID: ' +studentProfileId}}</di>
  </div>
</template>

<script>
export default {
  name: "UserPageView",
  data: function () {
    return {
      adminPage: 1,
      studentPage: 2,
      companyPage: 3,
      roleId: sessionStorage.getItem('roleId'),
      userId: sessionStorage.getItem('userId'),
      showProfile: false,
      showInternship: false,
      showCourse: false,
      // studentProfileId: sessionStorage.getItem('studentProfileId'),
      studentProfileId: 6,
      request: {
      }


    }
  },
  methods:
      {
        // updateStudentProfile: function () {
        //   this.$http.post("/student-profile/profileId", this.request
        //   ).then(response => {
        //     console.log(response.data)
        //   }).catch(error => {
        //     console.log(error)
        //   })
        // },

        updateStudentProfile: function (studentProfileId, request) {
          this.$http.post("/student-profile/update", {
            params: {
              studentProfileId: studentProfileId,
              request: request
            }
              }
          ).then(response => {
            console.log(response.data)
          }).catch(error => {
            console.log(error)
          })
        }

      },
  mounted(){

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
  display:grid;
  grid-template-columns: max-content max-content;
  grid-gap:10px;
}
div.form-group label       { text-align:right;
margin-top: 10px}
div.form-group label:after { content: ":"; }
</style>