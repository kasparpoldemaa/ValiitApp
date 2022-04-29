<template>
<div class="login">
  <img alt="BCS_logo" src="../assets/BCS_logo.png">
  <body>
  <div class="container">
    <div class="d-flex justify-content-center h-100">
      <div class="card">
        <div class="card-header">
          <h3>Logi sisse</h3>
        </div>
        <div class="card-body">
          <form>
            <div class="input-group form-group">
              <div class="input-group-prepend">
                <span class="input-group-text"><i class="fas fa-user">
                  <img class="ui-menu-icons" alt="email" src="../assets/email.png">

                </i></span>
              </div>
              <input type="text" class="form-control" placeholder="e-mail">

            </div>
            <div class="input-group form-group">
              <div class="input-group-prepend">
                <span class="input-group-text"><i class="fas fa-key">
                  <img class="ui-menu-icons" alt="key" src="../assets/key.png">

                </i></span>
              </div>
              <input type="password" class="form-control" placeholder="parool">
            </div>
            <div class="remember">
              <input type="checkbox"> Mäleta mind
            </div>
            <div class="form-group">
              <input type="submit" value="Logi sisse" class="btn float-right login_btn" v-on:click="saveDataToSessionStorage ,navigateToUserPage()">
            </div>
          </form>
        </div>
        <div class="card-footer">
          <div class="create-user">
            Pole veel kasutajat? <a href="#" v-on:click="navigateToSignUp()">Loo kasutaja</a>
          </div>
          <div class="d-flex justify-content-center">
            <a href="#">Unustasid parooli?</a>
          </div>
        </div>
      </div>
    </div>
  </div>
  </body>
</div>
</template>

<script>
export default {
  name: "LoginView",
  data: function () {
    return {

    }
  },
  methods: {
    saveDataToSessionStorage: function () {
      sessionStorage.setItem('userId', this.user.id)
      sessionStorage.setItem('roleId', this.role.id)
    },
    navigateToSignUp: function () {
      this.$router.push({name: 'sign-up'})
    },
    navigateToUserPage: function () {
      this.$router.push({name: 'user-page'})
    },


  }
}
</script>

<style scoped>
img {
  width:  25vw;
  height: auto;
}
.ui-menu-icons{
  width: 18px;
  height: auto;

}
.login_btn{
  background-color: blue;
  color: white;
}
.login_btn:hover{
  color: white ;
  background-color: deepskyblue;
}

</style>