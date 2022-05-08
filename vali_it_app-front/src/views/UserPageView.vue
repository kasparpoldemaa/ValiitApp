<template>
  <div>

    <div class="btn-group" role="group" aria-label="Basic example">
      <button type="button" class="btn btn-primary" @click="showProfileView">Minu profiil</button>
      <button type="button" class="btn btn-primary" @click="showInternShipView">Minu praktika</button>
      <button type="button" class="btn btn-primary" @click="showCourseView">Näita kandideerimisi</button>
    </div>

    <!--    ================================PROFIILIPILT================================-->

    <div class="workExperience" v-if="profileView">
      <!--    </div>-->
      <div class="pictureAndForm">
        <div class="card" id="picture">
          <!--        <div v-if="picture.base64.length > -1">-->
          <!--          <img src="../assets/default-profile.png" class="card-img-top" alt="">-->
          <!--        </div>-->
          <!--        <div v-else>-->
          <img :src="picture.base64" class="card-img-top" alt="">
          <!--        </div>-->
          <div class="card-body">
            <div class="upload-button">
              <input type="file" @change="handleImage" accept="image/x-png,image/jpeg">
              <button v-on:click="addPicture" type="button" class="btn btn-outline-link btn-sm m-3">Lisa pilt</button>
              <button v-on:click="deletePicture" type="button" class="btn btn-outline-link btn-sm">Eemalda pilt
              </button>
            </div>
            <h2 class="card-title">{{ this.contact.firstName + ' ' + this.contact.lastName }}</h2>
            <small>About me</small>
            <p class="card-text">
              <input type="text" class="form-control" placeholder="Räägi natuke endast" v-model="profile.aboutMe">
            </p>
          </div>
        </div>

        <!--    ================================PROFIILI ANKEET================================-->

        <div class="card" id="profile">
          <div class="card-body" id="cardBody">
            <StudentProfile :profile="profile"/>
            <label class="label-form m-1">Otsin praktikakohta</label>
            <input type="checkbox" v-model="isAvailable">
          </div>
        </div>
      </div>

      <button id="submit" class="btn btn-primary btn-lg" v-on:click="updateStudentProfile">Uuenda profiili</button>


      <!--    ================================WORK EXPERIENCE================================-->

      <div class="workAndEducation" v-if="showExperience">
        <h3 id="title-work">Minu töökogemused</h3>
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
            <th>{{ index + 1 }}</th>
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
        <button id="addNewWork" type="submit" class="btn btn-success btn-xs" @click="displayNewExperience">
          Loo uus töökogemus
        </button>
      </div>

      <!--    ================================LISA/UUENDA WORK EXPERIENCE================================-->

      <div class="table">
        <form>
          <div class="workAndEducation" id="updateWorkExperience" v-if="!showExperience">
            <h3 id="title-work2">Minu töökogemused</h3>
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
              <input type="text" class="form-control" placeholder="Töö kirjeldus"
                     v-model="workExperience.jobDescription">
            </div>
            <div v-if="!showWorkTable">
              <button class="btn btn-primary m-3" v-on:click="updateWorkExperienceById()">Uuenda andmed</button>
              <button class="btn btn-danger" v-on:click="resetView">Tühista</button>
            </div>
            <div v-if="showWorkTable">
              <button class="btn btn-success m-3" v-on:click="addNewWork">Loo uus töökogemus</button>
              <button class="btn btn-danger" v-on:click="resetView">Tühista</button>
            </div>
          </div>
        </form>
      </div>

      <!--    ================================EDUCATION================================-->

      <div class="workAndEducation" v-if="showEducation">
        <h3 id="title-edu1">Minu haridus</h3>
        <table class="table table-hover">
          <thead id="eduTable">
          <tr>
            <th scope="col">#</th>
            <th scope="col">Alguskuupäev</th>
            <th scope="col">Lõppkuupäev</th>
            <th scope="col">Kooli nimi</th>
            <th scope="col">Kraad</th>
            <th scope="col">Eriala</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="(education,index) in educationExperiences">
            <th scope="row">{{ index + 1 }}</th>
            <td>{{ education.startDate }}</td>
            <td>{{ education.endDate }}</td>
            <td>{{ education.school }}</td>
            <td>{{ education.degree }}</td>
            <td>{{ education.field }}</td>
            <td>
              <button type="submit" class="btn btn-primary btn-xs m-3" v-on:click="hideEducationTable(education.id)">
                Muuda (meetod ei funka)
              </button>
              <button type="submit" class="btn btn-primary btn-xs"
                      v-on:click="deleteEducationExperienceById(education.id)">
                Kustuta
              </button>
            </td>
          </tr>
          </tbody>
        </table>
        <button id="addNewEdu" type="submit" class="btn btn-success btn-xs" @click="displayNewEducation">
          Loo uus haridus
        </button>
      </div>


      <div class="workAndEducation" id="updateEducation" v-if="!showEducation">
        <h3 id="title-edu2">Minu haridus</h3>
        <form>

          <div class="form">
            <label class="label-form">Alguskuupäev</label>
            <input type="date" class="form-control" placeholder="Kuupäev" v-model="educationExperience.startDate">

            <label class="label-form">Lõppkuupäev</label>
            <input type="date" class="form-control" placeholder="Kuupäev" v-model="educationExperience.endDate">

            <label class="label-form">Kooli nimi</label>
            <input type="text" class="form-control" placeholder="Kooli nimi" v-model="educationExperience.school">

            <label class="label-form">Kraad</label>
            <input type="text" class="form-control" placeholder="Kraad" v-model="educationExperience.degree">

            <label class="label-form">Eriala</label>
            <input type="text" class="form-control" placeholder="Eriala" v-model="educationExperience.field">
          </div>
        </form>


        <div v-if="!showEduTable">
          <button class="btn btn-primary m-3" v-on:click="updateEducationExperienceById">Uuenda andmed</button>
          <button class="btn btn-danger" v-on:click="resetView">Tühista</button>
        </div>
        <div v-if="showEduTable">
          <button class="btn btn-success m-3" v-on:click="addNewEducation">Loo uus haridus</button>
          <button class="btn btn-danger" v-on:click="resetView">Tühista</button>
        </div>
      </div>


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
      showWorkTable: false,
      showEducation: true,
      showEduTable: false,
      education: {},
      educationExperience: {},
      educationExperiences: {},
      educationExperienceId: null,

    }
  },
  methods:
      {
        resetView: function () {
          this.displayTable = false
          this.showExperience = true
          this.showWorkTable = false
          this.showEducation = true
          this.showEduTable = false
        },

        showProfileView: function () {
          this.profileView = true
          this.internShipView = false
          this.courseView = false
        },

        showInternShipView: function () {
          this.profileView = false
          this.internShipView = true
          this.courseView = false
        },

        showCourseView: function () {
          this.profileView = false
          this.internShipView = false
          this.courseView = true
        },

        displayNewExperience: function () {
          this.showExperience = false
          this.showWorkTable = true
        },

        displayNewEducation: function () {
          this.showEducation = false
          this.showEduTable = true
        },

        hideExperienceTable: function (id) {
          this.workExperienceId = id
          this.showExperience = false
          this.getWorkExperienceById()
        },

        hideEducationTable: function (id) {
          this.educationExperienceId = id
          this.showEducation = false
          this.getEducationExperienceById()
        },

        hideTable: function () {
          this.displayTable = false
        },

        handleImage(event) {
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

        updateWorkExperienceById: async function () {
          await this.$http.put("/work-experience/update", this.workExperience, {
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

        addNewWork: async function () {
          await this.$http.post("/work-experience/add", this.workExperience, {
                params: {
                  studentId: this.studentId
                }
              }
          ).then(response => {
            this.showExperience = true
            this.showWorkTable = false
            console.log(response.data)
          }).catch(error => {
            console.log(error)
          })
        },

        getStudentEducationExperienceById: function () {
          this.$http.get("/education-experience/all", {
                params: {
                  studentId: this.studentId
                }
              }
          ).then(response => {
            this.educationExperiences = response.data
            console.log(response.data)
          }).catch(error => {
            console.log(error)
          })
        },

        updateEducationExperienceById: function (educationId) {
          this.$http.put("/education-experience/update", this.educationExperience, {
                params: {
                  educationExperienceId: educationId
                }
              }
          ).then(response => {
            console.log(response.data)
          }).catch(error => {
            console.log(error)
          })
        },

        deleteEducationExperienceById: async function (educationId) {
          await this.$http.delete("/education-experience/delete", {
                params: {
                  educationExperienceId: educationId
                }
              }
          ).then(response => {
            this.getStudentEducationExperienceById()
            console.log(response.data)
          }).catch(error => {
            console.log(error)
          })
        },

        addNewEducation: function () {
          this.$http.post("/education-experience/add", this.educationExperience, {
                params: {
                  studentId: this.studentId
                }
              }
          ).then(response => {
            this.showEducation = true
            this.showEduTable = false
            console.log(response.data)
          }).catch(error => {
            console.log(error)
          })
        },

        getEducationExperienceById: function () {
          this.$http.get("/education-experience/id", {
            params: {
              educationExperienceId: this.educationExperienceId
            }
          })
              .then(response => {
                this.educationExperience = response.data
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
    this.getStudentEducationExperienceById()

  }

}
</script>

<style scoped>
#title-work {
  margin-top: 50px;
  margin-bottom: 30px;

}


#title-work2 {
  margin-top: 50px;
  margin-bottom: 30px;

}

#title-edu1 {
  margin-top: 50px;
  margin-bottom: 30px;

}

#title-edu2 {
  margin-top: 50px;
  margin-bottom: 30px;
}


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
  margin-left: auto;
  /*border: 2px solid green;*/

}

#profile {
  width: 40vw;
  /*border: 2px solid blue;*/
  margin: auto 60vh auto;

}

#addNewWork {
  float: right;
  margin-right: 50px;
}

#addNewEdu {
  float: right;
  margin-right: 50px;
}

.btn-group {
  margin-bottom: 50px;

}

#updateWorkExperience {
  width: 40vw;
  margin-left: auto;
  margin-right: auto;
}

#updateEducation {
  width: 40vw;
  margin-left: auto;
  margin-right: auto;
}

</style>