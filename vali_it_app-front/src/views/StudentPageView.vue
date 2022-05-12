<template>
  <div id="userPage">

    <div >
      <button id="backButton" type="button" class="btn btn-warning" @click="getApplicantProfile">Tagasi</button>
    </div>
    <h3 id="studentTitle"> <strong> Õpilase profiil</strong></h3>

    <!--    ================================PROFIILIPILT================================-->
    <!--    </div>-->
    <div class="pictureAndForm">
      <div class="card" id="picture">
        <div>
          <img :src="picture.base64" class="card-img-top" alt="">
        </div>
        <div class="card-body">
          <h2 class="card-title">{{ this.contact.firstName + ' ' + this.contact.lastName }}</h2>

        </div>
      </div>

      <!--    ================================PROFIILI ANKEET================================-->

      <div class="card" id="profile">
        <div class="card-body" id="cardBody">
          <div class="form-group" id="formGroup">
            <label class="label-form">Sünniaeg</label>
            <input disabled type="date" class="form-control" placeholder="Sünniaeg" v-model="profile.dateOfBirth">
            <label class="label-form">Linn, kus soovib töötada</label>
            <input disabled type="text" class="form-control" placeholder="Linn" v-model="profile.location">
            <label class="label-form">Oskused</label>
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
      showOffers: false,
      showApplicants: true


    }
  },
  methods:
      {
        hideTable: function () {
          this.displayTable = false
        },

        getApplicantProfile: function (showOffers, showApplicants) {
          this.$router.push({name:'company-page', query:{x:showOffers, y: showApplicants}})
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


        getStudentProfileById: function () {
          this.$http.get("/profile/id", {
            params: {
              studentId: this.studentId
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
          this.$http.get("/profile/name", {
            params: {
              studentId: this.studentId
            }
          })
              .then(response => {
                this.contact = response.data
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
  margin-top: 20px;
  margin-left: auto;
  margin-right: auto;

}
#studentTitle{
  margin-top: 30px;
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


.btn-group {
  margin-bottom: 50px;

}



#nr {
  width: 30px;
}

#backButton {
  float: left;
  margin-left: 30px;
}




</style>