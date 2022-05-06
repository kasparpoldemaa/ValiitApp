<template>
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
          <input type="text" class="form-control" placeholder="Kraad" v-model="educationExperience.field">

          <label class="label-form">Eriala</label>
          <input type="text" class="form-control" placeholder="Eriala" v-model="educationExperience.degree">
        </div>
      </form>

    </div>

    <div class="button2">
      <button class="btn btn-primary" v-on:click="addNewEducation()">Lisa uus haridus</button>
    </div>


  </div>
</template>

<script>
export default {
  name: "AddEducationExperienceView",
  data: function () {
    return {
      educationExperience: {},
      studentId: sessionStorage.getItem('studentId'),

    };
  },

  methods: {
    addNewEducation: function () {
      this.$http.post("/education-experience/add", this.educationExperience, {
            params: {
              studentId: this.studentId
            }
          }
      ).then(response => {
        console.log(response.data)
      }).catch(error => {
        console.log(error)
      })
    },
  }

}
</script>

<style scoped>

</style>