<template>
  <div id="userPage">


    <!--    ================================PROFIILIPILT================================-->
    <!--    </div>-->
    <div class="pictureAndForm">
      <div class="card" id="picture">
        <div v-if="picture.base64.length < -1">
          <img src="../assets/default-profile.png" class="card-img-top" alt="">
        </div>
        <div v-else>
          <img :src="picture.base64" class="card-img-top" alt="">
        </div>
        <div class="card-body">
          <h2 class="card-title">{{ this.contact.firstName + ' ' + this.contact.lastName }}</h2>
          <small>About me</small>
          <p class="card-text">
            <input disabled type="text" class="form-control" placeholder="Räägi natuke endast"
                   v-model="profile.aboutMe">
          </p>
        </div>
      </div>

      <!--    ================================PROFIILI ANKEET================================-->

      <div class="card" id="profile">
        <div class="card-body" id="cardBody">
          <div class="form-group" id="formGroup">
            <label class="label-form">Sünniaeg</label>
            <input disabled type="date" class="form-control" placeholder="Sünniaeg" v-model="profile.dateOfBirth">
            <label class="label-form">Linn, kus soovid töötada</label>
            <input disabled type="text" class="form-control" placeholder="Linn" v-model="profile.location">
            <label class="label-form">Sinu oskused</label>
            <input disabled type="text" class="form-control" placeholder="Kirjelda oma oskusi"
                   v-model="profile.competence">
            <label class="label-form">Tugevused</label>
            <input disabled type="text" class="form-control" placeholder="Kirjelda oma tugevusi"
                   v-model="profile.strength">
            <label class="label-form">Minust</label>
            <input disabled type="text" class="form-control" placeholder="Räägi natuke endast"
                   v-model="profile.aboutMe">
            <label class="label-form">LinkedIn</label>
            <input disabled type="text" class="form-control" placeholder="Sinu LinkedIn aadress"
                   v-model="profile.linkedin">
            <label class="label-form">GitHub</label>
            <input disabled type="text" class="form-control" placeholder="Sinu GitHub aadress"
                   v-model="profile.githubLink">
            <label class="label-form">Olen saadaval alates</label>
            <input disabled type="text" class="form-control" placeholder="Millal sooviksid praktikaga alustada?"
                   v-model="profile.availableFrom">
          </div>
          <label class="label-form m-1">Otsin praktikakohta</label>
          <input type="checkbox" v-model="isAvailable" disabled>
        </div>
      </div>
    </div>

    <div>{{this.studentId + ' studentId'}}</div>


    <!--    ================================WORK EXPERIENCE================================-->

    <div class="workAndEducation">
      <h3 id="title-work">Minu töökogemused</h3>
      <table class="table table-hover">
        <thead id="expTable">
        <tr>
          <th scope="col" id="nr">#</th>
          <th scope="col">Alguskuupäev</th>
          <th scope="col">Lõppkuupäev</th>
          <th scope="col">Ettevõtte nimi</th>
          <th scope="col">Ametinimetus</th>
          <th id="jobDescriptionHeader" scope="col">Töö kirjeldus</th>

        </tr>
        </thead>
        <tbody>
        <tr v-for="(experience, index) in workExperiences" id="expFields" style="word-wrap: break-word">
          <th>{{ index + 1 }}</th>
          <td>{{ experience.startDate }}</td>
          <td>{{ experience.endDate }}</td>
          <td>{{ experience.companyName }}</td>
          <td>{{ experience.position }}</td>
          <td id="jobDescription">{{ experience.jobDescription }}</td>

        </tr>
        </tbody>
      </table>
    </div>

    <!--    ================================EDUCATION================================-->

    <div class="workAndEducation">
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
        <tr v-for="(education,index) in educationExperiences" style="word-wrap: break-word">
          <th scope="row">{{ index + 1 }}</th>
          <td>{{ education.startDate }}</td>
          <td>{{ education.endDate }}</td>
          <td id="schoolName">{{ education.school }}</td>
          <td>{{ education.degree }}</td>
          <td id="eduDescription">{{ education.field }}</td>
        </tr>
        </tbody>
      </table>
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
      isAvailable: true,


      contactId: sessionStorage.getItem('contactId'),
      studentId: this.$route.query.id,
      profile: {},
      contact: {},
      picture: {},
      pictureExport: {},
      workExperience: {},
      workExperiences: {},
      workExperienceId: null,
      response: {},
      education: {},
      educationExperience: {},
      educationExperiences: {},
      educationExperienceId: null,
      offerForms: {},


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
          this.showMessage = false
          this.resetOfferView()
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

        showMotivationLetter: function (id) {
          this.showMotivation = true
          this.showOffers = false
          this.getOfferById(id)
        },
        resetOfferView: function () {
          this.showMotivation = false
          this.showOffers = false
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
            window.location.reload();
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
            window.location.reload();
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
            window.location.reload();
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
            window.location.reload();
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

        updateEducationExperienceById: function () {
          this.$http.put("/education-experience/update", this.educationExperience, {
                params: {
                  educationExperienceId: this.educationExperienceId
                }
              }
          ).then(response => {
            window.location.reload();
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
            window.location.reload();
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

        getOffersById: function (id) {
          this.$http.get("/company/all", {
            params: {
              userId: id
            }
          })
              .then(response => {
                this.showOffers = true
                this.showMotivation = false
                this.offerForms = response.data
                console.log(response.data)
              }).catch(error => {
            console.log(error)
          })
        },

        getAllCompanies: function () {
          this.$http.get("/contact/all-companies")
              .then(response => {
                this.companies = response.data
                console.log(response.data)
              }).catch(error => {
            console.log(error)
          })
        },

        getOfferById: function (id) {
          this.$http.get("/company/id", {
            params: {
              offerId: id
            }
          })
              .then(response => {
                this.internship = response.data
              }).catch(error => {
            console.log(error)
          })
        },

        addNewApplicant: function (id, letter) {
          this.$http.post("/applicant/new", {}, {
                params: {
                  studentId: this.studentId,
                  offerId: id,
                  letter: letter
                }
              }
          ).then(response => {
            this.resetOfferView()
            this.showMessage = true
            this.addSuccessMessage = 'Kandideerimise ankeet on edukalt saadetud!'
            console.log(response.data)
          }).catch(error => {
            console.log(error)
          })
        },
        getMyApplications: function () {
          this.$http.get("/applicant/student-id", {
            params: {
              studentId: this.studentId
            }
          })
              .then(response => {
                this.applications = response.data
                console.log(response.data)
              }).catch(error => {
            console.log(error)
          })
        }


      },
  mounted() {
    this.getStudentProfileById()
    this.getContactInfo()
    this.getStudentPicture()
    this.getStudentWorkExperienceById()
    this.getStudentEducationExperienceById()
    this.getAllCompanies()
    this.getMyApplications()


  }

}
</script>

<style scoped>
#pictureAndForm {

}

#companyListTable {

  width: 30vw;
  margin-left: auto;
  margin-right: auto;
}

#offersTable {
  margin-top: 50px;
}

#title-work {
  margin-top: 50px;
  margin-bottom: 30px;

}

#navButtons {
  margin-top: 50px;
}

#jobDescription {
  max-width: 300px;
}

#schoolName {
  max-width: 300px;
}

#eduDescription {
  max-width: 300px;
}


#title-work2 {
  margin-top: 50px;
  margin-bottom: 30px;
}

#title-edu1 {
  margin-top: 50px;
  margin-bottom: 30px;
  border: 2px solid red;

}

#title-edu2 {
  margin-top: 50px;
  margin-bottom: 30px;
}

#motButtons {
  margin-top: 30px;
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
  padding: 5px;
  max-width: 100%;
  height: auto;

  /*border: 2px solid red;*/
}


.pictureAndForm {
  width: 70%;
  height: auto;
  margin-top: 50px;
  margin-left: auto;
  margin-right: auto;

}


#submit {
  margin-top: 20px;
  margin-bottom: 20px;
}

#detailsTable {
  max-width: 300px;
  margin-left: auto;
  margin-right: auto;
}

#motivationField {
  max-width: 30vw;
  height: 10vw;
  margin-left: auto;
  margin-right: auto;
  padding-top: 0;
  padding-left: 0;
  line-height: 1em;

}

#internshipTitle {
  margin-bottom: 30px;
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

#submit-1 {
  float: right;
  margin-left: auto;
}

#submit-2 {
  float: right;
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


#nr {
  width: 30px;
}


</style>