<template>
  <div>

    <div class="btn-group" role="group" aria-label="Basic example">
      <button type="button" class="btn btn-dark" @click="showProfileView">Minu profiil</button>
      <button type="button" class="btn btn-dark" @click="showInternShipView">Minu praktika</button>
      <button type="button" class="btn btn-dark" @click="showCourseView">Näita kandideerimisi</button>
    </div>

    <div v-if="profileView">
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
              <label class="label-form m-1">Otsin praktikakohta</label>
              <input type="checkbox" v-model="isAvailable">
            </div>
            <button class="btn btn-primary" v-on:click="updateStudentProfile">Submit</button>
          </form>
        </div>

        <div class="profile">
          <div class="card" id="profile">
            <div v-if="picture.base64 === null">
              <img src="../assets/default-profile.png" class="card-img-top" alt="">
            </div>
            <div v-else>
              <img :src="picture.base64" class="card-img-top" alt="">
            </div>
            <div class="card-body">

              <div class="upload-button">
                <input type="file" @change="handleImage" accept="image/x-png,image/jpeg">
                <button v-on:click="addPicture" type="button" class="btn btn-outline-link btn-sm m-3">Lisa pilt</button>
                <button v-on:click="deletePicture" type="button" class="btn btn-outline-link btn-sm">Eemalda pilt</button>
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
    </div>

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
      profileView: false,
      internShipView: false,
      courseView: false,
      isAvailable: true,
      roleId: sessionStorage.getItem('roleId'),
      userId: sessionStorage.getItem('userId'),
      studentProfileId: sessionStorage.getItem('studentProfileId'),
      contactId: sessionStorage.getItem('contactId'),
      studentId: sessionStorage.getItem('studentId'),
      profile: {},
      contact: {},
      picture: {},
      pictureExport: {},
      displayPic: false
    }
  },
  methods:
      {


        handleImage(event) {
          // this.displayInputPicture = true
          // this.displayUploadPictureDetailsOptions = true

          const selectedImage = event.target.files[0];
          this.createBase64Image(selectedImage);
        },

        createBase64Image(fileObject) {
          const reader = new FileReader();
          reader.onload = () => {
            this.pictureExport.base64 = reader.result;
          };
          reader.onerror = function (error) {
            alert(error);
          }
          reader.readAsDataURL(fileObject);
        },
        addPicture: function () {
          this.$http.post("/picture/in", this.pictureExport, {
                params: {
                  studentId: this.studentId
                }
              }
          ).then(response => {
            this.displayPic = true
            console.log(response.data)
          }).catch(error => {
            console.log(error)
          })
        },
        getStudentPicture: function () {
          this.$http.get("/picture/student", {
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
        deletePicture: function () {
          this.$http.delete("/picture/student", {
            params: {
              studentId: this.studentId
            }
              }
          ).then(response => {
            this.displayPic = false
            console.log(response.data)
          }).catch(error => {
            console.log(error)
          })
        },

        getStudentProfileById: function () {
          this.$http.get("/student-profile", {
            params: {
              studentProfileId: this.studentProfileId
            }
          })
              .then(response => {
                this.profile = response.data
                console.log(response.data)
              }).catch(error => {
            console.log(error)
          })
        },
        getContactInfo: function () {
          this.$http.get("/contact/id", {
            params: {
              contactId: this.contactId
            }
          })
              .then(response => {
                this.contact = response.data
                console.log(response.data)
              }).catch(error => {
            console.log(error)
          })
        },

        setIsAvailable: function () {
          this.$http.put("/student/id", {}, {
                params: {
                  studentId: this.studentId,
                  isAvailable: this.isAvailable
                }
              }
          ).then(response => {
            console.log(response.data)
          }).catch(error => {
            console.log(error)
          })
        },

        updateStudentProfile: function () {
          this.$http.put("/student-profile/id", this.profile, {
                params: {
                  studentProfileId: this.studentProfileId
                }
              }
          ).then(response => {
            this.setIsAvailable()
            console.log(response.data)
          }).catch(error => {
            console.log(error)
          })
        },

        showProfileView: function () {
          this.profileView = true;
          this.internShipView = false;
          this.courseView = false;
        },
        showInternShipView: function () {
          this.profileView = false;
          this.internShipView = true;
          this.courseView = false;
        },
        showCourseView: function () {
          this.profileView = false;
          this.internShipView = false;
          this.courseView = true;
        },
      },
  mounted() {
    this.getStudentProfileById()
    this.getContactInfo()
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
  float: left;

  margin-right: 100px;
}

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

.upload {
  padding-top: 5px;
  padding-bottom: 5px;
}

.pictureAndForm {
  width: 70%;
  height: auto;
  margin: auto auto 10vh;

}

.card-img-top {
  width: 100%;
  height: auto;
}

#profile {
  float: left;
  width: 30%;
  margin-right: 6%;
}
.btn-primary{
  float: right;
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