<template>
  <div>

    <button type="button" class="btn btn-outline-dark" v-on:click="getStudentWorkExperienceById(studentId)">
      Dark
    </button>
<!--    <div v-if="tableDivDisplay"></div>-->
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
        <tr v-for="response in workExperiences">
          <th scope="row">*</th>
          <td>{{ response.startDate }}</td>
          <td>{{ response.endDate }}</td>
          <td>{{ response.companyName }}</td>
          <td>{{ response.position }}</td>
          <td>{{ response.jobDescription }}</td>
          <td>

          </td>
        </tr>
        </tbody>

      </table>
      {{ studentId }}


      <div>
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

          <button class="btn btn-primary" v-on:click="addNewWork()">Submit</button>
        </form>

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
      studentId: sessionStorage.getItem('studentId'),
      // tableDivDisplay: true,
      response: {},
    }
  },
  methods: {

    // displayTableDiv: function () {
    //   this.tableDivDisplay = true
    // },
    //
    // hideTableDiv: function () {
    //   this.tableDivDisplay = false
    // },


    addNewWork: function () {
      this.$http.post("/work-experience/add", this.workExperience
      ).then(response => {
        console.log(response.data)
      }).catch(error => {
        console.log(error)
      })
    },


    getStudentWorkExperienceById: function (id) {
      this.$http.get("/work-experience/all", {
            params: {
              studentId: id
            }
          }
      ).then(response => {
        this.response = response.data
        console.log(response.data)
      }).catch(error => {
        console.log(error)
      })
    },

    mounted() {
      this.getStudentWorkExperienceById(this.studentId)

    },
  },

}


</script>

<style scoped>

.form {
  display: inline-block;
  margin: auto 98vh;
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