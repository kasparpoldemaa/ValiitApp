<template>
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

    </div>
    <div class="button2">
      <button class="btn btn-primary" v-on:click="addNewWork()">Lisa uus töökogemus</button>
    </div>

  </div>
</template>

<script>
export default {
  name: "AddWorkExperience",
  data: function () {
    return {
      workExperience: {},
      studentId: sessionStorage.getItem('studentId'),

    };
  },

  methods: {
    addNewWork: function () {
      this.$http.post("/work-experience/add", this.workExperience, {
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