<template>
  <div>

    <Studentbuttons :show-internship="showInternship" :show-profile="showProfile"/>
    <br>

    <form>

      <div class="form-group">
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
        <input type="text" class="form-control" placeholder="Millal sooviksid praktikaga alustada?" v-model="profile.availableFrom">
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
import Studentbuttons from "@/components/Studentbuttons";

export default {
  name: "UserPageView",
  components: {Studentbuttons},
  data: function () {
    return {
      adminPage: 1,
      studentPage: 2,
      companyPage: 3,
      showProfile: false,
      showInternship: false,
      showCourse: false,
      roleId: sessionStorage.getItem('roleId'),
      userId: sessionStorage.getItem('userId'),
      studentProfileId: sessionStorage.getItem('studentProfileId'),
      profile: {
      }


    }
  },
  methods:
      {

        getStudentProfileById: function (id) {
          this.$http.get("/student-profile", {
            params: {
              studentProfileId: id
            }
          })
              .then(response => {
                this.profile = response.data
                console.log(response.data)
              }).catch(error => {
            console.log(error)
          })
        },

        updateStudentProfile: function () {

          this.$http.put("/student-profile/update",this.profile, {
            params: {
              studentProfileId: this.studentProfileId
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
this.getStudentProfileById(this.studentProfileId)

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