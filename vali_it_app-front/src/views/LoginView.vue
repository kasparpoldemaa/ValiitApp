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
                <span class="input-group-text"><i class="fas fa-user"></i></span>
              </div>
              <input type="text" class="form-control" placeholder="e-mail">

            </div>
            <div class="input-group form-group">
              <div class="input-group-prepend">
                <span class="input-group-text"><i class="fas fa-key"></i></span>
              </div>
              <input type="password" class="form-control" placeholder="parool">
            </div>
            <div class="row align-items-center remember">
              <input type="checkbox">Mäleta mind
            </div>
            <div class="form-group">
              <input type="submit" value="Logi sisse" class="btn float-right login_btn" v-on:click="saveDataToSessionStorage">
            </div>
          </form>
        </div>
        <div class="card-footer">
          <div class="d-flex justify-content-center links">
            Don't have an account?<a href="#">Sign Up</a>
          </div>
          <div class="d-flex justify-content-center">
            <a href="#">Forgot your password?</a>
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

  }
}
</script>

<style scoped>
img {
  width:  20vw;
  height: auto;
}
</style>