<template>
  <div id="userPage">

    <div id="navButtons" class="btn-group" role="group" aria-label="Basic example">
      <button type="button" class="btn btn-primary btn-lg" @click="showProfileView">Minu profiil</button>
      <button type="button" class="btn btn-primary btn-lg" @click="showInternShipView">Minu praktika</button>
      <button type="button" class="btn btn-primary btn-lg" @click="showCourseView">Minu kursus</button>
    </div>


    <div class="workExperience" v-if="profileView">

      <!--    ================================PROFIILIPILT================================-->
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
          <h3 id="title-work"><strong>Minu töökogemused</strong></h3>
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
              <td style="float: right">
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
          <button id="addNewWork" type="submit" class="btn btn-default btn-xs" @click="displayNewExperience">
            Loo uus töö
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
                <input type="text" class="form-control" placeholder="Ettevõtte nimi"
                       v-model="workExperience.companyName">

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
          <h3 id="title-edu1"><strong>Minu haridus</strong></h3>
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
              <td style="float: right">
                <button type="submit" class="btn btn-primary btn-xs m-3" v-on:click="hideEducationTable(education.id)">
                  Muuda
                </button>
                <button type="submit" class="btn btn-primary btn-xs"
                        v-on:click="deleteEducationExperienceById(education.id)">
                  Kustuta
                </button>
              </td>
            </tr>
            </tbody>
          </table>
          <button id="addNewEdu" type="submit" class="btn btn-default btn-xs" @click="displayNewEducation">
            Loo uus kool
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

    <div class="internship" v-if="internShipView">

      <h3 id="internshipTitle"><strong>Praktika pakkumised</strong></h3>
      <div v-if="showMessage" class="alert alert-success" role="alert">
        {{ addSuccessMessage }}
      </div>
      <table id="companyListTable" class="table table-hover">
        <thead>
        <tr>
          <th scope="col">Firma nimi</th>
          <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="company in companies">


          <td>{{ company.companyName }}</td>
          <td>
            <button type="button" class="btn btn-info" @click="getOffersById(company.userId)">Vaata pakkumisi <span
                class="badge badge-light">{{ company.applicationCount }}</span>
            </button>
          </td>

        </tr>
        </tbody>
      </table>

      <!--      <h3 id="applyTitle"> Minu kandideerimised </h3>-->
      <!--      <table class="table table-hover">-->
      <!--        <thead>-->
      <!--        <tr>-->
      <!--          <th scope="col">Algus kuupäev</th>-->
      <!--          <th scope="col">Kestvus</th>-->
      <!--          <th scope="col">Asukoht</th>-->
      <!--          <th scope="col">Vabad kohad</th>-->
      <!--          <th scope="col">Kasutusel tehnoloogiad</th>-->
      <!--          <th scope="col">Töövorm</th>-->
      <!--          <th scope="col">Tasu</th>-->
      <!--          <th scope="col">Lisainfo</th>-->
      <!--        </tr>-->
      <!--        </thead>-->
      <!--        <tbody>-->
      <!--        <tr v-for="application in applications">-->
      <!--          <td>{{ application.data.startTime }}</td>-->
      <!--          <td>{{ application.data.duration }}</td>-->
      <!--          <td>{{ application.data.location }}</td>-->
      <!--          <td>{{ application.data.numberOfPositions }}</td>-->
      <!--          <td>{{ application.data.technology }}</td>-->
      <!--          <td>{{ application.data.workType }}</td>-->
      <!--          <td>{{ application.data.isPayable ? 'jah' : 'ei'}}</td>-->
      <!--          <td>{{ application.data.comment }}</td>-->
      <!--        </tr>-->
      <!--        </tbody>-->
      <!--      </table>-->


      <table id="offersTable" class="table table-hover" v-if="showOffers">
        <thead>
        <tr>
          <th scope="col">Algus kuupäev</th>
          <th scope="col">Kestvus</th>
          <th scope="col">Asukoht</th>
          <th scope="col">Vabad kohad</th>
          <th scope="col">Kasutusel tehnoloogiad</th>
          <th scope="col">Töövorm</th>
          <th scope="col">Tasu</th>
          <th scope="col">Lisainfo</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="offerForm in offerForms">
          <td>{{ offerForm.startTime }}</td>
          <td>{{ offerForm.duration }}</td>
          <td>{{ offerForm.location }}</td>
          <td>{{ offerForm.numberOfPositions }}</td>
          <td>{{ offerForm.technology }}</td>
          <td>{{ offerForm.workType }}</td>
          <td>{{ offerForm.isPayable ? 'jah' : 'ei' }}</td>
          <td>{{ offerForm.comment }}</td>
          <td>
            <button type="button" class="btn btn-info" @click="showMotivationLetter(offerForm.id)">Kandideeri
            </button>
          </td>
        </tr>
        </tbody>
      </table>
      <div v-if="showMotivation">
        <h3><strong>Ülevaade pakkumisest </strong></h3>

        <table class="table table-hover" id="detailsTable">
          <thead>

          </thead>
          <tbody>
          <tr>
            <td>Asukoht:</td>
            <td>{{ internship.location }}</td>
          </tr>
          <tr>
            <td>Kestvus:</td>
            <td>{{ internship.duration }}</td>
          </tr>
          <tr>
            <td>Tehnoloogia:</td>
            <td>{{ internship.technology }}</td>
          </tr>
          <tr>
            <td>Töövorm:</td>
            <td>{{ internship.workType }}</td>
          </tr>
          <tr>
            <td>Tasu:</td>
            <td>{{ internship.isPayable ? 'jah' : 'ei' }}</td>
          </tr>
          <tr>
            <td>Vabad kohad:</td>
            <td>{{ internship.numberOfPositions }}</td>
          </tr>
          </tbody>
        </table>
        <label id="motLabel" class="label-form">Motivatsioonikiri:</label>
        <textarea id="motivationField" class="form-control" placeholder="Max 1000 tähemärki"
                  v-model="letter"></textarea>

        <div id="motButtons" class="motButtons">
          <button type="button" class="btn btn-info m-3" @click="addNewApplicant(internship.id, letter)">Kandideeri
            praktikale
          </button>
          <button type="button" class="btn btn-danger" @click="resetOfferView">Tühista</button>
        </div>


      </div>


    </div>

    <div class="courses" v-if="courseView">


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
      profileView: true,
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
      offerForms: {},
      companies: {},
      offerId: null,
      internship: {},
      showMotivation: false,
      showOffers: false,
      letter: '',
      addSuccessMessage: '',
      showMessage: false,
      applications: {}


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

}

#title-edu2 {
  margin-top: 50px;
  margin-bottom: 30px;
}

#motButtons {
  margin-top: 30px;
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
  padding: 5px;
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

/*.btn btn-default btn-xs{*/
.btn-default, .btn-default:hover, .btn-default:active, .btn-default:visited {
  background-color: #16A085 !important;
  color: white;
}

.workExperience {
  margin-bottom: 30vh;
}

</style>