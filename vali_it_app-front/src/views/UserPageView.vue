<template>
  <div>

    <div class="btn-group" role="group" aria-label="Basic example">
      <button type="button" class="btn btn-dark" @click="showProfileView">Minu profiil</button>
      <button type="button" class="btn btn-dark" @click="showInternShipView">Minu praktika</button>
      <button type="button" class="btn btn-dark" @click="showCourseView">Näita kandideerimisi</button>
    </div>

    <div v-if="profileView">

    </div>
    <div class="workExperience" v-if="profileView">

    </div>


    <!--    </div>-->


    <div class="pictureAndForm">
      <div class="card" id="picture">
        <!--            <div v-if="picture.base64 === null">-->
        <!--              <img src="../assets/default-profile.png" class="card-img-top" alt="">-->
        <!--            </div>-->
        <!--            <div v-else>-->
        <img :src="picture.base64" class="card-img-top" alt="">
        <!--            </div>-->
        <div class="card-body">
          <div class="upload-button">
            <input type="file" @change="handleImage" accept="image/x-png,image/jpeg">
            <button v-on:click="addPicture" type="button" class="btn btn-outline-link btn-sm m-3">Lisa pilt</button>
            <button v-on:click="deletePicture" type="button" class="btn btn-outline-link btn-sm">Eemalda pilt
            </button>
          </div>
          <h5 class="card-title">{{ this.contact.firstName + ' ' + this.contact.lastName }}</h5>
          <small>About me</small>
          <p class="card-text">
            <input type="text" class="form-control" placeholder="Räägi natuke endast" v-model="profile.aboutMe">
          </p>
        </div>
      </div>


      <div class="card" id="profile">
        <div class="card-body" id="cardBody">
          <StudentProfile :profile="profile"/>
          <label class="label-form m-1">Otsin praktikakohta</label>
          <input type="checkbox" v-model="isAvailable">

        </div>

      </div>
    </div>

    <button id="submit" class="btn btn-primary btn-lg" v-on:click="updateStudentProfile">Uuenda profiili</button>


    <div class="workExperience" v-if="showExperience">
      <h3 id="title">Minu töökogemused</h3>
      <table class="table table-hover">
        <thead id="expTable">
        <tr>
          <th scope="col">#</th>
          <th scope="col">Alguskuupäev</th>
          <th scope="col">Lõppkuupäev</th>
          <th scope="col">Ettevõtte nimi</th>
          <th scope="col">Ametinimetus</th>
          <th scope="col">Töö kirjeldus</th>
          <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="(experience, index) in workExperiences">
          <td>{{ index + 1 }}</td>
          <td>{{ experience.startDate }}</td>
          <td>{{ experience.endDate }}</td>
          <td>{{ experience.companyName }}</td>
          <td>{{ experience.position }}</td>
          <td>{{ experience.jobDescription }}</td>
          <td>
            <button type="submit" class="btn btn-primary btn-xs m-3"
                    @click="hideExperienceTable(experience.id)">Muuda
            </button>
            <button type="submit" class="btn btn-primary btn-xs"
                    @click="deleteWorkExperienceById(experience.id)">
              Kustuta
            </button>
          </td>
        </tr>
        </tbody>
      </table>
      <button id="addNew" type="submit" class="btn btn-success btn-xs" @click="displayNewExperience">
        Loo uus töökogemus
      </button>
    </div>
    <div class="table">
      <form>
        <div class="workExperience" v-if="!showExperience">
          <h3 id="title-2">Minu töökogemused</h3>
          <div class="form-group">
            <label class="label-form">Alguskuupäev</label>
            <input type="date" class="form-control" placeholder="Kuupäev" v-model="workExperience.startDate">

            <label class="label-form">Lõppkuupäev</label>
            <input type="date" class="form-control" placeholder="Kuupäev" v-model="workExperience.endDate">

            <label class="label-form">Ettevõtte nimi</label>
            <input type="text" class="form-control" placeholder="Ettevõtte nimi" v-model="workExperience.companyName">

            <label class="label-form">Ametinimetus</label>
            <input type="text" class="form-control" placeholder="Ametinimetus" v-model="workExperience.position">

            <label class="label-form">Töö kirjeldus</label>
            <input type="text" class="form-control" placeholder="Töö kirjeldus" v-model="workExperience.jobDescription">
          </div>
          <div v-if="!addNew">
          <button class="btn btn-success" v-on:click="addNewWork()">Loo uus töökogemus</button>
          </div>
          <div v-if="addNew">
          <button class="btn btn-primary" v-on:click="updateWorkExperienceById()">Uuenda andmed</button>
          </div>
        </div>
      </form>
    </div>
    <div class="newExperience" v-if="displayExperience">




    </div>




  </div>
</template>

<script>
import StudentProfile from "@/components/StudentProfile";

export default {
  name: "UserPageView",
  components: {StudentProfile},
  data: function () {
    return {
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
      displayPic: false,
      workExperience: {},
      workExperiences: {},
      workExperienceId: null,
      response: {},
      displayTable: false,
      showExperience: true,
      displayExperience: false,
      addNew: false,
    }
  },
  methods:
      {
        displayNewExperience: function () {
          this.showExperience = false
          this.displayExperience = true

        },


        hideExperienceTable: function (id) {
          this.workExperienceId = id
          this.showExperience = false
          this.getWorkExperienceById()
        },
        hideTable: function () {
          this.displayTable = false
        },
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
        getStudentWorkExperienceById: function () {
          this.$http.get("/work-experience/all", {
                params: {
                  studentId: this.studentId
                }
              }
          ).then(response => {
            this.workExperiences = response.data
            console.log(response.data)
          }).catch(error => {
            console.log(error)
          })
        },

        updateWorkExperienceById: function () {
          this.$http.put("/work-experience/update", this.workExperience, {
                params: {
                  workExperienceId: this.workExperienceId
                }
              }
          ).then(response => {
            this.showExperience = true
            console.log(response.data)
          }).catch(error => {
            console.log(error)
          })
        },

        deleteWorkExperienceById: async function (experienceId) {
          await this.$http.delete("/work-experience/delete", {
                params: {
                  workExperienceId: experienceId
                }
              }
          ).then(response => {
            this.getStudentWorkExperienceById()
            console.log(response.data)
          }).catch(error => {
            console.log(error)
          })
        },
        getWorkExperienceById: function () {
          this.$http.get("/work-experience/id", {
            params: {
              workExperienceId: this.workExperienceId
            }
          })
              .then(response => {
                this.workExperience = response.data
                console.log(response.data)
              }).catch(error => {
            console.log(error)
          })
        },
        addNewWork: function () {
          this.$http.post("/work-experience/add", this.workExperience, {
                params: {
                  studentId: this.studentId
                }
              }
          ).then(response => {
            this.showExperience = true
            this.displayExperience = false
            console.log(response.data)
          }).catch(error => {
            console.log(error)
          })
        },

      },
  mounted() {
    this.getStudentProfileById()
    this.getContactInfo()
    this.getStudentPicture()
    this.getStudentWorkExperienceById()

  }


}
</script>

<style scoped>
#title {
  margin-top: 50px;
  margin-bottom: 30px;

}

#title-2 {
  margin-top: 50px;
  margin-bottom: 30px;

}

/*.workExperience{*/
/*  margin-top: 50px;*/

/*}*/

StudentProfile {
  width: 70%;
  margin-left: -200px;
}


div.form-group label {
  text-align: left;
  margin-top: 10px;
  padding: 5px;

}

div.form-group label:after {
  content: ":";
}

img {

  max-width: 100%;
  height: auto;
  /*border: 2px solid red;*/
}


.pictureAndForm {
  width: 70%;
  height: auto;
  margin: auto;

}

#submit {
  margin-top: 20px;
  margin-bottom: 20px;
}


#picture {
  float: left;
  width: 30%;
  height: auto;
  margin-left: 150px;
  /*border: 2px solid green;*/

}
#profile {
  width: 25%;
  /*border: 2px solid blue;*/
  margin: auto 60vh auto;

}
#addNew{
  float: right;
  margin-right: 50px;
}

</style>