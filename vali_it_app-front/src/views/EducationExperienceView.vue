<template>
  <div>
    <div class="button">
      <button type="button" class="btn btn-primary" v-on:click="getStudentEducationExperienceById()">
        Kuva hariduskogemused
      </button>
      <button type="button" class="btn btn-primary">Peida hariduskogemused</button>
    </div>


    <div class="table">
      <table class="table table-hover">

        <thead>
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
          <th scope="row">{{index+1}}</th>
          <td>{{ education.startDate }}</td>
          <td>{{ education.endDate }}</td>
          <td>{{ education.school }}</td>
          <td>{{ education.degree }}</td>
          <td>{{ education.field }}</td>
          <td>
            <button type="submit" class="btn btn-primary" v-on:click="updateEducationExperienceById(education.id)">
              Muuda haridust
            </button>
            <button type="submit" class="btn btn-primary" v-on:click="deleteEducationExperienceById(education.id)">
              Kustuta haridus
            </button>

          </td>
        </tr>
        </tbody>

      </table>
    </div>

    {{ studentId }}
    {{ educationExperienceId }}

    <div>
      <div class="table">
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

      </div>
      <div class="button2">
        <button class="btn btn-primary" v-on:click="updateEducationExperienceById">Uuenda haridus</button>
      </div>

    </div>


  </div>
</template>

<script>
export default {
  name: "EducationExperienceView",
  data: function () {
    return {
      educationExperience: {},
      educationExperiences: {},
      educationExperienceId: null,
      studentId: sessionStorage.getItem('studentId'),
      education: {}
    };
  },

  methods: {

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
  },


  mounted() {
    this.getStudentEducationExperienceById()


  }
}




</script>

<style scoped>

</style>