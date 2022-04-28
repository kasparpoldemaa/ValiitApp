<template>
  <div>
    <div v-if="studentPage === roleId">
      <button v-on:click="showProfile" type="button" class="btn btn-outline-danger">Minu profiil</button>
      <button v-on:click="showInternship" type="button" class="btn btn-outline-success m-3">Minu praktika</button>
      <button v-on:click="showCourse" type="button" class="btn btn-outline-success m-3">Minu kursus</button>
    </div>


  </div>
</template>

<script>
export default {
  name: "UserPageView",
  data: function () {
    return {
      adminPage: 1,
      studentPage: 2,
      companyPage: 3,
      roleId: null,
      showProfile: false,
      showInternship: false,
      showCourse: false


    }
  },


}
</script>

<style scoped>

</style>