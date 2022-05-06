<template>

  <!--  // Muuda töökogemust tabel avaneb siis, kui õpilane vajutab muuda-->
  <!--// kaota töökogemused nupp ka-->
<!--  Kuva töökogemused kronoloogilises järjekorras-->
<!--  warning-kas ole dkindel, et soovid kustutada-->


  <div>
    <div class="button">
      <button type="button" class="btn btn-primary" v-on:click="getStudentWorkExperienceById()">
        Kuva töökogemused
      </button>
      <button type="button" class="btn btn-primary">Peida töökogemused</button>
    </div>
<!--    <div v-if="tableDivDisplay">-->
      <div class="table">
        <table class="table table-hover">

          <thead>
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
          <tr v-for="experience in workExperiences">
            <th scope="row">*</th>
            <td>{{ experience.startDate }}</td>
            <td>{{ experience.endDate }}</td>
            <td>{{ experience.companyName }}</td>
            <td>{{ experience.position }}</td>
            <td>{{ experience.jobDescription }}</td>
            <td>
              <button type="submit" class="btn btn-primary" v-on:click="updateWorkExperienceById(experience.id)">Muuda
                töökogemust
              </button>
              <button type="submit" class="btn btn-primary" v-on:click="deleteWorkExperienceById(experience.id)">Kustuta
                töökogemus
              </button>

            </td>
          </tr>
          </tbody>

        </table>
      </div>
<!--    </div>-->
    {{ studentId }}
    {{ workExperienceId }}

    <div>
      <div class="table">
        <form>

          <div class="form">
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
        </form>
        <button class="btn btn-primary" v-on:click="updateWorkExperienceById()">Uuenda töökogemus</button>
      </div>
      <div class="button2">

      </div>

    </div>
  </div>
</template>

<script>
export default {
  name: "WorkExperienceView",
  data: function () {
    return {
      workExperience: {},
      workExperiences: {},
      workExperienceId: null,
      studentId: sessionStorage.getItem('studentId'),
      // tableDivDisplay: true,
      response: {}
    };
  },
  methods: {

    // displayTableDiv: function () {
    //   this.tableDivDisplay = true
    // },
    //
    // hideTableDiv: function () {
    //   this.tableDivDisplay = false
    // },


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

    updateWorkExperienceById: function (experienceId) {
      this.$http.put("/work-experience/update", this.workExperience,{
            params: {
              workExperienceId: experienceId
            }
          }
      ).then(response => {
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

    mounted() {
      this.getStudentWorkExperienceById()


    },
  },

}


</script>

<style scoped>

.button {
  margin-top: 2vh;
  margin-bottom: 2vh;
}

.button2 {
  margin-top: 2vh;
  margin-bottom: 2vh;
  display: inline-block;

}

.table {
  margin-top: 7vh;
  margin-bottom: 7vh;

}

.form {
  display: inline-block;
  margin: auto 39%;
  /*border: 2px solid red;*/
  /*margin-right: 100px;*/
}

div.form {
  display: grid;
  grid-template-columns: max-content max-content;
  grid-gap: 10px;
}

div.form label {
  text-align: right;
  margin-top: 10px
}

div.form label:after {
  content: ":";
}

</style>