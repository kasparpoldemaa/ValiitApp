<template>
  <div>
    <div class="btn-group btn-group-toggle" data-toggle="buttons">
      <label class="btn btn-success active btn-lg">
        <input type="radio" name="options" id="option1" autocomplete="off" checked v-on:click="showProfile"> Minu profiil
      </label>
      <label class="btn btn-info btn-lg">
        <input type="radio" name="options" id="option2" autocomplete="off" v-on:click="showInternship"> Minu praktika
      </label>
      <label class="btn btn-info btn-lg">
        <input type="radio" name="options" id="option3" autocomplete="off"> Minu kursus
      </label>
    </div>
    <br>
    <br>
    <form action="/action_page.php">
      <div class="form-group">
        <label >Eesnimi:</label>
        <input  type="text" class="form-control" placeholder="Eesnimi" v-model="contact.firstName">
        <label >Perekonnanimi:</label>
        <input type="text" class="form-control" placeholder="Perekonnanimi" v-model="contact.lastName">
        <label >Sünniaeg:</label>
        <input type="date" class="form-control" placeholder="YYYY-MM-DD">
        <label >Elukoht:</label>
        <input type="text" class="form-control" placeholder="Elukoht">
        <label >Sinu oskused:</label>
        <input type="text" class="form-control" placeholder="Kirjelda oma oskusi, mida oskad teha">
        <label >Tugevused:</label>
        <input type="text" class="form-control" placeholder="Kirjelda oma tugevusi">
        <label >Minust:</label>
        <input type="text" class="form-control" placeholder="Räägi natuke endast">
        <label >LinkedIn:</label>
        <input type="text" class="form-control" placeholder="Sinu LinkedIn aadress">
        <label >GitHub:</label>
        <input type="text" class="form-control" placeholder="Sinu GitHub aadress">
        <label >Olen saadaval alates:</label>
        <input type="text" class="form-control" placeholder="Millal saaksid praktikaga alustada?">
      </div>
      <div class="form-group form-check">
        <label class="form-check-label">
          <input class="form-check-input" type="checkbox"> Otsin praktikakohta
        </label>
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
    </form>



    <div>{{'this is session roleID: ' + roleId}}</div>
    <div>{{'this is session userID: ' +userId}}</div>
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
      roleId: sessionStorage.getItem('roleId'),
      userId: sessionStorage.getItem('userId'),
      showProfile: false,
      showInternship: false,
      showCourse: false,
      contact: {}


    }
  },
  methods:
      {

      },
  mounted(){

  }


}
</script>

<style scoped>
body {
  text-align: center;
}


form {
  display: inline-block;
  size: 100px;
}
</style>