<template>
  <div>

    <Studentbuttons :show-internship="showInternship" :show-profile="showProfile"/>
    <br>
    <div class="pictureAndForm">
      <div class="form">
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
            <input type="text" class="form-control" placeholder="Millal sooviksid praktikaga alustada?"
                   v-model="profile.availableFrom">

          </div>
          <div>

            <label class="label-form">Otsin praktikakohta (ei tööta)</label>
            <select class="selection" @click="isAvailable">
              <option selected :value="true">Jah</option>
              <option selected :value="false">Ei</option>
            </select>
          </div>
          <button class="btn btn-primary" v-on:click="updateStudentProfile">Submit</button>
        </form>
      </div>

      <div class="profile">
        <div class="card" id="profile">
<!--          <img src="../assets/default-profile.png" class="card-img-top" alt="">-->
          <img :src="picture.base64" class="card-img-top" alt="">
          <div class="card-body">

            <div class="upload">
              <input type="file" id="customFile">
            </div>


            <h5 class="card-title">{{ this.contact.firstName + ' ' + this.contact.lastName }}</h5>
            <small>About me</small>
            <p class="card-text">

              <input type="text" class="form-control" placeholder="Räägi natuke endast" v-model="profile.aboutMe">
            </p>
          </div>
        </div>
      </div>
    </div>

    <br>
    <br>
    <br>
    <br>
    <div>{{ 'this is session roleID: ' + roleId }}</div>
    <div>{{ 'this is session userID: ' + userId }}</div>
    <div>{{ 'this is session profileID: ' + studentProfileId }}</div>
    <div>{{ 'this is session contactID: ' + contactId }}</div>
    <div>{{ 'this is session studentID: ' + studentId }}</div>
    <div>{{ 'this is isAvailable: ' + isAvailable }}</div>
    <div>{{ 'base64: ' + picture.base64 }}</div>
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
      isAvailable: false,
      roleId: sessionStorage.getItem('roleId'),
      userId: sessionStorage.getItem('userId'),
      studentProfileId: sessionStorage.getItem('studentProfileId'),
      contactId: sessionStorage.getItem('contactId'),
      studentId: sessionStorage.getItem('studentId'),
      profile: {},
      contact: {},
      picture: {},
    }
  },
  methods:
      {
        getStudentPicture: function () {
          this.$http.get("/picture/id", {
            params: {
              studentId: this.studentId
            }
          })
              .then(response => {
                this.picture = response.data
                console.log(response.data)
              }).catch(error => {
            console.log(error)
          })
        },
        // handleImage(event) {
        //   // this.displayInputPicture = true
        //   // this.displayUploadPictureDetailsOptions = true
        //
        //   const selectedImage = event.target.files[0];
        //   this.createBase64Image(selectedImage);
        // },
        //
        // createBase64Image(fileObject) {
        //   const reader = new FileReader();
        //   reader.onload = () => {
        //     this.pictureExport.data = reader.result;
        //   };
        //   reader.onerror = function (error) {
        //     alert(error);
        //   }
        //   reader.readAsDataURL(fileObject);
        // },


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
        getContactInfo: function (id) {
          this.$http.get("/contact/id", {
            params: {
              contactId: id
            }
          })
              .then(response => {
                this.contact = response.data
                console.log(response.data)
              }).catch(error => {
            console.log(error)
          })
        },

        setIsAvailable: function (id) {
          this.$http.put("/student/id", {}, {
                params: {
                  studentId: id
                }
              }
          ).then(response => {
            console.log(response.data)
          }).catch(error => {
            console.log(error)
          })
        },

        updateStudentProfile: function () {
          this.$http.put("/student-profile/update", this.profile, {
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
  mounted() {
    this.getStudentProfileById(this.studentProfileId)
    this.getContactInfo(this.contactId)
    this.getStudentPicture()

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
  float: right;

  margin-right: 100px;
}

div.form-group {
  display: grid;
  grid-template-columns: max-content max-content;
  grid-gap: 10px;
  border: 2px solid red;
}

div.form-group label {
  text-align: right;
  margin-top: 10px
}

div.form-group label:after {
  content: ":";
}

img {

  width: auto;
  height: auto;


}

.upload {
  padding-top: 5px;
  padding-bottom: 5px;
}

.pictureAndForm {
  width: 70%;
  height: auto;
  margin: auto auto 10vh;

}

#profile {
  float: left;
  width: 30%;
  margin-right: 6%;
}

/*.card-text {*/
/*  height: ;*/
/*  */
/*}*/

.selection {
  margin-left: 5px;
  /*border: 2px solid red;*/
}

#form {
  width: 47%;
  /*margin-bottom: 10vh;*/
}


/*.text{*/
/*  margin-top: 5vh;*/
/*  margin-bottom: 5vh;*/
/*}*/

</style>